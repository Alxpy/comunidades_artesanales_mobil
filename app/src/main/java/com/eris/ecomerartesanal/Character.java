package com.eris.ecomerartesanal;

public class Character {

    private String id;
    private String name;
    private String species;
    private String gender;
    private String image;

    public Character(String id, String name, String species, String gender, String image  ){
        this.id = id;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
