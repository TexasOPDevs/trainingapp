package com.codeup.trainingapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

    @Id
    private Long id;
    private String name;
}
