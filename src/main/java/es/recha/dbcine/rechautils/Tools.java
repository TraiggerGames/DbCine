package es.recha.dbcine.rechautils;

public class Tools {
	// Clear Screen
	public static void clearScreen() {
		for (int i = 00; i < 100; i++) {
			System.out.println("");
		}

	}

	// hace una pausa en programa util para leer los menus antes de que desaparezcan
	// con clearScreen
	public static void pauseBeforeCleanScreen(int seconds) {
		int milisecons = seconds * 1000;
		try {
			Thread.sleep(milisecons);

		} catch (InterruptedException e) {

		}
	}

	// random range
	public static int randomRange(int min, int max) {

		int aleatorio = (int) (Math.random() * (max - min + 1) + min);
		if (min > max) {
			System.out.println("el valor minimo no puede ser mayor que el maximo ");
			return 0;
		}
		return aleatorio;

	}

	public static double randomRange(double min, double max) {

		double aleatorio = (double) (Math.random() * (max - min + 1) + min);
		if (min > max) {
			System.out.println("el valor minimo no puede ser mayor que el maximo ");
			return 0;
		}
		return aleatorio;

	}

	public static String getClassName(Object object) {
		String className = object.getClass().getCanonicalName();
		int posPunto = className.lastIndexOf(".");
		String clase = className.substring(posPunto + 1);
		return clase;
	}

}
