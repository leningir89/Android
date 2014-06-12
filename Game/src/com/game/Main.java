package com.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Main extends Activity {

	private final static String TAG="Debug"; 
	Button btnSiguiente;	
	Button btnSalir;
	RadioGroup rdbGroupCategorias;
	Spinner spnNivel;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir =(Button) findViewById(R.id.btnSalir);
        
        btnSiguiente.setOnClickListener(new SiguienteClickListener());
        btnSalir.setOnClickListener(new SalirClickListener());
        
        spnNivel = (Spinner) findViewById(R.id.spnNivel);
        rdbGroupCategorias = (RadioGroup)findViewById(R.id.groupCategoria);
        //Log.e(TAG, "click");
        //Toast.makeText(getApplicationContext(), "Hizo click", Toast.LENGTH_SHORT).show();        	             
    }
    
    public String getCategoria(int valor)
    {
    	String categoria ="";
    	if(valor == 2131034180)
    	{
    		categoria="C";
    	}
    	else if(valor == 2131034181)
    	{
    		categoria="F";
    	}
    	else if(valor == 2131034182)
    	{
    		categoria="A";
    	}  
    	return categoria;
    }
    
    class SalirClickListener implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			finish();		
		}		
	}
    class SiguienteClickListener implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			
			Intent start_intent = new Intent(getApplicationContext(), 
			        SecondActivity.class);
			
			int idSeleccionado = rdbGroupCategorias.getCheckedRadioButtonId();
			String categoria=getCategoria(idSeleccionado);
			String nivel=spnNivel.getSelectedItem().toString();
			
			start_intent.putExtra("categoria", categoria);			   
			start_intent.putExtra("nivel", nivel);
			startActivity(start_intent);
		}		
	}
	
    
}




