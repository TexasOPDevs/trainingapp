package com.codeup.trainingapp.models.Needs;

import com.codeup.trainingapp.models.Wants.Gradable_Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private Time startTime;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Long capacity;

    @ManyToOne
    @JsonBackReference
    private Curriculum curriculum;

    @OneToOne
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    @JsonManagedReference
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    @JsonManagedReference
    private List<Attendance> attendances;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "instructors",
            joinColumns ={@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    @JsonManagedReference
    private List<User> instructors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    @JsonIgnore
    private List<Gradable_Student> gradable_students;

    public Course() {
    }

    public Course(String location, String evaluation_file, Time startTime, Date startDate, Date end_date, Long capacity, Curriculum curriculum, Status status, List<Student> students, List<Attendance> attendances, List<User> instructors) {
        this.location = location;
        this.evaluation_file = evaluation_file;
        this.startTime = startTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.curriculum = curriculum;
        this.status = status;
        this.students = students;
        this.attendances = attendances;
        this.instructors = instructors;
    }

    public List<Gradable_Student> getGradable_students() {
        return gradable_students;
    }

    public void setGradable_students(List<Gradable_Student> gradable_students) {
        this.gradable_students = gradable_students;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEvaluation_file() {
        return evaluation_file;
    }

    public void setEvaluation_file(String evaluation_file) {
        this.evaluation_file = evaluation_file;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<User> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<User> instructors) {
        this.instructors = instructors;
    }
}
