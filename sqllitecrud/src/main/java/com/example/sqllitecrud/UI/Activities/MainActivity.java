package com.example.sqllitecrud.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.sqllitecrud.Database.CRUDSQLite;
import com.example.sqllitecrud.Model.Person;
import com.example.sqllitecrud.R;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private EditText etName;
    private EditText etSurname;
    private EditText etNumber;
    private EditText etMail;
    private EditText etSkype;
    private CRUDSQLite crudsqLite;
    //private CRUDSharedPreferences crudSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = (EditText)findViewById(R.id.person_id);
        etName = (EditText)findViewById(R.id.person_name);
        etSurname = (EditText)findViewById(R.id.person_surname);
        etNumber = (EditText)findViewById(R.id.person_number);
        etMail = (EditText)findViewById(R.id.person_mail);
        etSkype = (EditText)findViewById(R.id.person_skype);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_list_person){
            followToListActivity();
        }

        return true;
    }

    public void onClickAddPerson(View view){
        crudsqLite = new CRUDSQLite(view.getContext());
        //crudSharedPreferences = new CRUDSharedPreferences();
        switch (view.getId()){
            case R.id.button_add_person:
                Person person = new Person(
                        Integer.valueOf(etId.getText().toString()),
                        etName.getText().toString(),
                        etSurname.getText().toString(),
                        etNumber.getText().toString(),
                        etMail.getText().toString(),
                        etSkype.getText().toString()
                );
                crudsqLite.addPerson(person);
                //crudSharedPreferences.addPerson(this, person);
                clearText();
                break;
            default:
                break;
        }
    }

    private void followToListActivity(){
        //Intent callIntent = new Intent(Intent.ACTION_CALL.person.getPhoneNumber().toString());
        //startActivity(callIntent);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //intent.putExtra("text", String text);
        startActivity(intent);
    }

    private void clearText(){
        etId.setText("");
        etName.setText("");
        etSurname.setText("");
        etNumber.setText("");
        etMail.setText("");
        etSkype.setText("");
    }

}
