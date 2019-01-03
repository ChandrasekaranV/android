package com.example.chandru.fivekilometer;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MakeCall extends AppCompatActivity {
   // private Button button;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    ListView list;
    String [] PhoneNumbers ={
            "9629134011",
            "9894550494",
            "7358074122"
    };

    String [] userNames ={"Peter Jerold Leslie","Vincent Paulraj","Chandrasekaran"};
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_file, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
//            case R.id.menuAbout:
//                Toast.makeText(this, "You clicked about", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.menuSettings:
//                Toast.makeText(this, "You clicked settings", Toast.LENGTH_SHORT).show();
//                break;

            case R.id.menuLogout:

//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//                alertDialogBuilder.setMessage("Are you sure,You wanted to Log out");
//                        alertDialogBuilder.setPositiveButton("yes",
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface arg0, int arg1) {
//                                        Intent in=new Intent(MakeCall.this,LocationActivity.class);
//                                        startActivity(in);
//                                        //Toast.makeText(this, "Application logout", Toast.LENGTH_SHORT).show();
//                                        //
//                                        }
//                                });
//
//                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//
//                AlertDialog alertDialog = alertDialogBuilder.create();
//                alertDialog.show();

                break;

        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("GGG","gggg");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_phone);
        list = (ListView) findViewById(R.id.list_view);

        list.setTextFilterEnabled(true);

        MyListAdapter adapter=new MyListAdapter(this, userNames,PhoneNumbers);

        list.setAdapter( adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+ PhoneNumbers[position]));


                    if (ActivityCompat.checkSelfPermission(MakeCall.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);

            }

        });





    }

    public class MyListAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] maintitle;
        private final String[] subtitle;

        public MyListAdapter(Activity context, String[] maintitle,String[] subtitle) {
            super(context, R.layout.activity_listview, maintitle);
            // TODO Auto-generated constructor stub

            this.context=context;
            this.maintitle=maintitle;
            this.subtitle=subtitle;
//            this.imgid=imgid;

        }

        public View getView(int position,View view,ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.activity_listview, null,true);

            TextView titleText = (TextView) rowView.findViewById(R.id.name);
//            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            TextView subtitleText = (TextView) rowView.findViewById(R.id.mob_no);

            titleText.setText(maintitle[position]);
//            imageView.setImageResource(imgid[position]);
            subtitleText.setText(subtitle[position]);

            return rowView;

        };
    }
    @Override
    public void onBackPressed() {



        super.onBackPressed();
//        Log.d("CDA", "onBackPressed Called");
//        Intent setIntent = new Intent(Intent.);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(setIntent);

        //return;
//        new AlertDialog.Builder(this)
//                .setTitle("Really Exit?")
//                .setMessage("Are you sure you want to exit?")
//                .setNegativeButton(android.R.string.no, null)
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        MakeCall.super.onBackPressed();
//                    }
//                }).create().show();
    }

}
