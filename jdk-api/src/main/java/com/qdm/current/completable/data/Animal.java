package com.qdm.current.completable.data;

/**
 * @author qiudm
 * @date 2018/7/3 15:54
 * @desc
 */
public class Animal {

    private String id;

    private String animalName;

    private String color;

    public Animal() {
    }

    public Animal(String id, String animalName, String color) {
        this.id = id;
        this.animalName = animalName;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
