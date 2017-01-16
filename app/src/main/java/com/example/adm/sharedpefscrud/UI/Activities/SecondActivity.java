package com.example.adm.sharedpefscrud.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adm.sharedpefscrud.Database.CRUDSharedPreferences;
import com.example.adm.sharedpefscrud.Model.Person;
import com.example.adm.sharedpefscrud.R;
import com.example.adm.sharedpefscrud.UI.Adapter.MyAdapter;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ListView lvPersons;
    private ArrayList<Person> personList;
    private CRUDSharedPreferences crudSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvPersons = (ListView)findViewById(R.id.list_view_person);

        personList = new ArrayList<Person>();
        crudSharedPreferences = new CRUDSharedPreferences();
        personList = crudSharedPreferences.getPerson(this);

        //ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personList);
        MyAdapter adapter = new MyAdapter(this, personList);
        lvPersons.setAdapter(adapter);
    }
}
