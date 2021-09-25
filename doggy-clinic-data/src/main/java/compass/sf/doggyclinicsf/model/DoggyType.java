package compass.sf.doggyclinicsf.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="doggy_type")
public class DoggyType extends BaseEntity{
    @Column(name = "names")
    private String names;
}
