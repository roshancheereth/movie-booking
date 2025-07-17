package org.publicissapient.moviesearch.dto;

import lombok.*;
import java.time.*;

@Getter @Setter @AllArgsConstructor
public class SearchResultDto {
    private Long showId;
    private String movieTitle;
    private String language;
    private String theatre;
    private String city;
    private LocalDateTime showDateTime;
}