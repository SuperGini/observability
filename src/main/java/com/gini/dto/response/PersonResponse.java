package com.gini.dto.response;

public record PersonResponse (
        String id,
        String username,
        String firstName,
        String lastName
) {
}
