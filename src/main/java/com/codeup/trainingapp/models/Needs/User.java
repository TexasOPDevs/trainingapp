package com.codeup.trainingapp.models.Needs;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    private Long   id;

    @Column(unique = true)
    private String username;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column(unique = true)
    private String email;

    @Column
    private String phone;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String role;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column

    private String img;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_provider",
            joinColumns ={@JoinColumn(name = "user_id")},
            inverseJoinColumns ={@JoinColumn(name = "provider_id")}
    )
    @JsonBackReference
    private List<Provider> providers;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<User_Certification> certifications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List<Attendance> attendances;

    @ManyToMany(mappedBy = "instructors")
    @JsonBackReference
    private List<Course> courses;



    public User() {
    }

    public User(Long id, String username, String first_name, String last_name, String email, String phone, String password, String role, String bio, String img, List<Provider> providers, List<User_Certification> certifications, List<Attendance> attendances, List<Course> courses) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.bio = bio;
        this.img = img;
        this.providers = providers;
        this.certifications = certifications;
        this.attendances = attendances;
        this.courses = courses;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.first_name = copy.first_name;
        this.last_name = copy.last_name;
        this.email = copy.email;
        this.phone = copy.phone;
        this.password = copy.password;
        this.role = copy.role;
    }

    public User(Long id, String username, String first_name, String last_name, String email, String phone, String password, String image) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public List<User_Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<User_Certification> certifications) {
        this.certifications = certifications;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
