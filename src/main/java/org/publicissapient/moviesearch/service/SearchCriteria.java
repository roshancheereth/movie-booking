package org.publicissapient.moviesearch.service;

import lombok.Builder;
import java.time.LocalTime;

@Builder
public record SearchCriteria(String city,
                             String title,
                             String language,
                             LocalTime after) {}