package com.qima.test.zoo.api;

import com.qima.test.zoo.bean.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/zoo")
public interface ZooApi {
    @GetMapping
    List<Animal> queryAnimals(@RequestBody Animal animal);
}
