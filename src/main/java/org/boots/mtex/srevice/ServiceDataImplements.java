package org.boots.mtex.srevice;

import org.boots.mtex.Entity.Cars;
import org.boots.mtex.Entity.Corpus;
import org.boots.mtex.Entity.Wheels;
import org.boots.mtex.Repository.CarsRepository;
import org.boots.mtex.Repository.CorpusRepository;
import org.boots.mtex.Repository.WheelsRepository;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceDataImplements {

    private WheelsRepository wheelsRepository;
    private CorpusRepository corpusRepository;

    private CarsRepository carsRepository;

    public ServiceDataImplements(WheelsRepository wheelsRepository, CorpusRepository corpusRepository, CarsRepository carsRepository) {
        this.wheelsRepository = wheelsRepository;
        this.corpusRepository = corpusRepository;
        this.carsRepository = carsRepository;
    }

    public String getAllCarWheel() {
        List<Wheels> wheels = wheelsRepository.findAll();
        StringBuilder builder = new StringBuilder();
        for (Wheels wheel : wheels) {
            builder.append(wheel.toString() + "<br>");
        }
        return builder.toString();
    }

    public String getAllCarBody() {
        List<Corpus> corpuses = corpusRepository.findAll();
        StringBuilder builder = new StringBuilder();
        for (Corpus corpus : corpuses) {
            builder.append(corpus.toString() + "<br>");
        }
        return builder.toString();
    }

    public String getCarById(long id) {
        Optional<Cars> cars = carsRepository.findById(id);
        if (cars.isEmpty())
            return null;
        Cars car = cars.get();
        return carToString(car);
    }

    public String createCar(JSONObject jsonObject) {
        try {
            Cars cars = new Cars();
            cars.setId(carsRepository.count() + 1);
            Corpus corpus = corpusRepository.findCorpusByModel(jsonObject.getString("Corpus"));
            if (corpus != null)
                cars.setCorpus_id(corpus.getId());
            else {
                return "Not Found corpus";
            }
            Wheels wheels = wheelsRepository.findBySize(jsonObject.getString("Wheels"));
            if (wheels != null) {
                cars.setWheels_id(wheels.getId());
            } else {
                return "Not Found Wheels";
            }
            cars.setName(jsonObject.getString("Name"));
            if (jsonObject.getInt("NumWheels") >= 2)
                carsRepository.insertCar(cars.getId(), cars.getWheels_id(), cars.getCorpus_id(), cars.getName());
            else {
                return "Wheels num less 2";
            }
            return "Car created:<br>" + carToString(cars);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String carToString(Cars car) {
        StringBuilder builder = new StringBuilder(car.getName());
        builder.append("<br>" + wheelsRepository.findById(car.getWheels_id()).get().toString());
        builder.append("<br>" + corpusRepository.findById(car.getCorpus_id()).get().toString());
        return builder.toString();
    }
}
