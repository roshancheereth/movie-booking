package org.publicissapient.moviesearch.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter @AllArgsConstructor
public class SearchResultDto {
    private Long showId;
    private String movieTitle;
    private String language;
    private String theatre;
    private String city;
    private LocalDate showDate;
    private LocalTime showTime;
}