package com.example.sqllitecrud.UI.Adapter;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sqllitecrud.Config;
import com.example.sqllitecrud.Database.SQLiteDBHelper;
import com.example.sqllitecrud.Model.Person;
import com.example.sqllitecrud.R;
import com.example.sqllitecrud.UI.Activities.MainActivity;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Person> personList;

    public MyAdapter(Context context, ArrayList<Person> personList) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.personList = personList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_person, parent, false);
        }
        final Person person = (Person) getItem(position);

        TextView tvNamePerson = (TextView) view.findViewById(R.id.text_view_name);
        TextView tvSurnamePerson = (TextView) view.findViewById(R.id.text_view_surname);
        TextView tvNumberPerson = (TextView) view.findViewById(R.id.text_view_number);
        TextView tvMailPerson = (TextView) view.findViewById(R.id.text_view_mail);
        TextView tvSkypePerson = (TextView) view.findViewById(R.id.text_view_skype);

        tvNamePerson.setText(person.getName());
        tvSurnamePerson.setText(person.getSurname());
        tvNumberPerson.setText(person.getNumber());
        tvMailPerson.setText(person.getMail());
        tvSkypePerson.setText(person.getSkype());

        tvNumberPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + person.getNumber()));
                v.getContext().startActivity(callIntent);
            }
        });
        tvMailPerson.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        tvSkypePerson.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private void openDeleteDialog(final Person person){

    }

    private void openFileDialog(){

    }

    private void sendNotification(final Person person){
        final int NOTIFY_ID = 101;
        Context sysContext = context.getApplicationContext();
        Intent notificationIntent = new Intent(sysContext, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
                sysContext,
                0,
                notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );
        NotificationManager nm = (NotificationManager) sysContext.getSystemService(Context.NOTIFICATION_SERVICE);
        //Notification.Builder builder =
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
