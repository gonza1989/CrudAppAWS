package com.andfegon.springbootcrud.api.model.request;

import lombok.Data;

@Data
public class UserCreationRequest {
    private String userName;
    private String age;
}

