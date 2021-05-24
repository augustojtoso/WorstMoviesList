package com.entrevista.worstMovies.repositories;

import com.entrevista.worstMovies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MovieRepository extends JpaRepository<Movie,Long> {

//    @Query("SELECT " +
//                "award1.PRODUCERS as producer, " +
//                "MIN(award2.YEAR - award1.YEAR) as interval, " +
//                "award1.YEAR as previousWin, " +
//                "MIN(award2.YEAR) as followingWin" +
//            "FROM MOVIE award1" +
//                "left join MOVIE award2" +
//                    "on award2.YEAR > award1.YEAR" +
//                    "and award2.PRODUCERS = award1.PRODUCERS" +
//            "where award1.winner = 'yes'" +
//                "AND award2.winner = 'yes'" +
//            "GROUP BY award2.PRODUCERS, award1.PRODUCERS, award1.YEAR" +
//            "ORDER BY (award2.YEAR - award1.YEAR)")
//    List<Object> getAwardIntervalList();

    ArrayList<Movie>  findByWinner(String isWinner);
}
