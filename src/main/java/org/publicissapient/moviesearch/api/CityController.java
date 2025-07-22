package org.publicissapient.moviesearch.api;

import lombok.RequiredArgsConstructor;
import org.publicissapient.moviesearch.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoint for listing available cities.
 */
@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final SearchService service;

    @GetMapping
    public List<String> listCities() {
        return service.listCities();
    }
}
