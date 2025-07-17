package org.publicissapient.moviesearch.service;

import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record SearchCriteria(String city,
                             String title,
                             String language,
                             LocalDateTime after) {}