/**
 * 
 */
package base;

/**
 * @author Christian y Miquel
 * Clase Enemy
 *  Cada vez que se enfrente a un enemigo, se generará una instancia de enemigo que se hará dependiendo de momento de la partida que te encuentres
 */
public class Enemy {
	private String nombre;
	private int ataque;
	private int defensa;
	private int velocidad;
	private String genero;
	private String raza;
	
	/**
	 * Constructor vacío clase Enemy
	 * 
	 */
	public Enemy() {
		//Constructor vacío
	}
	/**
	 * Constructor Clase Enemy
	 * Se le pasa el estado de la partida y se genera el enemigo en base al momento de la partida en el que estemos
	 * 
	 */
	public Enemy(int partida) {
		generateRandom(partida);
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the ataque
	 */
	public int getAtaque() {
		return ataque;
	}
	/**
	 * @param ataque the ataque to set
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	/**
	 * @return the defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/**
	 * @param defensa the defensa to set
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	/**
	 * @return the velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * @param velocidad the velocidad to set
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * @return the raza
	 */
	public String getRaza() {
		return raza;
	}
	/**
	 * @param raza the raza to set
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	/**
	 * generateRandom(int)
	 * 	Genera unos stats de enemigo basándose en el momento de la partida en el que nos encontremos
	 * @param int partida
	 */
	public void generateRandom(int partida) {
		// TO DO
	}
}
