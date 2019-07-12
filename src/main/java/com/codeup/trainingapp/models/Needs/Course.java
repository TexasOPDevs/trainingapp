package com.codeup.trainingapp.models.Needs;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String location;

    @Column
    private String evaluation_file;

    @Column
    private Time start_time;

    @Column
    private Date start_date;

    @Column
    private Date end_date;

    @ManyToOne
    private Curriculum curriculum;

    @OneToOne
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Attendance> attendances;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "instructors",
            joinColumns ={@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> instructors;

    public Course() {
    }
}
