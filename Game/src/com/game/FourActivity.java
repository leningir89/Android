package com.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class FourActivity extends Activity {

	TextView txtvPregunta; 
	ImageButton btn1;	
	ImageButton btn2;	
	
	private String pregunta="";
	private String categoria="";
	private String nivel="";
	private final static String TAG="Debug"; 	
	private String preguntasVarios[]= {"El número 5 es:","Que figura tiene 4 lados","Cuanto es 10-4:"};
	private String preguntasFrutas[]={"Es una fresa:","Que fruta tiene vitamina C:", "Es un mango:"};
	private String preguntasAnimales[]={"Es un gato:","Es un elefante:", "Es una murcielago"};
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_four);
		
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
				btn1.setBackgroundResource(R.drawable.cinco );
			    btn2.setBackgroundResource(R.drawable.seis );				
			}
			else if(nivel.equals("Nivel 2"))
			{	
				pregunta= preguntasVarios[1];		
				btn1.setBackgroundResource(R.drawable.triangulo );
			    btn2.setBackgroundResource(R.drawable.cuadrado );
				
			}
			else if(nivel.equals("Nivel 3"))
			{
				pregunta= preguntasVarios[2];		
				btn1.setBackgroundResource(R.drawable.dos );
			    btn2.setBackgroundResource(R.drawable.seis );
			}
		}
		else if(categoria.equals("F"))
		{
			if(nivel.equals("Nivel 1"))
			{
				pregunta= preguntasFrutas[0];		
				btn1.setBackgroundResource(R.drawable.fresa );
			    btn2.setBackgroundResource(R.drawable.manzana );
			}
			else if(nivel.equals("Nivel 2"))
			{
				pregunta= preguntasFrutas[1];		
				btn1.setBackgroundResource(R.drawable.fresa );
			    btn2.setBackgroundResource(R.drawable.naranja);	
			}
			else if(nivel.equals("Nivel 3"))
			{
				pregunta= preguntasFrutas[2];		
				btn1.setBackgroundResource(R.drawable.pera);
			    btn2.setBackgroundResource(R.drawable.mango);	
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
				};
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
				        Main.class);
				Toast.makeText(getApplicationContext(), "Felicidades has completado la etapa", Toast.LENGTH_SHORT).show();        	             		
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
				        Main.class);
				Toast.makeText(getApplicationContext(), "Felicidades has completado la etapa", Toast.LENGTH_SHORT).show();        	             		
				startActivity(start_intent);
			}	
			else
			{
				Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();        	             
			}
		
		}		
	}
}