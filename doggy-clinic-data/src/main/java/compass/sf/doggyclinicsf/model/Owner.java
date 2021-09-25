package compass.sf.doggyclinicsf.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor

@Entity
@Table(name= "owners")
public class Owner extends Person{
    @Builder
    public Owner(Long id,String firstName, String lastName, String address, String city, String telephone, Set<Doggy> dogs) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.dogs = dogs;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Doggy> dogs = new HashSet<>();


}
