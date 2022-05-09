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
    private PersonKey personKey;
    private String phoneNumber;
    private String cityOfLiving;
}
