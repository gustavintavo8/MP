/**
 * Prácticas de Metodología de la Programación.
 * Clase VectorDinamicoPersonajes - Clase que permite representar vectores dinámicos de Personajes 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class VectorDinamicoStrings extends VectorDinamicoObjects{

	public VectorDinamicoStrings(){
		
	}
	
	public VectorDinamicoStrings(VectorDinamicoStrings vDE){
		super(vDE);
	}
	
	public VectorDinamicoStrings(int size){
		super(size);
	}
	
	public VectorDinamicoStrings(String[] v){
		super((Object[])v);
	}
	
	@Override	
	public String get(int i){
		return (String)super.get(i);
	}
	
	
	// Otros metodos
	@Override
	public String [] vectorNormal(){ // devuelve un String [] con los strings de vDE
		String [] temp = new String[this.length()];
		for (int i = 0; i<temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}


}




