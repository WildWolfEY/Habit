package ru.myhabit.data.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(catalog = "public")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Strategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_user")
    @ManyToOne
    private User user;

    @JoinColumn(name = "id_step")
    @ManyToOne
    private Step step;
    @Column(name = "progress_percent")
    private Integer progressPercent;

    @JoinColumn(name = "id_status")
    @ManyToOne
    private Status status;

    @Column(name = "date_start")
    private Date dateStart;

}
