
public class prueba1 {
	public static void main(String[] args) {
		try {
			method1(); // call method1
		} // end try
		catch (Exception exception) { // catch exception thrown in method1
			System.err.printf("%s\n\n", exception.getMessage());
			exception.printStackTrace(); // print exception stack trace
			StackTraceElement[] traceElements = exception.getStackTrace();
			for (StackTraceElement element : traceElements) {
				System.out.printf("%s\t", element.getClassName());
				System.out.printf("%s\t", element.getFileName());
				System.out.printf("%s\t", element.getLineNumber());
				System.out.printf("%s\n", element.getMethodName());
			}

		}
	}

	private static void method1() throws ArithmeticException{
		System.out.println("Peto");
		if(true) throw new ArithmeticException("elol");
		
		
	}
}
