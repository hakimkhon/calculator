package uz.hakimkhon.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import uz.hakimkhon.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private double value1, value2,  value3, natija;
    private char amallar;
    private StringBuilder valueBuilder = new StringBuilder();
    private StringBuilder malumotBuilder = new StringBuilder();
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @SuppressLint("")
    public void raqamBosish(View view){
        valueBuilder = new StringBuilder(binding.edidNatija.getText().toString());
        malumotBuilder = new StringBuilder(binding.malumot.getText().toString());
        switch (view.getId()){
            case R.id.btnZero:
                if (valueBuilder.length() > 0) {
                    valueBuilder.append("0");
                    malumotBuilder.append("0");
                }
                break;
            case R.id.btnOne:
                valueBuilder.append("1");
                malumotBuilder.append("1");
                break;
            case R.id.btnTwo:
                valueBuilder.append("2");
                malumotBuilder.append("2");
                break;
            case R.id.btnThree:
                valueBuilder.append("3");
                malumotBuilder.append("3");
                break;
            case R.id.btnFour:
                valueBuilder.append("4");
                malumotBuilder.append("4");
                break;
            case R.id.btnFive:
                valueBuilder.append("5");
                malumotBuilder.append("5");
                break;
            case R.id.btnSix:
                valueBuilder.append("6");
                malumotBuilder.append("6");
                break;
            case R.id.btnSeven:
                valueBuilder.append("7");
                malumotBuilder.append("7");
                break;
            case R.id.btnEight:
                valueBuilder.append("8");
                malumotBuilder.append("8");
                break;
            case R.id.btnNine:
                valueBuilder.append("9");
                malumotBuilder.append("9");
                break;
            case R.id.btnNuqta:
                if (valueBuilder.length() == 0){
                    valueBuilder.append("0.");
                    malumotBuilder.append("0.");
                }
                if (malumotBuilder.indexOf(".") == -1) {
                    valueBuilder.append(".");
                    malumotBuilder.append(".");
                }
                break;
            case R.id.btnPlusMinus:
                if (malumotBuilder.indexOf("-") == -1) {
                    valueBuilder.append("-", 0, 1);
                    malumotBuilder.append("-", 0, 1);
                }
                break;
            case R.id.btnFoiz:
                if (valueBuilder.length() > 0 && malumotBuilder.indexOf("%") == -1) {
                    valueBuilder.append("%");
                    malumotBuilder.append("%");
                }
                break;
            case R.id.btnC:
                valueBuilder.setLength(0);
                malumotBuilder.setLength(0);
                break;
            case R.id.btnDelete:
                if (valueBuilder.length() > 0) {
                    valueBuilder.deleteCharAt(valueBuilder.length() - 1);
                }
                if (malumotBuilder.indexOf("=") != -1) {
                    valueBuilder.setLength(0);
                    malumotBuilder.setLength(0);
                }
                if (malumotBuilder.length() > 0) {
                    malumotBuilder.deleteCharAt(malumotBuilder.length() - 1);
                }

                break;
        }
        binding.edidNatija.setText(valueBuilder.toString());
        binding.malumot.setText(malumotBuilder.toString());
    }
    public void matematikAmallar(View view){
        switch (view.getId()){
            case R.id.btnKupaytrish: amallar = 'x'; break;
            case R.id.btnBulish: amallar = '/'; break;
            case R.id.btnPlus: amallar = '+'; break;
            case R.id.btnMinus: amallar = '-'; break;
        }
        if (binding.edidNatija.getText().length() > 0){
            String value = binding.edidNatija.getText().toString();
            value1 = Double.parseDouble(value);
            malumotBuilder.append(amallar);
            binding.malumot.setText(malumotBuilder.toString());
            binding.edidNatija.setText("");
        }
    }
    public void barobar(View view){
        if (binding.edidNatija.getText().length() > 0){
            String value = binding.edidNatija.getText().toString();
            value2 = Double.parseDouble(value);
        }
        switch (amallar){
            case '+': natija = value1 + value2; break;
            case '-': natija = value1 - value2; break;
            case 'x': natija = value1 * value2; break;
            case '/': natija = value1 / value2; break;
        }
        malumotBuilder.append("=" + natija);
        binding.edidNatija.setText(String.valueOf(natija));
        binding.malumot.setText(malumotBuilder.toString());
    }

}