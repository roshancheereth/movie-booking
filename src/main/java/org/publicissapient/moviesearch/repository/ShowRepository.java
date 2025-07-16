package org.publicissapient.moviesearch.repository;

import org.publicissapient.moviesearch.domain.Show_;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository
        extends JpaRepository<Show_, Long>, JpaSpecificationExecutor<Show_> {}

