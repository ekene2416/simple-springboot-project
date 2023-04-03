package com.ekene.simplespringbootproject.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private String firstname;
    private String lastname;
    private String email;
}
