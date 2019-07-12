package com.codeup.trainingapp.models.Needs;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    private Long id;

    @Column
    private Date date;

    @Column
    private Boolean present;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "a_class_id")
    private Course course;


    public Attendance() {
    }
}
