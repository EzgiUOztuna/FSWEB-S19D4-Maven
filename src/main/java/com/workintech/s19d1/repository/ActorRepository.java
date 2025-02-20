package com.workintech.s19d1.repository;
import com.workintech.s19d1.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    //Optional<Actor> findByFirstNameAndLastName(String firstName, String lastName);
}
