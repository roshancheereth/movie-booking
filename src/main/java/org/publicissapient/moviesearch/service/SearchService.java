package org.publicissapient.moviesearch.service;

import org.publicissapient.moviesearch.domain.Show_;
import org.publicissapient.moviesearch.dto.SearchResultDto;
import org.publicissapient.moviesearch.repository.ShowRepository;
import org.publicissapient.moviesearch.repository.specs.ShowSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ShowRepository repo;

    public List<SearchResultDto> search(SearchCriteria c) {

        Specification<Show_> spec = Specification.where(null);

        if (c.city() != null)      spec = spec.and(ShowSpecifications.cityIs(c.city()));
        if (c.title() != null)     spec = spec.and(ShowSpecifications.titleLike(c.title()));
        if (c.language() != null)  spec = spec.and(ShowSpecifications.languageIs(c.language()));
        if (c.after() != null)     spec = spec.and(ShowSpecifications.startAfter(c.after()));

        return repo.findAll(spec).stream()
                .map(s -> new SearchResultDto(
                        s.getId(),
                        s.getMovie().getTitle(),
                        s.getMovie().getLanguage(),
                        s.getTheatre(),
                        s.getCity(),
                        s.getShowDate(),
                        s.getStartTime()))
                .toList();
    }
}