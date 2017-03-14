package com.example.android.buttonclickcounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button ourButton;
    private TextView ourMessage;
    private int numTimesClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // shows form on the screen
        ourButton = (Button) findViewById(R.id.button); // linked the button in layout file to our variable in our java code
        ourMessage = (TextView) findViewById(R.id.textview);

        View.OnClickListener ourOnClickListener = new View.OnClickListener() { // create a onClickListener to wait for the the user to click the button
            @Override
            public void onClick(View view) {
                numTimesClick = numTimesClick + 1; // incriments the numClick variable each time the button is pressed
                String result = "The button got tapped " + numTimesClick + " time"; // set variable result to the amount of times the button got tapped
                if (numTimesClick != 1) { // checks to see if the button has been clicked more than once
                    result += "s"; // if true it appends an "s" to the result variable
                }
                ourMessage.setText(result); // sets the message to the result variable
            }
        };

        ourButton.setOnClickListener(ourOnClickListener); // link the onClickListener method to ourButton




        // default code
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this,  ourMessage.getText(), Toast.LENGTH_LONG);
            toastMessage.show();
            numTimesClick = 0;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
