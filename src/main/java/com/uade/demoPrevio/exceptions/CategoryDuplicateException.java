package com.uade.demoPrevio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Category already exists")
public class CategoryDuplicateException extends RuntimeException {
    public CategoryDuplicateException() {
        super("Category already exists");
    }
}
