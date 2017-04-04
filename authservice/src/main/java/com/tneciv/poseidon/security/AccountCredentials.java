package com.tneciv.poseidon.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountCredentials implements Serializable {
    private static final long serialVersionUID = 1346581433310195266L;
    private String username;
    private String password;
}