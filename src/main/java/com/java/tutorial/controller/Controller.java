package com.java.tutorial.controller;

import com.java.tutorial.command.Command;
import com.java.tutorial.command.CommandFactory;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get request");
        doWork(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post request");
        doWork(req, resp);
    }

    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandValue = req.getParameter("command");
        System.out.println(commandValue);
        System.out.println("controller");
        Command command = CommandFactory.getCommand(commandValue);
        try {
            assert command != null;
            Page page = command.execute(req);
            if (page.isRedirect()) {
                redirect(page.getUrl(), req, resp);
            } else {
                forward(page.getUrl(), req, resp);
            }
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }

    private void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + url);
    }

    private void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }
}
