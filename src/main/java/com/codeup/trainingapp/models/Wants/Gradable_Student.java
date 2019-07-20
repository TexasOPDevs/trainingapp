package com.codeup.trainingapp.models.Wants;

        import com.codeup.trainingapp.models.Needs.Course;
        import com.codeup.trainingapp.models.Needs.User;

        import javax.persistence.*;
        import java.sql.Date;

@Entity
@Table(name = "gradable_student")
public class Gradable_Student {

    @Id
    @GeneratedValue
    private Long id;


    private Long grade;

    private Date posted_at;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Gradable gradable;

    @ManyToOne
    private User user;

    public Gradable_Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Gradable getGradable() {
        return gradable;
    }

    public void setGradable(Gradable gradable) {
        this.gradable = gradable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
