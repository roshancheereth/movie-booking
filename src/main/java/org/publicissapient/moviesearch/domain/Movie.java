package org.publicissapient.moviesearch.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @NoArgsConstructor
public class Movie {
    @Id @GeneratedValue private Long id;
    private String title;
    private String language;
}
