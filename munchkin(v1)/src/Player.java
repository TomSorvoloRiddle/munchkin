/**
 * 
 */


/**
 * @author Christian y Miquel
 * Clase Player que almacena los datos de un jugador.
 */
public class Player {
// Atributos
	private String name;
	private int carga; // Peso por objetos equipados
	private int nivel; // Cada batalla ganada proporciona +1 (puede ser cómo un récord conseguir un personaje de mucho nivel)
	private int ataque;
	private int defensa;
	private int velocidad;
	private int vida; // Los jugadores tendrán 2 vidas, cuando pierdan contra un enemigo, perderán una vida
	private String genero; // Se trabajará más adelante
	private String raza; // Se trabajará más adelante
	private String clase; // Se trabajará más adelante
	private Weapon armaPuesta[];
	
	public Player() {
		
	}
	
	public Player(String name) {
		this.name = name;
		this.nivel = 1;
		this.vida = 2;
	}
	
	public Player(String name, int carga, int nivel, int ataque, int defensa, int velocidad) {
		super();
		this.name = name;
		this.carga = carga;
		this.nivel = nivel;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.vida = 2;
	}
	
	/** Getter atributo nombre
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	/** Setter para fijar nombre
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Getter atributo carga
	 * @return int carga
	 */
	public int getCarga() {
		return carga;
	}
	/** Setter atributo carga
	 * @param int carga
	 */
	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	/** Getter Atributo nivel
	 * @return int nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/** Setter atributo nivel
	 * @param int nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	/** Getter atributo ataque
	 * @return int ataque
	 */
	public int getAtaque() {
		return ataque;
	}
	/** Setter atributo ataque
	 * @param int ataque
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	/** Getter atributo defensa
	 * @return int defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/** Setter atributo defensa
	 * @param int defensa
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	/** Getter atributo velocidad
	 * @return int velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/** Setter atributo velocidad
	 * @param int velocidad
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/** Getter atributo vida
	 * @return int vida
	 */
	public int getVida() {
		return vida;
	}
	/** Setter atributo vida
	 * @param int vida 
	 */
	public void setVida(int live) {
		this.vida = live;
	}
	
	/** Getter atributo género
	 * @return String genero
	 */
	public String getGenero() {
		return genero;
	}
	/** Setter atributo género
	 * @param String género
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/** Getter atributo raza
	 * @return String raza
	 */
	public String getRaza() {
		return raza;
	}
	/** Setter atributo raza
	 * @param String raza
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	/** Getter atributo clase
	 * @return String clase
	 */
	public String getClase() {
		return clase;
	}
	/** Setter atributo clase
	 * @param String clase
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	// Métodos de la clase Player...
	/**
	 * Método describe();
	 * Método para especificar las habilidades del personaje
	 * @param None
	 * @return None
	 */
	public void describe() {
		System.out.println("El personaje tiene las siguientes características:");
		System.out.println("Nombre: "+ this.name);
		System.out.println("Ataque: "+ this.ataque);
		System.out.println("Defensa: "+ this.defensa);
		System.out.println("Velocidad: "+ this.velocidad);
		System.out.println("Vidas: "+ this.vida);
	}
}
