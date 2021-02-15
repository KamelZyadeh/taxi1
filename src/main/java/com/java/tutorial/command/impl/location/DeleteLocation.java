package com.java.tutorial.command.impl.location;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.LocationService;

import javax.servlet.http.HttpServletRequest;

public class DeleteLocation implements Command {

    private LocationService locationService;

    public DeleteLocation(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
}
