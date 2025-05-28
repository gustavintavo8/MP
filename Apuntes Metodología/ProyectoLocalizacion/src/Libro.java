
public class Libro extends Object{
	
	private String titulo, editorial, autor;
	private int fechaPubli;
	
	public Libro(String titulo, String editorial, String autor, int fechaPubli) {
		super();
		this.titulo = titulo;
		this.editorial = editorial;
		this.autor = autor;
		this.fechaPubli = fechaPubli;
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}
	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * @return the fechaPubli
	 */
	public int getFechaPubli() {
		return fechaPubli;
	}
	/**
	 * @param fechaPubli the fechaPubli to set
	 */
	public void setFechaPubli(int fechaPubli) {
		this.fechaPubli = fechaPubli;
	}

	@Override
	public String toString() {
		return "Libro [" + titulo + ", editorial=" + editorial + ", autor=" + autor + ", fechaPubli="
				+ fechaPubli + "]";
	}
	
	
	

}
