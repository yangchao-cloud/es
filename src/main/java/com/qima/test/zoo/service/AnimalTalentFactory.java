package com.qima.test.zoo.service;


/**
 * @author A80390
 */
public class AnimalTalentFactory {
    public static AnimalTalentShow createFactory(String category){
        AnimalTalentShow animalTalentShow = null;
        switch(category)
        {
            case "DOG":
                animalTalentShow = new DogTalent();
                break;
            case "MONKEY":
                animalTalentShow = new MonkeyTalent();
                break;
            default:
                break;
        }
        return animalTalentShow;
    }
}
