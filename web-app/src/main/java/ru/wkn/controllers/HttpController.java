package ru.wkn.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpController {

    void doPost(HttpServletRequest request, HttpServletResponse response);
}
