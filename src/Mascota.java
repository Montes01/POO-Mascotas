import javax.swing.JOptionPane;

public class Mascota {
// Atributos
	String nombre;
	String especie;
	int edad, id;

// Constructor sin parametros
	public Mascota() {
		id = Integer.parseInt(JOptionPane.showInputDialog("ingrese la identificacion de la mascota"));
	}

// Constructor con parametros
	public Mascota(String nombre, String especie, int edad, int id) {
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.id = id;
	}

// Método para mostrar información de la mascota
	public void mostrarInformacion() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Especie: " + especie);
		System.out.println("Edad: " + edad + " años");
	}

// Método para hacer que la mascota realice un sonido
	public void hacerSonido() {
		if (especie.equalsIgnoreCase("perro")) {
			System.out.println("¡Guau guau!");
		} else if (especie.equalsIgnoreCase("gato")) {
			System.out.println("¡Miau miau!");
		} else {
			System.out.println("La mascota no hace sonidos conocidos.");
		}
	}

	public void dormir() {
		System.out.println("Buenas nocheeess!!!");
		JOptionPane.showMessageDialog(null, "La mascota esta durmiendo");
	}

	public void despertar() {
		System.out.println("Buenos diassss!!!");
		JOptionPane.showMessageDialog(null, "La mascota ha despertado");
	}
}