package com.java.tutorial.command;

import com.java.tutorial.devObjs.Page;
import com.java.tutorial.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;


public interface Command {

    Page execute(HttpServletRequest request) throws ServiceException;
}
