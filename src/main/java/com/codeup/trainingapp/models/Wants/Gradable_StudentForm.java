package com.codeup.trainingapp.models.Wants;

import java.util.List;

public class Gradable_StudentForm {
    private List<Gradable_Student> gradesForm;


    public Gradable_StudentForm() {
    }

    public void addStudent(Gradable_Student student){
        gradesForm.add(student);
    }

    public Gradable_StudentForm(List<Gradable_Student> gradesForm) {
        this.gradesForm = gradesForm;
    }

    public List<Gradable_Student> getGradesForm() {
        return gradesForm;
    }

    public void setGradesForm(List<Gradable_Student> gradesForm) {
        this.gradesForm = gradesForm;
    }


}
