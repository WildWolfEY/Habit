package ru.myhabit.data.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "public")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
