package com.muryno.demo.controller;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseResponse<T> {

    T data;
    boolean status;
    String message;
}
