import java.util.Random;

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
	private String descripcionFisica;
	private int objetos;
	private int pHabilidad;
	
	
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
	 * Constructor muy abstracto ya que de aquí depende la partida
	 */
	public Enemy(int partida, boolean badLuck) {
		int result = 13;
		if(badLuck) { //Si el jugador ha tenido mala suerte, se tendrá que enfrentar a un enemigo mucho más fuerte que él
			// TO DO
		}else { // Si no ha tenido mala suerte, se genera un enemigo normal para su nivel
			if(partida >= 3 && partida <= 5) { // Si la partida va por debajo del turno 5
				
			} else if( partida < 10) { // Si la partida va por debajo del turno 10
				
			} else if( partida < 15) { // Si la partida va por debajo del turno 15
				
			} else if( partida < 19) { // Si la partida va por debajo del turno 19
				
			} else { // Turno final
				
			}
		}
		
		switch(randomNumber(result)) {
			case 1:
				this.setNombre("Rata muy enfadada");
				this.setAtaque(2);
				this.setDefensa((byte) 1);
				this.setVelocidad(2);
				this.setGenero("Femenino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Rata que ha aprendido a sostenerse con sus dos piernas traseras y va de pie. Con sus patas delanteras lleva una maza");
				this.setObjetos(1);
				this.setPHabilidad(2);
				break;
			case 2:
				this.setNombre("Ladillas");
				this.setAtaque(1);
				this.setDefensa((byte) 2);
				this.setVelocidad(3);
				this.setGenero("Femenino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Ladillas furiosas que se meten... que provocan muchos picores!");
				this.setObjetos(1);
				this.setPHabilidad(2);
				break;
			case 3:
				this.setNombre("Araña diminutita");
				this.setAtaque(2);
				this.setDefensa((byte) 1);
				this.setVelocidad(2);
				this.setGenero("Femenino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Araña diminuta capaz de pasar inadvertida y causar estragos");
				this.setObjetos(1);
				this.setPHabilidad(2);
				break;
			case 4:
				this.setNombre("Babosa babeante");
				this.setAtaque(3);
				this.setDefensa((byte) 2);
				this.setVelocidad(1);
				this.setGenero("Femenino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Babosa asquerosa pegajosa");
				this.setObjetos(1);
				this.setPHabilidad(2);
				break;
			case 5:
				this.setNombre("Planta en un tiesto");
				this.setAtaque(1);
				this.setDefensa((byte) 1);
				this.setVelocidad(0);
				this.setGenero("Femenino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Planta enredadera capaz de ... nada");
				this.setObjetos(1);
				this.setPHabilidad(1);
				break;
			case 6:
				this.setNombre("Huevo gigante");
				this.setAtaque(1);
				this.setDefensa((byte) 4);
				this.setVelocidad(0);
				this.setGenero("Masculino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Huevo gigante, ¿cómo romperlo?");
				this.setObjetos(1);
				this.setPHabilidad(1);
				break;
			case 7:
				this.setNombre("Goblin cojo");
				this.setAtaque(3);
				this.setDefensa((byte) 2);
				this.setVelocidad(1);
				this.setGenero("Masculino");
				this.setRaza("Goblin");
				this.setDescripcionFisica("Goblin verde que va con muletas debido a un accidente");
				this.setObjetos(1);
				this.setPHabilidad(2);
				break;
			case 8:
				this.setNombre("Abejas enfermas");
				this.setAtaque(2);
				this.setDefensa((byte) 2);
				this.setVelocidad(4);
				this.setGenero("Femenino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Abejas rociadas con insecticida que están medio muertas");
				this.setObjetos(1);
				this.setPHabilidad(2);
				break;
			case 9:
				this.setNombre("Ranas voladoras");
				this.setAtaque(3);
				this.setDefensa((byte) 2);
				this.setVelocidad(3);
				this.setGenero("Femenino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Ranas con alas y dientes, cuidado!");
				this.setObjetos(1);
				this.setPHabilidad(2);
				break;
			case 10:
				this.setNombre("Huesitos");
				this.setAtaque(4);
				this.setDefensa((byte) 3);
				this.setVelocidad(2);
				this.setGenero("Masculino");
				this.setRaza("Criatura");
				this.setDescripcionFisica("De pequeño lo estudiábamos en el colegio, ahora está enfadado y va con un bastón y un sombrero de copa");
				this.setObjetos(1);
				this.setPHabilidad(3);
				break;
			case 11:
				this.setNombre("Pitbull");
				this.setAtaque(5);
				this.setDefensa((byte) 2);
				this.setVelocidad(3);
				this.setGenero("Masculino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Perro o cantante? Perro peligroso capaz de darte un buen mordisco");
				this.setObjetos(1);
				this.setPHabilidad(3);
				break;
			case 12:
				this.setNombre("Reloj despertador");
				this.setAtaque(3);
				this.setDefensa((byte) 5);
				this.setVelocidad(1);
				this.setGenero("Masculino");
				this.setRaza("Criatura");
				this.setDescripcionFisica("Reloj de los antiguos que no se apaga ni a la de tres");
				this.setObjetos(1);
				this.setPHabilidad(3);
				break;
			case 13:
				this.setNombre("Pollo dopado con esteroides");
				this.setAtaque(4);
				this.setDefensa((byte) 3);
				this.setVelocidad(3);
				this.setGenero("Masculino");
				this.setRaza("Animal");
				this.setDescripcionFisica("Pollo rabioso con más fuerza de lo normal");
				this.setObjetos(1);
				this.setPHabilidad(3);
				break;
			default:
				System.out.println("Ha tocado un número de enemigo no controlado");
				break;
		}
	}
	// Getters y Setters
	/**
	 * Getter de nombre
	 * @return String nombre;
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setter del nombre
	 * @param String nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter de ataque
	 * @return int ataque
	 */
	public int getAtaque() {
		return ataque;
	}
	/**
	 * Setter ataque
	 * @param int ataque
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	/**
	 * Getter defensa
	 * @return int defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/**
	 * Setter defensa
	 * @param byte defensa
	 */
	public void setDefensa(int i) {
		this.defensa = i;
	}
	
	/**
	 * Getter velocidad
	 * @return int velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * Setter de velocidad
	 * @param int velocidad
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	 * Getter de género (Masculino/Femenino) v.2
	 * @return String genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * Setter género (Masculino/Femenino) v.2
	 * @param String genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Getter de raza v.2
	 * @return String raza
	 */
	public String getRaza() {
		return raza;
	}
	/**
	 * Setter de raza v.2
	 * @param String raza
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	/**
	 * Getter de descripciónFísica
	 * @return String descripcion
	 */
	public String getDescripcionFisica() {
		return descripcionFisica;
	}
	/**
	 * Setter Descripción Física
	 * @param String descripcion
	 */
	public void setDescripcionFisica(String descripcionFisica) {
		this.descripcionFisica = descripcionFisica;
	}
	
	/**
	 * Getter objectos (Cuantos objetos entrega ganarle al monstruo)
	 * @return int objetos
	 */
	public int getObjetos() {
		return objetos;
	}
	/**
	 * Setter objetos
	 * @param int objectos
	 */
	public void setObjetos(int objectos) {
		this.objetos = objectos;
	}
	
	/**
	 * Getter puntos habilidad
	 * @return int puntos
	 */
	public int getPHabilidad() {
		return pHabilidad;
	}
	/**
	 * Setter de puntos de habilidad
	 * @param int puntos
	 */
	public void setPHabilidad(int pHabilidad) {
		this.pHabilidad = pHabilidad;
	}
	
	// Métodos de la clase Enemy
	/**
	 *  Método randomNumber(int);
	 *  Método que genera un número aleatorio dependiendo del número que le pases
	 *  @return int aleatorio
	 */
	static int randomNumber(int dice) {
		int number;
		Random rnd = new Random();
		number = rnd.nextInt()%dice;
		number = Math.abs(number);
		if(number == 0) {
			number = dice;
		}
		return number;
	}
	/**
	 * Método que describe por pantalla al enemigo
	 */
	public void describe() {
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Atributos");
		System.out.println("Ataque: " + this.getAtaque());
		System.out.println("Defensa: " + this.getDefensa());
		System.out.println("Velocidad: " + this.getVelocidad());
		System.out.println(this.getDescripcionFisica());
		System.out.println("Recompensas");
		System.out.println("Objetos: " + this.getObjetos());
		System.out.println("Puntos de habilidad: " + this.getPHabilidad());	
	}
}
