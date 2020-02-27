package com.robby.mobile_03_20192;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.robby.mobile_03_20192.databinding.ActivityMainBinding;
import com.robby.mobile_03_20192.entity.Department;

import java.util.ArrayList;

/**
 * @author Robby Tan
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ArrayList<Department> departments;
    private ArrayAdapter<Department> departmentArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.spinDepartments.setAdapter(getDepartmentArrayAdapter());
        binding.btnSubmit.setOnClickListener(v -> {
            this.submitAction();
        });
    }

    public void submitAction() {
        String nrp = binding.etNrp.getText().toString();
        String name = binding.etName.getText().toString();
        String address = binding.etAddress.getText().toString();
        String email = binding.etEmail.getText().toString();
        boolean disability = binding.cbDisability.isChecked();
        String gender = binding.rbMale.isSelected() ? binding.rbMale.getText().toString() :
                binding.rbFemale.getText().toString();
        Department department = (Department) binding.spinDepartments.getSelectedItem();
        Snackbar.make(binding.svRoot, String.format("%s(%s) | Address: %s | Email: %s | Gender: %s | Disability: %b | Department: %s%n", name, nrp, address, email, gender, disability, department), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_item1:
                Toast.makeText(this, "Hello 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mn_item2:
                Toast.makeText(this, "Hello 2", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Department> getDepartments() {
        if (departments == null) {
            departments = new ArrayList<>();
            departments.add(new Department("10", "S1 Kedokteran"));
            departments.add(new Department("72", "S1 Teknik Informatika"));
            departments.add(new Department("73", "S1 Sistem Informasi"));
        }
        return departments;
    }

    public ArrayAdapter<Department> getDepartmentArrayAdapter() {
        if (departmentArrayAdapter == null) {
            departmentArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getDepartments());
        }
        return departmentArrayAdapter;
    }
}
