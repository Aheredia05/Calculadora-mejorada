package com.example.maana.pe_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etDisplay;
    double operando1;
    Operacion operacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay = (EditText)findViewById(R.id.display);
    }

    public void numeroPulsado(View v){
        Button botonNumerico = (Button)v;
        String sNumero = botonNumerico.getText().toString();
        String sDisplay = etDisplay.getText().toString();
        sDisplay += sNumero;
        etDisplay.setText(sDisplay);
    }

    public void operacionPulsada(View v){
        String sOperacion = v.getTag().toString();
        if(sOperacion.equalsIgnoreCase("sumar")){
            operacion = Operacion.SUMAR;
        }else if(sOperacion.equalsIgnoreCase("restar")){
            operacion = Operacion.RESTAR;
        }else if(sOperacion.equalsIgnoreCase("multiplicar")){
            operacion = Operacion.MULTIPLICAR;
        }else if(sOperacion.equalsIgnoreCase("dividir")){
            operacion = Operacion.DIVIDIR;
        }else if(sOperacion.equalsIgnoreCase("sin")){
            operacion = Operacion.SIN;
        }else if(sOperacion.equalsIgnoreCase("cos")){
            operacion = Operacion.COS;
        }else if(sOperacion.equalsIgnoreCase("tan")){
            operacion = Operacion.TAN;
        }

        String sNumero = etDisplay.getText().toString();
        operando1 = Double.parseDouble(sNumero);
        limpiarDisplay();
    }

    public void calcular(View v){

        double resultado = 0;
        if(operacion == Operacion.SUMAR){
            String sOperando2 = etDisplay.getText().toString();
            double operando2 = Double.parseDouble(sOperando2);
            resultado = operando1 + operando2;

        }else if(operacion == Operacion.RESTAR){
            String sOperando2 = etDisplay.getText().toString();
            double operando2 = Double.parseDouble(sOperando2);
            resultado = operando1 - operando2;

        }else if(operacion == Operacion.MULTIPLICAR){
            String sOperando2 = etDisplay.getText().toString();
            double operando2 = Double.parseDouble(sOperando2);
            resultado = operando1 * operando2;

        }else if(operacion == Operacion.DIVIDIR){
            String sOperando2 = etDisplay.getText().toString();
            double operando2 = Double.parseDouble(sOperando2);
            resultado = operando1 / operando2;

        }else if(operacion == Operacion.SIN){
            resultado = Math.sin(operando1);
        }else if(operacion == Operacion.COS){
            resultado = Math.cos(operando1);
        }else if(operacion == Operacion.TAN){
            resultado = Math.tan(operando1);
        }

        etDisplay.setText(String.valueOf(resultado));
    }

    private void limpiarDisplay() {
        etDisplay.setText("");
    }

    public void resetear(View v){
        operando1 = 0;
        operacion = null;
        limpiarDisplay();
    }


}
