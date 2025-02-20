package com.workintech.s19d1.dto;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

public record MovieActorRequest(Movie movie, Actor actor) {
}
