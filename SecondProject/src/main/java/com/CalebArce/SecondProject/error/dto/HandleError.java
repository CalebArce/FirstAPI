package com.CalebArce.SecondProject.error.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HandleError {

    private String code;
    private String message;
}
