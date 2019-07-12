package com.codeup.trainingapp.models.Needs;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Status() {
    }
}
