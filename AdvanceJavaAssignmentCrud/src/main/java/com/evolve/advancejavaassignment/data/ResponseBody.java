package com.evolve.advancejavaassignment.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBody {
    private int status;
    private String message;
    private Object data;
}
