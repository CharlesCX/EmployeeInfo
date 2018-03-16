package com.charles.employeeinfo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.charles.employeeinfo.R;
import com.charles.employeeinfo.models.Employee;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by charles on 15/03/2018.
 */

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.ViewHolder> {

    List<Employee> employeeList;
    Context context;

    public EmployeeListAdapter(List<Employee> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
    }

    @Override
    public EmployeeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeListAdapter.ViewHolder holder, int position) {
        holder.employeeName.setText(employeeList.get(position).getName());
        holder.employeeEmail.setText(employeeList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.employee_name)
        TextView employeeName;

        @BindView(R.id.employee_email)
        TextView employeeEmail;

        View employeeView;

        ViewHolder(View employeeView) {
            super(employeeView);
            ButterKnife.bind(this, employeeView);
            this.employeeView = employeeView;
        }

    }
}
