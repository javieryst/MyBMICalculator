package sg.edu.rp.c346.mybmicalculator;

import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etWeight;
    EditText etHeigh;
    TextView viewDate;
    TextView viewBMI;
    Button cal;
    Button reset;

    @Override
    protected void onPause() {
        super.onPause();

        Float high = Float.parseFloat(etHeigh.getText().toString());
        Float weight =Float.parseFloat(etWeight.getText().toString());
        String date = viewDate.getText().toString();
        String BMI = viewDate.getText().toString();

        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor preEdit =prefs.edit();

        preEdit.putString("date",date);
        preEdit.putString("BMI",BMI);
        preEdit.putFloat("high",high);
        preEdit.putFloat("weight",weight);

        preEdit.commit();






    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Float high =prefs.getFloat("high",0);
        Float weight =prefs.getFloat("weight",0);
        String date =prefs.getString("date",null);
        String BMI =prefs.getString("date",null);

        etHeigh.setText(high.toString());
        etWeight.setText(weight.toString());
        viewDate.setText(date);
        viewBMI.setText(BMI);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeigh=(EditText)findViewById(R.id.editTexthight);
        etWeight=(EditText)findViewById(R.id.editTextName);
        viewBMI=(TextView)findViewById(R.id.textView3);
        viewDate=(TextView)findViewById(R.id.textView4);
        cal=(Button)findViewById(R.id.cal);
        reset=(Button)findViewById(R.id.Data);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etWeight.setText("");
                etHeigh.setText("");
                viewBMI.setText("");
                viewDate.setText("");

            }
    });

        cal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Calendar now = Calendar.getInstance(); //Create a Calendar object with current date/time
            String datetime = now.get(Calendar.DAY_OF_MONTH)+ "/"+
                    (now.get(Calendar.MONTH)+1) + "/" +
                    now.get(Calendar.YEAR) + " " +
                    now.get(Calendar.HOUR_OF_DAY)+":"+
                    now.get(Calendar.MINUTE);

            


        }

    });

    }

}
