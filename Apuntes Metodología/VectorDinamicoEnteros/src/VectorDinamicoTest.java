
public class VectorDinamicoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] vE = {1, 2, 3, 4, 5};
		VectorDinamicoEnteros vD = new VectorDinamicoEnteros(vE);
		vD.muestra();
		
		
		vD.add(6);
		vD.muestra();
		
		vD.add(7);
		vD.muestra();
		
		vD.add(8);
		vD.muestra();
		
		vD.add(9);
		vD.muestra();
		
		vD.add(10);
		vD.muestra();
		
		vD.add(11);
		vD.muestra();
		
		vD.add(12);
		vD.muestra();
		
		vD.add(13);
		vD.muestra();
		
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.pop();
		vD.muestra();
		
		vD.add(10);
		vD.muestra();
		
		vD.add(11);
		vD.muestra();
		
		vD.add(12);
		vD.muestra();
		
		vD.add(13);
		vD.muestra();
		
		vD.add(14);
		vD.muestra();
		
		vD.remove(2);
		vD.muestra();
		
		vD.insert(3, 20);
		vD.muestra();
		
		
		// Comprobar si los elememntos de un vector estan contenidos en otro de forma conseutiva
		
		// vD.contieneConsecutivos(vD1, vD2); // vD1 contiene a vD2
		
		// Concatena dos, tres o mas vectores .. sin modificarlos
		
		// vD1 = vD2.concatena(vD3); // vD1 = vD2 + vD3
		// vD1 = vD2.concatena(vD3.concatena(vD3)); // vD1 = vD2 + vD3 + vD4;
		

	}

}
