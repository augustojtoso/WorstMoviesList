package com.entrevista.worstMovies.services;

import com.entrevista.worstMovies.entities.Movie;
import com.entrevista.worstMovies.models.AwardInterval;
import com.entrevista.worstMovies.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AwardsService {
    private MovieRepository movieRepository;

    public Map<String, List<AwardInterval>> getIntervalsMapping() {

        ArrayList<Movie> movieListSplited = new ArrayList<>();
        //process movies with multiple producers
        movieRepository.findByWinner("yes").stream()
                .forEach(movie ->
                        Arrays.stream(movie.getProducers().split(",| and "))
                                .map(String::strip)
                                .filter(producer -> !producer.isBlank())
                                .forEach(producer -> movieListSplited.add(Movie.builder()
                                        .producers(producer)
                                        .studios(movie.getStudios())
                                        .title(movie.getTitle())
                                        .year(movie.getYear())
                                        .build())));

        List<AwardInterval> awardIntervalList =  movieListSplited.stream()
                .map(earlyAward -> movieListSplited.stream()
                    .filter(lateAward -> earlyAward.getProducers().equals(lateAward.getProducers()))
                    .filter(lateAward -> lateAward.getYear().compareTo(earlyAward.getYear()) > 0)
                    .sorted(Comparator.comparing(Movie::getYear))
                    .findFirst()
                    .map(followingWin -> AwardInterval.builder()
                            .interval(followingWin.getYear()-earlyAward.getYear())
                            .followingWin(followingWin.getYear())
                            .previousWin(earlyAward.getYear())
                            .producer(earlyAward.getProducers())
                            .build()))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .sorted(Comparator.comparing(AwardInterval::getInterval))
                .collect(Collectors.toList());



        Map<String, List<AwardInterval>>  response = new HashMap<>();
        response.put("min", awardIntervalList.stream()
                .filter(awardInterval -> awardInterval.getInterval() == awardIntervalList.get(0).getInterval())
                .collect(Collectors.toList()));
        response.put("max", awardIntervalList.stream()
                .filter(awardInterval -> awardInterval.getInterval() == awardIntervalList.get(awardIntervalList.size()-1).getInterval())
                .collect(Collectors.toList()));
        return response;
    }
}
