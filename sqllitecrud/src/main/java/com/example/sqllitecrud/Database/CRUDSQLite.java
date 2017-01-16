package com.example.sqllitecrud.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqllitecrud.Config;
import com.example.sqllitecrud.Model.Person;

import java.util.ArrayList;

/**
 * Created by adm on 06.01.2017.
 */

public class CRUDSQLite {

    SQLiteDBHelper sqLiteDBHelper;

    public CRUDSQLite(Context context) {
        this.sqLiteDBHelper = new SQLiteDBHelper(context);
    }

    public ArrayList<Person> getAllPersons(){
        ArrayList<Person> persons = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLiteDBHelper.getWritableDatabase();
        Person person = null;
        Cursor cursor = sqLiteDatabase.rawQuery(Config.COMMAND_SELECT, null);
        if (cursor.moveToFirst()){
            do{
                person = new Person();
                person.setId(Integer.parseInt(cursor.getString(0)));
                person.setName(cursor.getString(1));
                person.setSurname(cursor.getString(2));
                person.setNumber(cursor.getString(3));
                person.setMail(cursor.getString(4));
                person.setSkype(cursor.getString(5));
                persons.add(person);
                sqLiteDatabase.close();
            }
            while (cursor.moveToNext());
        }
        return persons;
    }

    public void addPerson(Person person){
        SQLiteDatabase sqLiteDatabase = sqLiteDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Config.KEY_ID, person.getId());
        values.put(Config.KEY_NAME, person.getName());
        values.put(Config.KEY_SURNAME, person.getSurname());
        values.put(Config.KEY_PHONE, person.getNumber());
        values.put(Config.KEY_MAIL, person.getMail());
        values.put(Config.KEY_SKYPE, person.getSkype());
        sqLiteDatabase.insert(Config.TABLE_PERSON, null, values);
    }

    public void deleteAllPersons(){
        SQLiteDatabase db = sqLiteDBHelper.getWritableDatabase();
        db.delete(Config.TABLE_PERSON, null, null);
        db.close();
    }

    public void deletePerson(int id){
        SQLiteDatabase db = sqLiteDBHelper.getWritableDatabase();
        db.delete(Config.TABLE_PERSON, Config.KEY_ID + " = " + id, null);
        db.close();
    }

    public void updatePerson(int id, String name, String surname, String number, String mail, String skype){
        SQLiteDatabase db = sqLiteDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Surname", surname);
        values.put("Phone", number);
        values.put("Mail", mail);
        values.put("Skype", skype);
        db.update(Config.TABLE_PERSON, values, Config.KEY_ID + " = " + id, null);
        db.close();
    }

    public ArrayList<Person> getPerson(int id){
        ArrayList<Person> persons = new ArrayList<Person>();
        SQLiteDatabase db = sqLiteDBHelper.getReadableDatabase();
        Cursor cursor = db.query(Config.TABLE_PERSON,
                null,
                Config.KEY_ID + " = " + id,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor != null){
            cursor.moveToFirst();
        }

        Person person = new Person();
        person.setId(Integer.parseInt(cursor.getString(0)));
        person.setName(cursor.getString(1));
        person.setSurname(cursor.getString(2));
        person.setNumber(cursor.getString(3));
        person.setMail(cursor.getString(4));
        person.setSkype(cursor.getString(5));
        persons.add(person);
        db.close();

        return persons;
    }

}
