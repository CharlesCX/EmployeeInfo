package com.charles.employeeinfo.rest;

import com.charles.employeeinfo.models.Employee;
import com.charles.employeeinfo.models.EmployeeList;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by charles on 15/03/2018.
 */

public interface GateWay {
    @GET("retrofit-demo.php?company_no=123")
    Call<EmployeeList> getEmployee();
}
