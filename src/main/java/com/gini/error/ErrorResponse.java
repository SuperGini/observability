package com.gini.error;

public record ErrorResponse(
        String message,
        int status
) {
}
