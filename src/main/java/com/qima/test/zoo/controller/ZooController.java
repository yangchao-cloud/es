package com.qima.test.zoo.controller;

import com.qima.test.zoo.bean.Animal;
import com.qima.test.zoo.bean.ReportVO;
import com.qima.test.zoo.service.AnimalTalentFactory;
import com.qima.test.zoo.service.AnimalTalentShow;
import com.qima.test.zoo.service.ZooService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("zoo")
public class ZooController {

    private ZooService zooService;

    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping("animals")
    public List<Animal> getAll() {
        return zooService.getAll();
    }

    @GetMapping("report")
    public ReportVO getReport() {
        return zooService.getReport();
    }

    /**
     * 查询动物们
     * @param animal
     * @return
     */
    @GetMapping
    public List<Animal> queryAnimals(@RequestBody Animal animal) {
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        return animals;
    }

    /**
     * 新增动物
     * @param animal
     * @return
     */
    @PostMapping
    public Animal addAnimal(Animal animal) {
        return null;
    }

    /**
     * 修改动物信息
     * @param animal
     * @return
     */
    @PutMapping
    public Animal updateAnimal(Animal animal) {
        return null;
    }

    /**
     * 删除动物
     * @param animal
     * @return
     */
    @DeleteMapping
    public Animal deleteAnimal(Animal animal) {
        return null;
    }

    /**
     * 获取动物的才艺
     * @return
     */
    @GetMapping("show")
    public String getAnimalCategoryShow(@RequestParam("category") String category) {
        AnimalTalentShow animalTalentShow = AnimalTalentFactory.createFactory(category);
        return animalTalentShow.getTalent();
    }
}
