package com.modernjava.latestfeatures.http;

import java.time.LocalDate;

public record Movie(
        Double movie_id,
        String name,
        String cast,
        Integer year,
        LocalDate release_date

        ) {
}
