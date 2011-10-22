package pe.edu.ulima.ceids.serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Prueba_SerializableActivity extends Activity {
    
	private EditText et_nombre, et_apellido;
	
	private AlumnoDTO alumno;
	
	public final static String KEY_ALUMNO = "alumno";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        //Inicializar views del xml
        
        this.et_nombre = (EditText) findViewById(R.id.et_nombre);
        this.et_apellido = (EditText) findViewById(R.id.et_apellido);
        
        //Inicializar objeto alumno
        
        this.alumno = new AlumnoDTO();
        
        //Cambio de orientación
        
        if(savedInstanceState != null){
        	
        	this.alumno = (AlumnoDTO) SerializeActions.byteToObject( savedInstanceState.getByteArray(KEY_ALUMNO) );
        	this.et_apellido.setText( this.alumno.apellido );
        	this.et_nombre.setText( this.alumno.nombre );
        	
        }
        
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	
    	outState.putByteArray(KEY_ALUMNO, SerializeActions.objectToByte(alumno));
    	
    }
    
    
    //Acción de guardar en dto
    
    public void saveToDTO(View v){
    	
    	this.alumno.apellido = this.et_apellido.getText().toString();
    	this.alumno.nombre = this.et_nombre.getText().toString();
    	
    }
    
    public void openActivity(View v){

    	Intent intent = new Intent(this, Activity_RecibirDTO.class);
    	
    	intent.putExtra( KEY_ALUMNO, SerializeActions.objectToByte( alumno ) );
    	
    	startActivity( intent );
    	
    }
    
}