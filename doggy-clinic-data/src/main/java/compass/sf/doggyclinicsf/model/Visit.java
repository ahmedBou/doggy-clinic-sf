package compass.sf.doggyclinicsf.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "visit_Date")
    private LocalDate visit;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "doggy_id")
    private Doggy dog;

    public LocalDate getVisit() {
        return visit;
    }

    public void setVisit(LocalDate visit) {
        this.visit = visit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Doggy getDog() {
        return dog;
    }

    public void setDog(Doggy dog) {
        this.dog = dog;
    }
}
