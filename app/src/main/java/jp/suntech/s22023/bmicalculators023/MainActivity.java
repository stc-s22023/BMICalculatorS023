package jp.suntech.s22023.bmicalculators023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConfirm = findViewById(R.id.btCal);
        Button btClear = findViewById(R.id.btClear);

        btConfirm.setOnClickListener(new ButtonClickListener());
        btClear.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            EditText age = findViewById(R.id.etName);
            EditText height = findViewById(R.id.etMail);
            EditText weight = findViewById(R.id.etMailTitle);
            TextView output1 = findViewById(R.id.bmi1);
            TextView output2 = findViewById(R.id.bmi2);
            TextView output3 = findViewById(R.id.bmi3);
            TextView output4 = findViewById(R.id.bmi4);
            TextView output5 = findViewById(R.id.bmi5);

            String age_s = age.getText().toString();

            int id = view.getId();
            if (id == R.id.btCal) {
                int a = Integer.parseInt(age_s);
                double h = Float.parseFloat(height.getText().toString());
                double w = Float.parseFloat(weight.getText().toString());
                double y_bmi_w = w / (h / 100 * h / 100);
                double y_bmi_t = (h / 100 * h / 100) * 22;
                String y_bmi_l;

                if (y_bmi_w < 18.5) {
                    y_bmi_l = "低体重（瘦せ型）";
                } else if (y_bmi_w >= 18.5 && y_bmi_w < 25) {
                    y_bmi_l = "普通体重";
                } else if (y_bmi_w >= 25 && y_bmi_w < 30) {
                    y_bmi_l = "肥満（１度）";
                } else if (y_bmi_w >= 30 && y_bmi_w < 35) {
                    y_bmi_l = "肥満（2度）";
                } else if (y_bmi_w >= 35 && y_bmi_w < 40) {
                    y_bmi_l = "肥満（3度）";
                } else {
                    y_bmi_l = "肥満（4度）";
                }

                String show1 = "あなたの肥満度は\n";
                String show2 = y_bmi_l;
                String show3 = "\nあなたの適正体重は\n";
                String show4 = String.format("%.1f", y_bmi_t);
                String show5 = "kg";

                output1.setText(show1);
                output2.setText(show2);
                output3.setText(show3);
                output4.setText(show4);
                output5.setText(show5);
            } else if (id == R.id.btClear) {
                age.setText("");
                height.setText("");
                weight.setText("");

                output1.setText("");
                output2.setText("");
                output3.setText("");
                output4.setText("");
                output5.setText("");
            }
        }
    }
}
