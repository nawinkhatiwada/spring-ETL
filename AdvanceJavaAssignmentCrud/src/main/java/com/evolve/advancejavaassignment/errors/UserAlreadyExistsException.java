package com.evolve.advancejavaassignment.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAlreadyExistsException extends IllegalStateException {
    private int code;
    private String message;

}
