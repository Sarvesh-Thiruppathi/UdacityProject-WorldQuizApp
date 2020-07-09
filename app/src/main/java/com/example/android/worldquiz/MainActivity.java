package com.example.android.worldquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.android.worldquiz.R.id.antarctica_location_text;
import static com.example.android.worldquiz.R.id.china_location_text;
import static com.example.android.worldquiz.R.id.hawai_checkbox;
import static com.example.android.worldquiz.R.id.india_checkbox;
import static com.example.android.worldquiz.R.id.kuwait_checkbox;
import static com.example.android.worldquiz.R.id.lakshadweep_checkbox;
import static com.example.android.worldquiz.R.id.mexico_checkbox;
import static com.example.android.worldquiz.R.id.saudiArabia_checkbox;
import static com.example.android.worldquiz.R.id.srilanka_checkbox;
import static com.example.android.worldquiz.R.id.turkey_checkbox;

public class MainActivity extends AppCompatActivity {

    int score; //Global variable to record points.
    boolean euro = false;  //Global variable to know weather euro radio button is selected
    boolean delhi = false; //Global variable to know weather delhi radio button is selected
    boolean washington = false; ///Global variable to know weather euro radio button is selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void euroTrue(View view) { //Sets euro to be true
        euro = true;
    }// Sets euro to be true

    public void euroFalse(View view) {  // Sets euro to be false
        euro = false;
    }// Sets euro to be false

    public void delhiTrue(View view) { //Sets delhi to be true
        delhi = true;
    }// Sets delhi to be true

    public void delhiFalse(View view) {
        delhi = false;
    }// Sets delhi to be false

    public void washingtonTrue(View view) { //Sets washington to be true
        washington = true;
    }

    public void washingtonFalse(View view) { // Sets delhi to be false
        washington = false;
    }

    public void submit(View view) { // Method that gets called when Submit button is clicked


        EditText antarticaLocation = (EditText) findViewById(antarctica_location_text); //antarticaLocation Edit Text
        EditText chinaLocation = (EditText) findViewById(china_location_text); // chinaLocation Edit Text
        CheckBox hawai = (CheckBox) findViewById(hawai_checkbox); // hawai = hawai check box
        CheckBox lakshadweep = (CheckBox) findViewById(lakshadweep_checkbox); // lakshadweep = lakshadweep check box
        CheckBox saudiArabia = (CheckBox) findViewById(saudiArabia_checkbox); // saudiArabia = saudiArabia check box
        CheckBox kuwait = (CheckBox) findViewById(kuwait_checkbox); // kuwait = kuwait check box
        CheckBox turkey = (CheckBox) findViewById(turkey_checkbox); // turkey = turkey check box
        CheckBox srilanka = (CheckBox) findViewById(srilanka_checkbox); // srilanka = srilanka check box
        CheckBox mexico = (CheckBox) findViewById(mexico_checkbox); // mexico = mexico check box
        CheckBox india = (CheckBox) findViewById(india_checkbox); // india = india check box

        if (euro)  //if euro is selected then plus one point
        {
            score = score + 1;
        }

        if (delhi) { //if delhi is selected then plus one point
            score = score + 1;
        }

        if (washington) { //if washington is selected then plus one point
            score = score + 1;
        }

        String n_or_s = antarticaLocation.getText().toString().trim();// get text entered in question 4 and convert it to string and store it in a variable "n_or_s"
        String china_n_or_south = chinaLocation.getText().toString().trim(); // get text entered in question 5 and convert it to string and store it in a variable "china_n_or_s"

        if (n_or_s.equals("south")) { //if correct answer was given then plus one point
            score = score + 1;
        }

        if (china_n_or_south.equals("north")) { //if correct answer was given then plus one point
            score = score + 1;
        }

        if (mexico.isChecked() == true || india.isChecked() == true) { // if Hawai and Lakshadweep is selected then add one point

        } else if (hawai.isChecked() == true && lakshadweep.isChecked() == true) {
            score = score + 1;
        }

        if (srilanka.isChecked() == true || turkey.isChecked() == true) { // if Saudi Arabia and Kuwait is selected then add one point

        } else if (kuwait.isChecked() == true && saudiArabia.isChecked() == true) {
            score = score + 1;
        }

        if (score >= 6) {
            Toast toast = Toast.makeText(getApplicationContext(), "You scored pretty well, Your score is  " + score, Toast.LENGTH_LONG); // If score is more than 6 than it will display "You scored pretty well, Your score is (here it will display score)
            toast.show(); //display toast
        } else if (score >= 4) {
            Toast toast = Toast.makeText(getApplicationContext(), "You scored good, Your score is  " + score, Toast.LENGTH_LONG); // If score is more than 4 than it will display "You scored good, Your score is (here it will display score)
            toast.show(); //display toast
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "You need improvement, You scored " + score, Toast.LENGTH_SHORT);// If score is less than 4 than it will display "you need improvement, Your score is (here it will display score)
            toast.show(); //display toast
        }

        score = 0;

        Intent i = getBaseContext().getPackageManager()    //Restart app after displaying score. (got it from Stack Overflow)
                .getLaunchIntentForPackage(getBaseContext().getPackageName());  //Stack Overflow code link - https://stackoverflow.com/questions/15564614/how-to-restart-an-android-application-programmatically
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }


}