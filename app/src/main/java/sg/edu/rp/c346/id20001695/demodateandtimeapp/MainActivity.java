package sg.edu.rp.c346.id20001695.demodateandtimeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            int actualHour = 0;
            int actualMinute = 0;
            @Override
            public void onClick(View v) {
                actualHour = Integer.parseInt(tp.getCurrentHour().toString());
                actualMinute = Integer.parseInt(tp.getCurrentMinute().toString());
                String timeis = "Time is " + actualHour + ":" + actualMinute;
                tvDisplay.setText(timeis);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                tvDisplay.setText("Date is " + day + "/" + month + "/" + year);
                Log.d("MainActivity onCreate()", "Button reset clicked");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020, 0, 1);
            }
        });
    }

}