package com.eggnews.eggnews.service;

import com.eggnews.eggnews.entity.NewEntity;
import com.eggnews.eggnews.exception.MyException;
import com.eggnews.eggnews.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewService {
    @Autowired
    private NewRepository newRepository;

    @Transactional
    public void saveNew(String title, String body, String image) throws MyException {
        validate(title, body);

        NewEntity newEntity = new NewEntity();
        newEntity.setTitle(title);
        newEntity.setBody(body);
        newEntity.setImage(image);

        newRepository.save(newEntity);
    }

    public List<NewEntity> listNews(){
        List<NewEntity> news = new ArrayList<>();
        news = newRepository.findAll();
        return news;
    }

    public void updateNew(long id, String title, String body, String image) throws MyException {
        //TODO: validar ID
        validate(title, body);
        Optional<NewEntity> answer = newRepository.findById(id);

        if(answer.isPresent()){
            NewEntity newEntity = answer.get();

            newEntity.setTitle(title);
            newEntity.setBody(body);
            newEntity.setImage(image);

            newRepository.save(newEntity);
        }
    }

    private void validate(String title, String body) throws MyException{
        if(title == null || title.isEmpty()){
            throw new MyException("El título no puede ser nulo o estar vacío.");
        }
        if(body == null || body.isEmpty()){
            throw new MyException("El cuerpo no puede ser nulo o estar vacío.");
        }
    }
}
