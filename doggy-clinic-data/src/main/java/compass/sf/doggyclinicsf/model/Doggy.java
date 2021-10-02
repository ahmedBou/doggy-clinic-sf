package compass.sf.doggyclinicsf.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "doggy")
public class Doggy extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Builder
    public Doggy(Long id, String name, DoggyType doggyType, LocalDate birthDate, Owner owner, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.doggyType = doggyType;
        this.birthDate = birthDate;
        this.owner = owner;

        if (visits == null || visits.size() > 0) {
            this.visits = visits;
        }
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private DoggyType doggyType;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();


}
