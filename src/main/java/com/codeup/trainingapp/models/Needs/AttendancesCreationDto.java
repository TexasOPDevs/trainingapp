package com.codeup.trainingapp.models.Needs;

import java.util.ArrayList;
import java.util.List;

public class AttendancesCreationDto {

    private List<Attendance> attendances;


    public AttendancesCreationDto() {
        this.attendances = new ArrayList<>();

    }

    public void addAttendance(Attendance attendance){
        this.attendances.add(attendance);
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(ArrayList<Attendance> attendances) {
        this.attendances = attendances;
    }
}
