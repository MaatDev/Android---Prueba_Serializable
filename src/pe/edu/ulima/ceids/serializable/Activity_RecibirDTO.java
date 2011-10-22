package pe.edu.ulima.ceids.serializable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_RecibirDTO extends Activity{
	
	private TextView tv_nombre, tv_apellido;
	
	private AlumnoDTO alumno;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recibir);
		
		//Inicializar view del xml
		
		this.tv_apellido = (TextView) findViewById(R.id.tv_apellido);
		this.tv_nombre = (TextView) findViewById(R.id.tv_nombre);
		
		//Obtener objeto del intent
		
		byte [] byteArray;
		
		if( savedInstanceState == null ){
			byteArray = getIntent().getByteArrayExtra(Prueba_SerializableActivity.KEY_ALUMNO);
			
			this.alumno = (AlumnoDTO) SerializeActions.byteToObject( byteArray );
		}else{
			
			byteArray = savedInstanceState.getByteArray( Prueba_SerializableActivity.KEY_ALUMNO );
			
			this.alumno = (AlumnoDTO) SerializeActions.byteToObject( byteArray );
			
		}
		
		this.tv_apellido.setText( this.alumno.apellido );
		this.tv_nombre.setText( this.alumno.nombre );
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putByteArray(Prueba_SerializableActivity.KEY_ALUMNO,  SerializeActions.objectToByte( alumno ) );
		
	}

}
