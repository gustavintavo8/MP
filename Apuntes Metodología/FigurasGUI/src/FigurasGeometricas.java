
public abstract class FigurasGeometricas {

	public abstract double area();

	public abstract double perimetro();

	/**
	 * Calcula el área total de un array de figuras geométricas
	 * 
	 * @param figs array de figuras geométricas
	 * @return el área total de todas las figuras
	 */
	static double areaTotal(FigurasGeometricas[] figs) {
		double tmp = 0.00;
		for (int i = 0; i < figs.length; i++) {
			tmp = tmp + figs[i].area();
		}
		return tmp;
	}
	//mostrar
	static void mostrar(FigurasGeometricas[]figs) {
		for (int i = 0; i < figs.length; i++) {
			System.out.println(figs[i].getClass() + ":" + figs[i].area());
		}
	}

	// Ordenar el vector por superficie de menor a mayor
	static void ordena(FigurasGeometricas[] figs) {
		FigurasGeometricas tmp;
		for (int i = 0; i < figs.length - 1; i++) {
			for (int j = i + 1; j < figs.length; j++) {
				if (figs[i].area() > figs[j].area()) {
					tmp = figs[i];
					figs[i] = figs[j];
					figs[j] = figs[i];
				}

			}
		}

	}

}
