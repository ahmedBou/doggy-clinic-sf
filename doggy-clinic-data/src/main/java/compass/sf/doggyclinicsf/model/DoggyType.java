package compass.sf.doggyclinicsf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="doggy_type")
public class DoggyType extends BaseEntity{
    @Column(name = "names")
    private String names;

    public String getName() {
        return names;
    }

    public void setName(String names) {
        this.names = names;
    }
}
