
public class Weapon extends Item {
	// Atribtuos de la clase Weapon
	private int ataque;
	
	// Constructores
	// Constructor vacío
	public Weapon() {
		
	}
	// Constructor a medida indicando todos los atributos
	public Weapon(String name, int peso, String descripcion, int atk) {
		super.setNombre(name);
		super.setPeso(peso);
		super.setDescripcion(descripcion);
		this.ataque = atk;
	}
	// Constructor por número
	public Weapon(int numero) {
		// Se le pasará un número desde el programa (aleatorio) y será el objeto que toque en este switch
		switch(numero) {
		case 1:
			super.setNombre("Lanza Desmesurada");
			super.setPeso(1);
			super.setDescripcion("Es una lanza muy larga, dificil de manejar");
			this.ataque = 1;
			break;
		case 2:
			super.setNombre("Dentadura Postiza Aterradora");
			super.setPeso(1);
			super.setDescripcion("Dentadura con unos dientes un tanto especiales");
			this.ataque = 1;			
			break;
		case 3:
			super.setNombre("Capa de Sombras");
			super.setPeso(1);
			super.setDescripcion("Capa que te da fuerza");
			this.ataque = 1;
			break;
		case 4:
			super.setNombre("Pañuelo para tipos duros");
			super.setPeso(1);
			super.setDescripcion("Pañuelo que te hace sentir más fuerte");
			this.ataque = 1;
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
		case 20:
			break;
		case 21:
			break;
		case 22:
			break;
		case 23:
			break;
		case 24:
			break;
		case 25:
			break;
		case 26:
			break;
		case 27:
			break;
		default:
			super.setNombre("Puño americano");
			super.setPeso(1);
			super.setDescripcion("Protección de hierro para los nudillos para pegar más fuerte");
			this.ataque = 1;
			break;
		}
	}
	
	//Getters y Setters de la clase Weapon
	/** Getter ataque
	 * @return int ataque
	 */
	public int getAtaque() {
		return ataque;
	}
	/** Setter ataque
	 * @param int ataque
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	//Métodos propios de la clase
	/**
	 * Método para explicar el arma
	 * Simplemente muestra por pantalla los diferentes atributos de la misma.
	 */
	public void describe() {
		System.out.println("Te ha tocado el arma: "+ this.getNombre());
		System.out.println("Peso: "+ this.getPeso());
		System.out.println("Ataque: "+ this.getAtaque());
		System.out.println("Descripción: "+ this.getDescripcion());
	}
}
