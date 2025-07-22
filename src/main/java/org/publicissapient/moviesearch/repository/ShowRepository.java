package org.publicissapient.moviesearch.repository;

import org.publicissapient.moviesearch.domain.Show_;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository
        extends JpaRepository<Show_, Long>, JpaSpecificationExecutor<Show_> {

    /**
     * Return all distinct city names for which shows exist.
     *
     * @return list of unique cities
     */
    @Query("select distinct s.city from Show_ s")
    List<String> findDistinctCities();
}

