package org.konkvistador.springboot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//анотации для lombok => реализует все getters, setters, hashCode, equals
@Entity
@Table(name = "persons")
public class Person {
    @EmbeddedId
    PersonKey personKey;

    @Column(nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    String cityOfLiving;
}
