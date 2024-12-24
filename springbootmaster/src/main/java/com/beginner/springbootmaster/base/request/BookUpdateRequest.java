package com.beginner.springbootmaster.base.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookUpdateRequest(
        @NotEmpty(message = "Title must no be null or empty") String title,
        @NotNull String author
        ) {
}
