package org.publicissapient.moviesearch.service;

import lombok.Builder;

import java.time.LocalDate;


@Builder
public record SearchCriteria(String city,
                             String title,
                             String language,
                             LocalDate showForDate) {}