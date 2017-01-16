package com.example.sqllitecrud.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.sqllitecrud.Database.CRUDSQLite;
import com.example.sqllitecrud.Model.Person;
import com.example.sqllitecrud.R;
import com.example.sqllitecrud.UI.Adapter.MyAdapter;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ListView lvPersons;
    private ArrayList<Person> personList;
    private CRUDSQLite crudsqLite;
    //private CRUDSharedPreferences crudSharedPreferences;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_list_person){

        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvPersons = (ListView)findViewById(R.id.list_view_person);

        personList = new ArrayList<Person>();
        crudsqLite = new CRUDSQLite(this);
        personList = crudsqLite.getAllPersons();
        //crudSharedPreferences = new CRUDSharedPreferences();

        //ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personList);
        MyAdapter adapter = new MyAdapter(this, personList);
        lvPersons.setAdapter(adapter);
    }
}
