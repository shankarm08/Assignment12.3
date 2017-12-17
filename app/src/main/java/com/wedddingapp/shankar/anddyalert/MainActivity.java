package com.wedddingapp.shankar.anddyalert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//Creating class by extending AppCompatActivity and implementing OnClickListener.
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //Creating reference of TextView.
    TextView dialogCreater;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    //Setting content view.

        //Setting textView reference with its ID.
        dialogCreater=(TextView)findViewById(R.id.dialog_producer);

        //Setting onClick listener to TextView. It will produce Dialog.
        dialogCreater.setOnClickListener(this);
    }

    @Override
    //Method to handle onClick event.
    public void onClick(View v)
    {
        //Checking that TextView is clicked.
        if(v.getId()==R.id.dialog_producer)
        {

            //Creating AlertDialog Buider for present Activity.
            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);

            //Giving Different Properties and onClick Listeners to Dialog.
            alertDialogBuilder.setIcon(R.drawable.cancel)
                    .setTitle("Confirm Delete")
                    .setMessage("Are you sure you want to delete this?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            Toast.makeText(getApplicationContext(),"YES Clicked",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            Toast.makeText(getApplicationContext(),"NO Clicked",Toast.LENGTH_SHORT).show();
                        }
                    });

            //Creating AlertDialog from its Builder.
            AlertDialog alertDialog=alertDialogBuilder.create();

            //Showing Dialog.
            alertDialog.show();
        }
    }
}
