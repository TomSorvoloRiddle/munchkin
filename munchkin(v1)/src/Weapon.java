
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
			super.setNombre("Tabla de multiplicar heridas");
			super.setPeso(1);
			super.setDescripcion("Tabla con un clavo");
			this.ataque = 2;
			break;
		case 6:
			super.setNombre("Estoque de la injusta ventaja");
			super.setPeso(1);
			super.setDescripcion("Estoque muy largo");
			this.ataque = 2;
			break;
		case 7:
			super.setNombre("Espada danzante y cantante");
			super.setPeso(0);
			super.setDescripcion("Espada que no ocupa lugar que baila y canta");
			this.ataque = 2;
			break;
		case 8:
			super.setNombre("Espada Bastarda y traicionera");
			super.setPeso(1);
			super.setDescripcion("Espada afilada y con malas ideas");
			this.ataque = 2;
			break;
		case 9:
			super.setNombre("Tenedor de barbacoa");
			super.setPeso(1);
			super.setDescripcion("Tenedor muy largo");
			this.ataque = 2;
			break;
		case 10:
			super.setNombre("Maza Afilada");
			super.setPeso(1);
			super.setDescripcion("Maza con los pinchos afilados");
			this.ataque = 2;
			break;
		case 11:
			super.setNombre("Daga Traicionera");
			super.setPeso(1);
			super.setDescripcion("Daga cortita muy afilada");
			this.ataque = 3;
			break;
		case 12:
			super.setNombre("Pinzas del terror");
			super.setPeso(1);
			super.setDescripcion("Pinzas que quitan dientes");
			this.ataque = 3;
			break;
		case 13:
			super.setNombre("Maza Lacrimógena");
			super.setPeso(1);
			super.setDescripcion("Maza que te hace llorar");
			this.ataque = 3;
			break;
		case 14:
			super.setNombre("Motosierra de mutilación sangrienta");
			super.setPeso(1);
			super.setDescripcion("Motosierra muy peligrosa");
			this.ataque = 3;
			break;
		case 15:
			super.setNombre("Arco con lacitos");
			super.setPeso(1);
			super.setDescripcion("Arco peligroso");
			this.ataque = 3;
			break;
		case 16:
			super.setNombre("Leotardos de fuerza de gigante");
			super.setPeso(1);
			super.setDescripcion("Leotardos que dan fuerza");
			this.ataque = 3;
			break;
		case 17:
			super.setNombre("Gran Clava de Plutonio");
			super.setPeso(1);
			super.setDescripcion("Palo de plutonio muy peligroso");
			this.ataque = 3;
			break;
		case 18:
			super.setNombre("Arco Hipertenso");
			super.setPeso(1);
			super.setDescripcion("Arco capaz de disparar flechas a mucha velocidad");
			this.ataque = 4;
			break;
		case 19:
			super.setNombre("Martillo Destroza-rodillas");
			super.setPeso(1);
			super.setDescripcion("Martillo para bajitos");
			this.ataque = 4;
			break;
		case 20:
			super.setNombre("Alabarda Suiza Multiusos");
			super.setPeso(1);
			super.setDescripcion("Herramienta multiuso peligrosa");
			this.ataque = 4;
			break;
		case 21:
			super.setNombre("Roca Enorme");
			super.setPeso(1);
			super.setDescripcion("Roca capaz de chafar personas");
			this.ataque = 4;
			break;
		case 22:
			super.setNombre("Apisonadora Enana");
			super.setPeso(1);
			super.setDescripcion("Aplasta, pisa, destroza");
			this.ataque = 4;
			break;
		case 23:
			super.setNombre("Ingenio de Asedio");
			super.setPeso(1);
			super.setDescripcion("Máquina de asedio con rocas");
			this.ataque = 4;
			break;
		case 24:
			super.setNombre("Hoz Guadaña");
			super.setPeso(1);
			super.setDescripcion("Arma de muerte");
			this.ataque = 5;
			break;
		case 25:
			super.setNombre("Hoz Guadaña");
			super.setPeso(1);
			super.setDescripcion("Arma de muerte");
			this.ataque = 5;
			break;
		case 26:
			super.setNombre("Hacha Descomunal");
			super.setPeso(1);
			super.setDescripcion("Hacha excepcionalmente grande");
			this.ataque = 5;
			break;
		case 27:
			super.setNombre("Título Realmente Impresionante");
			super.setPeso(1);
			super.setDescripcion("Señor Impresionante");
			this.ataque = 5;
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
	/**
	 * Método que transforma un arma en legendaria
	 * Simplemente le añadimos al nombre legendaria y le sumamos +5 al ataque
	 */
	public void toLegend() {
		this.setNombre(this.getNombre() + " Legendaria");
		this.setAtaque(this.getAtaque() + 5);
	}
}
