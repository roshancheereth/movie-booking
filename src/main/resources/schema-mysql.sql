/* === MOVIE TABLE ============================================= */
CREATE TABLE movie (
                       id        BIGINT       NOT NULL AUTO_INCREMENT,
                       title     VARCHAR(150) NOT NULL,
                       language  VARCHAR(30)  NOT NULL,
                       PRIMARY KEY (id),
                       INDEX idx_movie_title   (title),
                       INDEX idx_movie_lang    (language)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* === SHOW TABLE ============================================== */
CREATE TABLE show_ (
                       id               BIGINT       NOT NULL AUTO_INCREMENT,
                       theatre          VARCHAR(120) NOT NULL,
                       city             VARCHAR(80)  NOT NULL,
                       show_date        DATE         NOT NULL,
                       show_time        TIME         NOT NULL,
                       movie_id         BIGINT       NOT NULL,
                       PRIMARY KEY (id),
                       CONSTRAINT fk_show_movie
                           FOREIGN KEY (movie_id)
                               REFERENCES movie (id)
                               ON DELETE CASCADE,
                       INDEX idx_show_city           (city),
                       INDEX idx_show_date       (show_date),
                       INDEX idx_show_city_language  (city, movie_id)   /* join helper */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

