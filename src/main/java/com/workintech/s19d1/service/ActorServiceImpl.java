package com.workintech.s19d1.service;

import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import com.workintech.s19d1.entity.Actor;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
@AllArgsConstructor
@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(long id) {
        return actorRepository.findById(id).orElseThrow(()-> new ApiException("actor is not found with id: "+id, HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Transactional
    @Override
    public void delete(Actor actor) {
        actorRepository.delete(actor);
    }
}
