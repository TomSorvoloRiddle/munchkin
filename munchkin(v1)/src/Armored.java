public class Armored extends Item{
	// Atributos de la clase Armored
	private int defensa;
	
	// Constructor vacío
	public Armored() {
		
	}
	//Constructores
	public Armored(String name, int dfs) {
		super.setNombre(name);
		super.setPeso(1);
		this.defensa = dfs;
	}
	//Constructor que le pasamos un número y nos crea una armadura
	public Armored(int n) {
		switch(n) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			break;
		case 18:
			break;
		case 19:
			break;
		default:
			break;
		}
	}
	/** Getter defensa
	 * @return int defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	/** Setter defensa
	 * @param int defensa
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
}
