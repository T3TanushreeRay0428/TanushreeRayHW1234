package ca.humber.it.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean flag;
    int images[] = {R.drawable.androidicon, R.drawable.background, R.drawable.image};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imbtn = findViewById(R.id.imageButton);
        flag = true;

        imbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imbtn.setImageResource(images[i]);
                i++;
                if (i == 3)
                    i = 0;
            }
        });
        Switch sw = (Switch) findViewById(R.id.switch3);
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Switch ON", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "Switch OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void displayAlert(View view) {

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                //set icon
                .setIcon(android.R.drawable.ic_dialog_alert)
                //set title
                .setTitle("Are you sure to Exit")
                //set message
                .setMessage("Exiting will call finish() method")
                //set positive button
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        finish();
                    }
                })
                //set negative button
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    public void displayEditTextAsToast(View view) {

        EditText input = (EditText) findViewById(R.id.editText);

        Button click = (Button) findViewById(R.id.button2);
        Toast.makeText(getApplicationContext(), input.getText().toString(),

                Toast.LENGTH_SHORT).show();
    }
}