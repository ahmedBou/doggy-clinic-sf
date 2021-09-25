package compass.sf.doggyclinicsf.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


}
