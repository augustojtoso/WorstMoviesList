package com.entrevista.worstMovies.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Movie {

    private Integer year;
    @Id
    private String title;
    private String studios;
    private String producers;
    private String winner;

    public Movie(){}

    public Movie(Integer year,String title, String studios, String producers, String winner){
        this.year = year;
        this.title = title;
        this.studios = studios;
        this.producers = producers;
        this.winner = winner;
    }

}
