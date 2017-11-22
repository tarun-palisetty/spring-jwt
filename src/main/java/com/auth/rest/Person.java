package com.auth.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tarun on 21/11/2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "personWith")
public class Person {

    private String name;
    private String email;
}
