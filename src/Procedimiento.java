import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procedimiento {
	HashMap<Integer, Mascota> mascotas;
	Mascota mascotica;
	String[] options = { "NOMBRE", "EDAD", "ESPECIE" };
	String name;

	public Procedimiento() {
		String Starting;
		do {
			Starting = JOptionPane
					.showInputDialog("Bienvenido a el registro de mascotas\n desea usar  la aplicacion? (Si/No)");
		} while (Starting == null || Starting.equals(""));
		if (Starting.equalsIgnoreCase("si")) {
			mascotas = new HashMap<Integer, Mascota>();
			start();
		} else {
			JOptionPane.showMessageDialog(null, "Tenga un buen dia");
		}
	}

	private void start() {
		int opc = 0;
		String menu = "-----Bienvenido, que desea hacer-----\n1. Registrar una nueva mascota\n2. Ver lista de mascotas registradas\n3. Consultar Mascota\n4. Modificar mascotas\n5. Salir";
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
				opc = 0;
			}
			elegirOpcion(opc);
		} while (opc != 5);
	}

	private void registrarMascota() {
		do {

			try {

				mascotica = new Mascota(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"),
						JOptionPane.showInputDialog("Ingrese la Raza de la mascota"),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota")),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificacion de la mascota")));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ingresaste un dato invalido por favor repite el proceso");
				mascotica = null;
			}
		} while (mascotica == null);

		if (mascotas.containsKey(mascotica.id)) {
			JOptionPane.showMessageDialog(null, "LA MASCOTA NO FUE REGISTRADA, SU IDENTIFICACION YA EXISTE");
			;
		} else {
			mascotas.put(mascotica.id, mascotica);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		}

	}

	public void elegirOpcion(int a) {
		switch (a) {
		case 1:
			registrarMascota();
			break;
		case 2:
			if (mascotas.size() > 0) {
				showList();
			} else {
				JOptionPane.showMessageDialog(null, "Aun no hay ninguna mascota registrada");
			}
			break;
		case 3:
			if (mascotas.size() > 0) {
				searchByName();
			} else {
				JOptionPane.showMessageDialog(null, "Aun no hay ninguna mascota registrada");
			}
			break;
		case 4:
			if (mascotas.size() > 0) {
				modify();
			} else {
				JOptionPane.showMessageDialog(null, "Aun no hay ninguna mascota registrada");
			}
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Hasta la proxima");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");

		}
	}

	public void showList() {
		for (Mascota mascota : mascotas.values()) {
			System.out.println("--------" + mascota.nombre + "--------");
			System.out.println("Identificacion: " + mascota.id);
			System.out.println("edad: " + mascota.edad);
			System.out.println("Especie: " + mascota.especie);
			System.out.println();
		}
	}

	boolean isNot = true;

	public void searchByName() {
		name = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a buscar");
		for (Mascota mascota : mascotas.values()) {
			if (mascota.nombre.equalsIgnoreCase(name)) {
				System.out.println("--------" + mascota.nombre + "--------");
				System.out.println("Identificacion: " + mascota.id);
				System.out.println("edad: " + mascota.edad);
				System.out.println("Especie: " + mascota.especie);
				System.out.println();
				isNot = false;
			}
		}
		if (isNot) {
			JOptionPane.showMessageDialog(null, "No habian mascotas con ese nombre");
		}
	}

	public void modify() {
		try {

			changing(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la mascota que desea modificar")),
					JOptionPane.showOptionDialog(null, "que desea modificar?", "Elige una", 0,
							JOptionPane.QUESTION_MESSAGE, null, options, mascotas));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresaste algo invalido, no se pudo completar la accion!!!");
		}

	}

	public void changing(int id, int opc) {
		switch (opc) {
		case 0:
			mascotas.get(id).nombre = JOptionPane
					.showInputDialog("Ingrese el nombre que tendra ahora " + mascotas.get(id).nombre);
			break;
		case 1:
			try {
				mascotas.get(id).edad = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese la edad que tendra ahora " + mascotas.get(id).nombre));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ingresaste algo invalido, no se pudo completar la accion!!!");
			}
			break;
		case 2:
			mascotas.get(id).especie = JOptionPane
					.showInputDialog("Ingrese la especia que tendra ahora " + mascotas.get(id).nombre);
			break;
		}
	}

}
