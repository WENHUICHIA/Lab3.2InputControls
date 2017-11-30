package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

import static my.edu.tarc.lab32inputcontrols.R.string.premium;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to the program
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //create an adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Position :" + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos;
        pos = spinnerAge.getSelectedItemPosition();
        int premium = 0;
        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender == R.id.radioButtonMale){
            //TODO: calculate premium for male
            if (pos == 0){
                premium = 50; }
            if(pos == 1){
                premium = 55; }
            if(pos == 2){
                premium = 110; }
            if(pos == 3){
                premium = 170; }
            if(pos == 4){
                premium = 220; }
            if(pos == 5){
                premium = 210; }
            if(pos == 6){
                premium = 200; }
            if(pos == 7){
                premium = 250; }


        }

        if(checkBoxSmoker.isChecked()){
            //TODO: calculate premium of smoker
            ///

        }

        Locale locale = Locale.getDefault();

        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String currencyText = fmt.format(premium);

        //Display
        textViewPremium.setText(getString(R.string.premium) + currencyText);


    }

    public void resetPremium(View view){
        spinnerAge.setSelection(0);
        radioButtonMale.setChecked(true);
        checkBoxSmoker.setChecked(false);

    }
}
