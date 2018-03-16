package com.charles.employeeinfo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by charles on 15/03/2018.
 */

public class EmployeeList {
    @SerializedName("employeeList")
    private ArrayList<Employee> employeeList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeList = employeeArrayList;
    }
}