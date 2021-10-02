package compass.sf.doggyclinicsf.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doggy_type")
public class DoggyType extends BaseEntity{
    @Column(name = "names")
    private String names;

    @Builder
    public DoggyType(Long id, String names) {
        super(id);
        this.names = names;
    }

    @Override
    public String toString() {
        return names;
    }
}
