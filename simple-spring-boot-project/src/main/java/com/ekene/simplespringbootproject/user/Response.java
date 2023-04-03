package com.ekene.simplespringbootproject.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private LocalDate craeatedat;
    private HttpStatus status;
    private int statuscode;
    Map<?,?> data;

}
