package com.example.goodpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText x1;
    private EditText x2;
    private EditText x3;
    private EditText x4;
    private EditText y1;
    private EditText y2;
    private EditText y3;
    private EditText y4;

    public double xx1;
    public double xx2;
    public double xx3;
    public double xx4;
    public double yy1;
    public double yy2;
    public double yy3;
    public double yy4;

    private Button pryamaya;
    private Button okrujnost;
    private Button reset;
    private Button resetText;
    private Button generateText;

    private TextView vivod;
    private TextView vivod2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x3 = findViewById(R.id.x3);
        x4 = findViewById(R.id.x4);

        y1 = findViewById(R.id.y1);
        y2 = findViewById(R.id.y2);
        y3 = findViewById(R.id.y3);
        y4 = findViewById(R.id.y4);

        pryamaya = findViewById(R.id.pryamaya);
        pryamaya.setOnClickListener(this);
        okrujnost = findViewById(R.id.okrujnost);
        okrujnost.setOnClickListener(this);
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);
        resetText = findViewById(R.id.resetText);
        resetText.setOnClickListener(this);
        generateText = findViewById(R.id.generateText);
        generateText.setOnClickListener(this);

        vivod = findViewById(R.id.vivod);
        vivod2 = findViewById(R.id.vivod2);

        try {
            xx1 = Double.parseDouble(x1.getText().toString());
            xx2 = Double.parseDouble(x2.getText().toString());
            xx3 = Double.parseDouble(x3.getText().toString());
            xx4 = Double.parseDouble(x4.getText().toString());

            yy1 = Double.parseDouble(y1.getText().toString());
            yy2 = Double.parseDouble(y2.getText().toString());
            yy3 = Double.parseDouble(y3.getText().toString());
            yy4 = Double.parseDouble(y4.getText().toString());
        } catch (RuntimeException ignored) {
            // NPE or parsing failed, double1 == -1.0
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pryamaya:
                if ((xx1-xx3)*(yy2-yy3)-(xx2-xx3)*(yy1-yy3) == 0) {
                    vivod.setText("Точки (x1 , y1); (x2 , y2); (x3 , y3) лежат на одной прямой");
                } else if ((xx2-xx4)*(yy3-yy4)-(xx3-xx4)*(yy2-yy4) == 0) {
                    vivod.setText("Точки (x2 , y2); (x3 , y3); (x4 , y4) лежат на одной прямой");
                } else if ((xx1-xx4)*(yy2-yy4)-(xx2-xx4)*(yy1-yy4) == 0) {
                    vivod.setText("Точки (x1 , y1); (x2 , y2); (x4 , y4) лежат на одной прямой");
                } else if ((xx1-xx4)*(yy3-yy4)-(xx3-xx4)*(yy1-yy4) == 0) {
                    vivod.setText("Точки (x1 , y1); (x3 , y3); (x4 , y4) лежат на одной прямой");
                } else if (((xx1-xx3)*(yy2-yy3)-(xx2-xx3)*(yy1-yy3) == 0) && ((xx2-xx4)*(yy3-yy4)-(xx3-xx4)*(yy2-yy4) == 0) && ((xx1-xx4)*(yy2-yy4)-(xx2-xx4)*(yy1-yy4) == 0) && ((xx1-xx4)*(yy3-yy4)-(xx3-xx4)*(yy1-yy4) == 0)) {
                    vivod.setText("Точки (x1 , y1); (x2 , y2); (x3 , y3); (x4 , y4) лежат на одной прямой");
                } else {
                    vivod.setText("Точки не лежат на прямой");
                }
                break;

            case R.id.okrujnost:
                if ((xx1 * xx1 + yy1 * yy1) == (xx2 * xx2 + yy2 * yy2)) {
                    vivod2.setText("Точки (x1 , y1); (x2 , y2) лежат на окружности");
                } else if ((xx1 * xx1 + yy1 * yy1) == (xx3 * xx3 + yy3 * yy3)) {
                    vivod2.setText("Точки (x1 , y1); (x3 , y3) лежат на окружности");
                } else if ((xx1 * xx1 + yy1 * yy1) == (xx4 * xx4 + yy4 * yy4)) {
                    vivod2.setText("Точки (x1 , y1); (x4 , y4) лежат на окружности");
                } else if ((xx2 * xx2 + yy2 * yy2) == (xx3 * xx3 + yy3 * yy3)) {
                    vivod2.setText("Точки (x1 , y1); (x2 , y2) лежат на окружности");
                } else if ((xx2 * xx2 + yy2 * yy2) == (xx4 * xx4 + yy4 * yy4)) {
                    vivod2.setText("Точки (x2 , y2); (x4 , y4) лежат на окружности");
                } else if ((xx3 * xx3 + yy3 * yy3) == (xx4 * xx4 + yy4 * yy4)) {
                    vivod2.setText("Точки (x1 , y1); (x2 , y2) лежат на окружности");
                } else if (((xx1 * xx1 + yy1 * yy1) == (xx2 * xx2 + yy2 * yy2)) && ((xx2 * xx2 + yy2 * yy2) == (xx3 * xx3 + yy3 * yy3))) {
                    vivod2.setText("Точки (x1 , y1); (x2 , y2); (x3 , y3) лежат на окружности");
                } else if (((xx1 * xx1 + yy1 * yy1) == (xx3 * xx3 + yy3 * yy3)) && ((xx3 * xx3 + yy3 * yy3) == (xx4 * xx4 + yy4 * yy4))) {
                    vivod2.setText("Точки (x1 , y1); (x3 , y3); (x4 , y4) лежат на окружности");
                } else if (((xx1 * xx1 + yy1 * yy1) == (xx2 * xx2 + yy2 * yy2)) && ((xx2 * xx2 + yy2 * yy2) == (xx4 * xx4 + yy4 * yy4))) {
                    vivod2.setText("Точки (x1 , y1); (x2 , y2); (x4 , y4) лежат на окружности");
                } else if (((xx1 * xx1 + yy1 * yy1) == (xx2 * xx2 + yy2 * yy2)) && ((xx2 * xx2 + yy2 * yy2) == (xx3 * xx3 + yy3 * yy3)) && ((xx3 * xx3 + yy3 * yy3) == (xx4 * xx4 + yy4 * yy4))) {
                    vivod2.setText("Точки (x1 , y1); (x2 , y2); (x3 , y3); (x4 , y4) лежат на окружности");
                } else {
                    vivod2.setText("Точки не лежат на окружности");
                }
                break;

            case R.id.reset:

                x1.getText().clear();
                x2.getText().clear();
                x3.getText().clear();
                x4.getText().clear();

                y1.getText().clear();
                y2.getText().clear();
                y3.getText().clear();
                y4.getText().clear();
                break;

            case R.id.resetText:

                vivod.setText("");
                vivod2.setText("");
                break;

            case R.id.generateText:

                x1.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));
                x2.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));
                x3.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));
                x4.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));

                y1.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));
                y2.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));
                y3.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));
                y4.setText(Double.toString(getRandomDoubleBetweenRange(1.0, 100.00)));
                break;

        }

    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }


}