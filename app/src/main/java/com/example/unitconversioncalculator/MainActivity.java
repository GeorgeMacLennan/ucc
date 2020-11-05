package com.example.unitconversioncalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView inputLabel;
    private TextView outputLabel;
    private TextView outputMeasurement;
    private EditText inputMeasurement;
    Conversion conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversion = new Conversion();
        setUpReferenceDisplay();
    }

    private void setUpReferenceDisplay() {
        inputLabel = (TextView) findViewById(R.id.textView1);
        inputLabel.setText(conversion.inputLabel);

        outputLabel = (TextView) findViewById(R.id.textView2);
        outputLabel.setText(conversion.outputLabel);

        outputMeasurement = (TextView) findViewById(R.id.textView3);
        outputMeasurement.setText(conversion.outputValue.toString());

        inputMeasurement = (EditText) findViewById(R.id.editText1);
        inputMeasurement.setText(conversion.inputValue.toString());
        inputMeasurement.addTextChangedListener(inputTextWatcher);
    }

    private TextWatcher inputTextWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                conversion.inputValue = Double.parseDouble(s.toString());
            } catch (NumberFormatException e) {
                conversion.inputValue = 0.0;
            }
            conversion.compute();
            outputMeasurement.setText(conversion.outputValue.toString());
        }
        public void afterTextChanged(Editable editable) {}
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            toggleActionBar();
        }
        return true;
    }

    private void toggleActionBar() {
        ActionBar actionBar = getActionBar();

        if (actionBar != null) {
            if (actionBar.isShowing()) {
                actionBar.hide();
            }
            else {
                actionBar.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_ft_to_m) {
            conversion.switch_toFtM();
            resetDisplay();
            return true;
        }

        else if (id == R.id.menu_item_in_cm) {
            conversion.switch_toInCm();
            resetDisplay();
            return true;
        }

        else if (id == R.id.menu_lbs_to_g) {
            conversion.switch_toLbG();
            resetDisplay();
            return true;
        }

        else if (id == R.id.menu_mi_to_km) {
            conversion.switch_toMiKm();
            resetDisplay();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void resetDisplay() {
        inputLabel.setText(conversion.inputLabel);
        outputLabel.setText(conversion.outputLabel);
        outputMeasurement.setText(conversion.outputValue.toString());
        inputMeasurement.setText(conversion.inputValue.toString());
    }
}
