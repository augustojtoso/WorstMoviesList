package com.entrevista.worstMovies.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AwardInterval {
    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;
}
