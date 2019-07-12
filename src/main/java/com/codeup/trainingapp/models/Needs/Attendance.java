package com.codeup.trainingapp.models.Needs;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonManagedReference
    private Course course;


    public Attendance() {
    }
}
