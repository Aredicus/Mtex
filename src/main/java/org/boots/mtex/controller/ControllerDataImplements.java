package org.boots.mtex.controller;

import org.boots.mtex.Entity.Wheels;
import org.boots.mtex.srevice.ServiceDataImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerDataImplements {

    private ServiceDataImplements serviceDataImplements;

    public ControllerDataImplements(ServiceDataImplements serviceDataImplements) {
        this.serviceDataImplements = serviceDataImplements;
    }


    @GetMapping("/corpuses")
    public String getAllCarBody() {
        return serviceDataImplements.getAllCarBody();
    }

    @GetMapping("/wheels")
    public String getAllCarWheels() {
        return serviceDataImplements.getAllCarWheel();
    }
}
