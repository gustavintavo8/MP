
public class ExamenTeoriaMayo2018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Servicio Informatica = new Servicio("Informatica", 1500);
		PAS pas1 = new PAS("Pepe Lopez", "44553377G", 23, Informatica);
		
		Servicio Investigacion = new Servicio("Investigacion", 1600);
		PAS pas2 = new PAS("Juan Garcia", "99776633H", 13, Investigacion);
		PAS pas3 = new PAS("Maria Lopez", "8765400R", 5, Investigacion);
		
		System.out.println(pas1 );
		System.out.println(pas2 );
		System.out.println(pas3 );
		
		PDI_Funcionario pdi_f1 = new PDI_Funcionario("Luis Perez", "7788998877X", 22, "Biologia Molecular", 3, 2);
		PDI_Funcionario pdi_f2 = new PDI_Funcionario("Jose Lopez", "909876871Z", 32, "Quimica Organica", 5, 4);
		
		System.out.println(pdi_f1);
		System.out.println(pdi_f2);
		
		PDI_NoFuncionario pdi_nf1 = new PDI_NoFuncionario("Pedro Lopez", "9991198877J", 14, "Ingenieria Electrica");
		PDI_NoFuncionario pdi_nf2 = new PDI_NoFuncionario("Luis Rodriguez", "8987676T", 7, "Derecho Publico");
		
		System.out.println(pdi_nf1);
		System.out.println(pdi_nf2);
		
		// Vectores
		Servicio [] servicio = {Informatica,Investigacion};
		PersonalUniversidad [] personal = {pas1, pas2, pas3, pdi_f1, pdi_f2, pdi_nf1, pdi_nf2};
		System.out.println("\nLos vesctores Inicialmente: ");
		muestra(servicio);
		muestra(personal);
		
		// Algoritmos
		
		System.out.println("\nDepartamento del PDI que mas gana: " + 
		                     departamentoDelPDIQueMasGana(personal)); // el departamento del PDI que mas gana
		
		System.out.println("\nCoste de despedir a todos los laborales: " +
		                                        costeDespedirTodos(personal));
		
		System.out.format("\nServicio con mas empleados: %s", servicioConMasEmpleados(servicio, personal)); // el servicio con mas empleados
		
		
	}


	private static void muestra(Object[] obs) {
		// TODO Auto-generated method stub
		for (Object o: obs)
			System.out.println(o);
		
	}

	private static float costeDespedirTodos(PersonalUniversidad[] personal) {
		// TODO Auto-generated method stub
		float coste = 0;
		for (PersonalUniversidad p: personal)
			if (p instanceof Laboral)
				coste += ((Laboral)p).indemnizacionPorDespido();
		return coste;
	}

	private static String departamentoDelPDIQueMasGana(PersonalUniversidad [] personal) {
		// TODO Auto-generated method stub
		if (personal == null) return null;
		String departamento = "-";
		float masGana = 0;
		for(PersonalUniversidad p: personal) {
			if (p instanceof PDI && p.salario() > masGana) {
				masGana = p.salario();
				departamento = ((PDI)p).getDepartamento();
			}
		}
		return departamento;
	}
	
	private static Servicio servicioConMasEmpleados(Servicio[] servicio, PersonalUniversidad[] personal) {
		// TODO Auto-generated method stub
		int [] empleadosServicio = new int [servicio.length]; // para contar los PAS de cada servicio
		for (int i = 0; i<personal.length; i++) { // recorremos el vector de personal
			if (personal[i] instanceof PAS) { // si es un PAS
				int j=0; // buscamos la posicion j de su servicio en empleadosServicio
				while (j<servicio.length && ((PAS)personal[i]).getServicio() != servicio[j])
					j++;
				if (j<servicio.length) empleadosServicio[j]++; // incrementamos el numero de PAS del sercvicio j
				else System.out.println("\nOjo, el PAS " + personal[i] + " no tiene servicio");
			}
		}
		// Maximo de empleadosServicio 
		int imax = 0; 
		for (int i=1; i<empleadosServicio.length; i++)	
			if (empleadosServicio[i] > empleadosServicio[imax]) imax = i;
			
		return servicio[imax];
	}


	
	

}
