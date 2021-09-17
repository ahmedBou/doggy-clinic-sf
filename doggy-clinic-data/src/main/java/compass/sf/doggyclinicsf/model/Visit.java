package compass.sf.doggyclinicsf.model;

import java.time.LocalDate;

public class Visit extends BaseEntity{

    private LocalDate visit;
    private String description;
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
