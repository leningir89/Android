package com.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TreeActivity extends Activity {

	TextView txtvPregunta; 
	ImageButton btn1;	
	ImageButton btn2;	
	
	private String pregunta="";
	private String categoria="";
	private String nivel="";
	private final static String TAG="Debug"; 	
	private String preguntasVarios[]= {"El número 3 es:","Cuanto es 2 +2:","Que formas tienen las piramides"};
	private String preguntasFrutas[]={"Es una pera:","Fruta de color naranja:", "Es un melon:"};
	private String preguntasAnimales[]={"Es un gato:","Es un elefante:", "Es una murcielago"};
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tree);
		
		Bundle bundle = getIntent().getExtras();
		
		categoria = bundle.getString("categoria");
		nivel=bundle.getString("nivel");	
		
		txtvPregunta = (TextView) findViewById(R.id.txtvPregunta);			
		
		 btn1 = (ImageButton) findViewById(R.id.btn1);
	     btn2 =(ImageButton) findViewById(R.id.btn2);
		
		if(categoria.equals("C"))
		{	
			if(nivel.equals("Nivel 1"))
			{	
				pregunta= preguntasVarios[0];		
				btn1.setBackgroundResource(R.drawable.dos );
			    btn2.setBackgroundResource(R.drawable.tres );				
			}
			else if(nivel.equals("Nivel 2"))
			{	
				pregunta= preguntasVarios[1];
				btn1.setBackgroundResource(R.drawable.cuatro );
			    btn2.setBackgroundResource(R.drawable.dos );
				
			}
			else if(nivel.equals("Nivel 3"))
			{
				pregunta= preguntasVarios[2];
				btn1.setBackgroundResource(R.drawable.triangulo );
			    btn2.setBackgroundResource(R.drawable.cuadrado );
			}
		}
		else if(categoria.equals("F"))
		{
			if(nivel.equals("Nivel 1"))
			{
				pregunta= preguntasFrutas[0];
				btn1.setBackgroundResource(R.drawable.pera );
			    btn2.setBackgroundResource(R.drawable.sandia );
			}
			else if(nivel.equals("Nivel 2"))
			{
				pregunta= preguntasFrutas[1];
				btn1.setBackgroundResource(R.drawable.manzana );
			    btn2.setBackgroundResource(R.drawable.naranja );
			}
			else if(nivel.equals("Nivel 3"))
			{
				pregunta= preguntasFrutas[2];
				btn1.setBackgroundResource(R.drawable.pera );
			    btn2.setBackgroundResource(R.drawable.melon );
			}
		}
		else if(categoria.equals("A"))
		{
			if(nivel.equals("Nivel 1"))
			{
				//pregunta= preguntasAnimales[0];
			}
			else if(nivel.equals("Nivel 2"))
			{
				//pregunta= preguntasAnimales[1];
			}
			else if(nivel.equals("Nivel 3"))
			{
				//pregunta= preguntasAnimales[2];
			}
		}
		
		txtvPregunta.setText(pregunta);
		btn1.setOnClickListener(new btnClick1Listener());
		btn2.setOnClickListener(new btnClick2Listener());    
	}
	
	
	public boolean validaRespuesta(int a)
	{
				
		boolean bandera=false;
		if(categoria.equals("C"))
		{	
			if(nivel.equals("Nivel 1"))
			{	
				//Toast.makeText(getApplicationContext(), "Hizo click", Toast.LENGTH_SHORT).show();        	             		
				if(a == 2)
				{
					bandera=true;
				}					
		
			}
			else if(nivel.equals("Nivel 2"))
			{	
				if(a == 1)
				{
					bandera=true;
				}					
		
			}
			else if(nivel.equals("Nivel 3"))
			{
				if(a == 1)
				{
					bandera=true;
				}	
			}
		}
		else if(categoria.equals("F"))
		{
			if(nivel.equals("Nivel 1"))
			{
				if(a == 1)
				{
					bandera=true;
				}
			}
			else if(nivel.equals("Nivel 2"))
			{
				if(a == 2)
				{
					bandera=true;
				}
			}
			else if(nivel.equals("Nivel 3"))
			{
				if(a == 2)
				{
					bandera=true;
				}
			}
		}
		else if(categoria.equals("A"))
		{
			if(nivel.equals("Nivel 1"))
			{
				//pregunta= preguntasAnimales[0];
			}
			else if(nivel.equals("Nivel 2"))
			{
				//pregunta= preguntasAnimales[1];
			}
			else if(nivel.equals("Nivel 3"))
			{
				//pregunta= preguntasAnimales[2];
			}
		}
		return bandera;
	}
	
	class btnClick1Listener implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			
			boolean ban = validaRespuesta(1);		
			
			if(ban)
			{
				Intent start_intent = new Intent(getApplicationContext(), 
				        FourActivity.class);
						
				start_intent.putExtra("categoria", categoria);			   
				start_intent.putExtra("nivel", nivel);
				
				startActivity(start_intent);
			}	
			else
			{
				Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();        	             
			}
		
		}		
	}
	class btnClick2Listener implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			
			boolean ban = validaRespuesta(2);		
			
			if(ban)
			{
				Intent start_intent = new Intent(getApplicationContext(), 
				        FourActivity.class);
						
				start_intent.putExtra("categoria", categoria);			   
				start_intent.putExtra("nivel", nivel);
				
				startActivity(start_intent);
			}	
			else
			{
				Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();        	             
			}
		
		}		
	}
}
