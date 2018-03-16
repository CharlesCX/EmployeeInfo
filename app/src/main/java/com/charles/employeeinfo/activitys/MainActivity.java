package com.charles.employeeinfo.activitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.charles.employeeinfo.R;
import com.charles.employeeinfo.adapter.EmployeeListAdapter;
import com.charles.employeeinfo.models.Employee;

import com.charles.employeeinfo.models.EmployeeList;
import com.charles.employeeinfo.rest.GateWay;
import com.charles.employeeinfo.rest.RestClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.employee_list)
    RecyclerView employeeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpData();
    }

    private void setUpData() {
        GateWay service = RestClient.getGateWay().create(GateWay.class);

        Call<EmployeeList> call = service.getEmployee();

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                List<Employee> list = response.body().getEmployeeArrayList();
                loadView(list);
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void loadView(List<Employee> employees) {
        List<Employee> list = employees;
        employeeList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        EmployeeListAdapter adapter = new EmployeeListAdapter(list, MainActivity.this);
        employeeList.setAdapter(adapter);

    }
}
