
public class Tonto extends Bueno{

	public Tonto(String ne) {
		super(ne);
	}
	
	public String toString() {
		return String.format("[Tonto - %s]", super.toString());
	}
}
