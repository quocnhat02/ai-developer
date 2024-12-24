package com.beginner.springbootmaster.base.request;

import com.beginner.springbootmaster.base.validation.Foo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record NewBookRequest(@NotEmpty String title,
                             @NotNull String author) {
}
