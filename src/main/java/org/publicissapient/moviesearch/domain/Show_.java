package org.publicissapient.moviesearch.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity @Getter @Setter @NoArgsConstructor
@Table(indexes = {
        @Index(columnList = "city"),
        @Index(columnList = "language"),
        @Index(columnList = "showDateTime")
})
public class Show_ {
    @Id @GeneratedValue private Long id;

    private String theatre;
    private String city;
    private LocalDateTime showDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}