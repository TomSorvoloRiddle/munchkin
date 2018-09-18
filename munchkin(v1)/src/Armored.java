package base;

public class Armored extends Item{
	// Atributos de la clase Armored
	private int defensa;
	
	// Constructor vacío
	public Armored() {
		
	}
	
	//Constructores
	public Armored(String name, int dfs) {
		super.setNombre(name);
		this.defensa = dfs;
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
