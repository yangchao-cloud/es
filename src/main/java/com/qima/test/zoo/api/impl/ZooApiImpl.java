package com.qima.test.zoo.api.impl;

import com.qima.test.zoo.api.ZooApi;
import com.qima.test.zoo.bean.Animal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZooApiImpl implements ZooApi {

    @Override
    public List<Animal> queryAnimals(@RequestBody Animal animal) {
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        return animals;
    }
}
