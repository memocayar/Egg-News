package com.eggnews.eggnews.service;

import com.eggnews.eggnews.entity.NewEntity;
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
    public void saveNew(String title, String body, String image){
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

    public void updateNew(long id, String title, String body, String image){
        Optional<NewEntity> answer = newRepository.findById(id);

        if(answer.isPresent()){
            NewEntity newEntity = answer.get();

            newEntity.setTitle(title);
            newEntity.setBody(body);
            newEntity.setImage(image);

            newRepository.save(newEntity);
        }
    }
}
