package com.qima.test.zoo.service;

import com.qima.test.zoo.bean.*;
import com.qima.test.zoo.dao.ZooClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ZooService {

    private ZooClient client;

    public ZooService(ZooClient client) {
        this.client = client;
    }

    public List<Animal> getAll() {
        return client.getAll();
    }

    public ReportVO getReport() {
        ReportVO reportVO = new ReportVO();
        //1.拿到所有的动物
        List<Animal> animals = getAll();
        if (CollectionUtils.isEmpty(animals)) {
            return reportVO;
        }
        //2.获取overall信息
        getOverall(reportVO, animals);
        //3.获取size信息
        getSize(reportVO, animals);
        //4.获取sourceCountry信息
        getSourceCountry(reportVO, animals);
        //5.获取category信息
        getCategory(reportVO, animals);

        return reportVO;
    }

    /**
     * 获取overall信息
     * @param reportVO
     * @param animals
     */
    private void getOverall(ReportVO reportVO, List<Animal> animals) {
        //1.拿到所有动物的数量
        long totalCount = animals.size();
        //2.拿到活着的动物数量
        long aliveCount = animals.stream().filter(a -> Status.ALIVE.equals(a.getStatue())).count();
        //3.拿到死去的动物数量
        long deadCount = 0L;
        if (totalCount != aliveCount) {
            deadCount = totalCount - aliveCount;
        }
        //4.拿到最轻的动物
        List<Animal> tempAnimals1 = animals.stream().sorted(Comparator.comparing(Animal::getWeight)).collect(Collectors.toList());
        String lightestOne = tempAnimals1.get(0).getName();
        //5.拿到最短的动物
        List<Animal> tempAnimals2 = animals.stream().sorted(Comparator.comparing(Animal::getHeight)).collect(Collectors.toList());
        String shortestOne = tempAnimals2.get(0).getName();
        //6.拿到最老的动物
        List<Animal> tempAnimals3 = animals.stream().sorted(Comparator.comparing(Animal::getBirthTime)).collect(Collectors.toList());
        String oldestOne = tempAnimals3.get(0).getName();
        Overall overall = Overall.builder().aliveCount(aliveCount).deadCount(deadCount).lightestOne(lightestOne).shortestOne(shortestOne).oldestOne(oldestOne).build();
        reportVO.setOverall(overall);
    }

    /**
     * 获取size信息
     * @param reportVO
     * @param animals
     */
    private void getSize(ReportVO reportVO, List<Animal> animals) {
        long smallAnimalCount = animals.stream().filter(a -> a.getWeight() < 30).count();
        long mediumAnimalCount = animals.stream().filter(a -> a.getWeight() >= 30 && a.getWeight() < 150).count();
        long largeAnimalCount = animals.stream().filter(a -> a.getWeight() >= 150).count();
        Map<String, Long> sizeMap = new LinkedHashMap<>();
        sizeMap.put("Small animal count", smallAnimalCount);
        sizeMap.put("Medium animal count", mediumAnimalCount);
        sizeMap.put("Large animal count", largeAnimalCount);
        reportVO.setSize(sizeMap);
    }

    /**
     * 获取sourceCountry信息
     * @param reportVO
     * @param animals
     */
    private void getSourceCountry(ReportVO reportVO, List<Animal> animals) {
        List<String> sourceCountries = animals.stream().map(Animal::getSourceCountry).distinct().collect(Collectors.toList());
        Map<String, Long> sourceCountryMap = new LinkedHashMap<>();
        for (String sourceCountry : sourceCountries) {
            long countOfAnimalType = animals.stream().filter(a -> sourceCountry.equals(a.getSourceCountry())).count();
            sourceCountryMap.put(sourceCountry, countOfAnimalType);
        }
        reportVO.setSourceCountry(sourceCountryMap);
    }

    /**
     * 获取category信息
     * @param reportVO
     * @param animals
     */
    private void getCategory(ReportVO reportVO, List<Animal> animals) {
        List<AnimalCategory> animalCategories = animals.stream().map(Animal::getCategory).distinct().collect(Collectors.toList());
        animalCategories = animalCategories.stream().sorted(Comparator.comparing(AnimalCategory::getIndex)).collect(Collectors.toList());
        Map<String, Long> categoryMap = new LinkedHashMap<>();
        for (AnimalCategory animalCategory : animalCategories) {
            long countOfCategory = animals.stream().filter(a -> animalCategory.equals(a.getCategory())).count();
            categoryMap.put(animalCategory.getText(), countOfCategory);
        }
        reportVO.setCategory(categoryMap);
    }
}
