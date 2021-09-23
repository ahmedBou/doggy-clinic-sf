package compass.sf.doggyclinicsf.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "doggy")
public class Doggy extends BaseEntity{
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private DoggyType doggyType;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
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
