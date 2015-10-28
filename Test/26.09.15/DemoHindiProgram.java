
public class DemoHindiProgram {
	public static void main(String... s) {
		java.util.Locale हिन्दी = new java.util.Locale("hi", "IN");
		int लंबाई = 20;
		int चौड़ाई = 10;
		int क्षेत्रफल;
		क्षेत्रफल = लंबाई * चौड़ाई;
		System.out.printf(हिन्दी, "%dn", क्षेत्रफल);
	}
}