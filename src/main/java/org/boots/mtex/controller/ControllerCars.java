package org.boots.mtex.controller;


import org.boots.mtex.srevice.ServiceDataImplements;
import org.hibernate.query.Page;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/car")
public class ControllerCars {

    private ServiceDataImplements serviceDataImplements;

    public ControllerCars(ServiceDataImplements serviceDataImplements) {
        this.serviceDataImplements = serviceDataImplements;
    }

    @PostMapping("/create")
    public String createCar(@RequestBody String string) throws JSONException {
        return serviceDataImplements.createCar(new JSONObject(string));
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable long id) {
        return serviceDataImplements.getCarById(id);
    }

//    @GetMapping("/cars")
//    public String getCars() {
//    }

}
