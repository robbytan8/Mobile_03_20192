package com.robby.mobile_03_20192;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.robby.mobile_03_20192.entity.Department;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Robby Tan
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sv_root)
    ScrollView svRoot;
    @BindView(R.id.et_nrp)
    EditText txtNrp;
    @BindView(R.id.et_name)
    EditText txtName;
    @BindView(R.id.et_address)
    EditText txtAddress;
    @BindView(R.id.et_email)
    EditText txtEmail;
    @BindView(R.id.rb_male)
    RadioButton rbMale;
    @BindView(R.id.rb_female)
    RadioButton rbFemale;
    @BindView(R.id.cb_disability)
    CheckBox cbDisability;
    @BindView(R.id.spin_departments)
    Spinner spinDepartments;

    private ArrayList<Department> departments;
    private ArrayAdapter<Department> departmentArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        spinDepartments.setAdapter(getDepartmentArrayAdapter());
    }

    @OnClick(R.id.btn_submit)
    public void submitAction() {
        String nrp = txtNrp.getText().toString();
        String name = txtName.getText().toString();
        String address = txtAddress.getText().toString();
        String email = txtEmail.getText().toString();
        boolean disability = cbDisability.isChecked();
        String gender = rbMale.isSelected() ? rbMale.getText().toString() : rbFemale.getText().toString();
        Department department = (Department) spinDepartments.getSelectedItem();
        Snackbar.make(svRoot, String.format("%s(%s) | Address: %s | Email: %s | Gender: %s | Disability: %b | Department: %s%n", name, nrp, address, email, gender, disability, department), Snackbar.LENGTH_LONG).show();
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
