package compass.sf.doggyclinicsf.model;

import java.time.LocalDate;

public class Doggy extends BaseEntity{
    private String name;
    private DoggyType doggyType;
    private LocalDate birthDate;
    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public DoggyType getDoggyType() {
        return doggyType;
    }

    public void setDoggyType(DoggyType doggyType) {
        this.doggyType = doggyType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
