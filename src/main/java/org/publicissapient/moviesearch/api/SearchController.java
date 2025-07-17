package org.publicissapient.moviesearch.api;

import org.publicissapient.moviesearch.dto.SearchResultDto;
import org.publicissapient.moviesearch.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService service;

    @GetMapping
    public List<SearchResultDto> search(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) @DateTimeFormat LocalDate showForDate) {

        SearchCriteria criteria = SearchCriteria.builder()
                .city(city)
                .title(title)
                .language(language)
                .showForDate(showForDate)
                .build();

        return service.search(criteria);
    }
}