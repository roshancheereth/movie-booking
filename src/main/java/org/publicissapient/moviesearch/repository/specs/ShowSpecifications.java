package org.publicissapient.moviesearch.repository.specs;

import org.publicissapient.moviesearch.domain.Show_;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public final class ShowSpecifications {

    public static Specification<Show_> cityIs(String city) {
        return (root, query, cb) -> cb.equal(cb.lower(root.get("city")), city.toLowerCase());
    }

    public static Specification<Show_> titleLike(String title) {
        return (root, q, cb) ->
                cb.like(cb.lower(root.join("movie").get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Show_> languageIs(String lang) {
        return (root, q, cb) ->
                cb.equal(cb.lower(root.join("movie").get("language")), lang.toLowerCase());
    }

    public static Specification<Show_> showForDate(LocalDate t) {
        return (root, q, cb) -> cb.equal(root.get("showDate"),t);
    }

    private ShowSpecifications() {}
}
