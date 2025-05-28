

class A{
	public String m1()
	{ return "soy A";}
}

class B extends A{
	public String m1()
	{ return "soy B";}
	public String m2()
	{ return "sigo siendo B";}
	
}

class C extends B{
	public String m1()
	{ return "soy C";}
	public String m3()
	{return "aun soy C";}
}

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a1 = new B();
		A a2 = new C();
		//   (B)a1.m2(); <- da error por la precedencia del operador '.' que es mayor que la de '()'
		((B)a1).m2(); // correcto ya que a1 es un objeto de tipo B
		((B)a2).m2();  // correcto ya que a2 es un objeto de tipo C y por tanto de tipo B
		
		System.out.println("Hasta aquí todo correcto.");
		((C)a2).m3();  // correcto ya que a2 es un objeto de tipo C
		((C)a1).m3();  // INCORRECTO-> Error en tiempo de ejecución, a1 es de tipo B y (por herencia) A; pero no de tipo C
		
		
	}

}
