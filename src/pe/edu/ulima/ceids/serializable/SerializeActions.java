package pe.edu.ulima.ceids.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class SerializeActions {
	
	//Convierte un objeto en arreglo de byte
	public static byte[] objectToByte(Object object){
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ObjectOutput outObject=null;
		
		byte[] buffer = null;
		
		try {
			outObject = new ObjectOutputStream(baos);
			outObject.writeObject(object);
			buffer = baos.toByteArray();
		} catch (IOException e) {

			e.printStackTrace();
		}finally{
			if(outObject != null){
				try {
					outObject.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return buffer;
		
	}
	
	
	//Convierte un arreglo de byte en objeto
	public static Object byteToObject(byte [] arrayByte){
		Object object = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new ByteArrayInputStream(arrayByte));
			try {
				object = ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (StreamCorruptedException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally{
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return object;
		
	}
	
		

}
