package com.workintech.s19d1.dao;
import com.workintech.s19d1.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActorDao extends JpaRepository<Actor, Long> {
    Optional<Actor> findByName(String firstName, String lastName);
}
