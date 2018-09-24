/**
 * 
 */

import java.util.Scanner;
import java.io.*;
import java.util.Random;

/**
 * @author Christian y Miquel
 *
 */
public class Main {
	//Constantes que no var�an durante la partida
	public static final int DifPifia = 40; // Posibilidades de que cada turno te salga una pifia...
	
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Bienvenido a Munchkin, aventura escrita");			
		System.out.println("�C�mo quieres que se llame tu personaje?");
		
		//Creamos String name para almacenar el nombre del personaje y se lo asignamos al Player
		String name;
		Scanner userIn = new Scanner(System.in);
		BufferedReader userInput = new BufferedReader(new InputStreamReader (System.in));
		name = userInput.readLine(); // Leemos variable String
		Player personaje = new Player(name); // Creamos personaje
		//personaje.setName(name); // Le asignamos el nombre
		
		// Variables para controlar el flujo del programa
		boolean atack = true; // Controlar si entramos en el bucle para asignar puntos de ataque
		boolean defense = true; // Controlar si entramos en el bucle de asignar puntos de defensa
		boolean speed = true;
		
		int atkIn= 0;
		int dfsIn = 0;
		int spdIn = 0;
		
		System.out.println("Genial, ahora tienes que repartirle los puntos de habilidad para que "+ name + " se haga muy fuerte...");
		while(atack) {
			System.out.println("Reparte 10 puntos entre ataque, defensa y velocidad. Elige sabiamente...");
			System.out.println("�Cuantos puntos de ataque quieres tener?");
			atkIn = userIn.nextInt();
			if(isMoreThanTen(atkIn)) {
				System.out.println("No puedes asignar m�s de 10 puntos de habilidad");
			}else {
				personaje.setAtaque(atkIn);
				if(atkIn == 10){
					defense = false;
					speed = false;
				}
				//System.out.println(defense);
				atack = false;
			}
		}
		while(defense) {
			System.out.println("�Cuantos puntos de defensa quieres tener?");
			dfsIn = userIn.nextInt();
			if(isMoreThanTen(dfsIn+personaje.getAtaque())) {
				System.out.println("No puedes asignar m�s de 10 puntos de habilidad");
			}else {
				personaje.setDefensa(dfsIn);
				//System.out.println(defense);
				//if(atkIn + dfsIn == 10) { --> C�d. Christian 
				if(personaje.getAtaque() + personaje.getDefensa() == 10) {
					speed = false;
				}
				defense = false;
			}
		}
		while(speed) {
			System.out.println("�Cuantos puntos de velocidad quieres tener?");
			spdIn = userIn.nextInt();
			if(isMoreThanTen(spdIn+personaje.getAtaque()+personaje.getDefensa())) {
				 System.out.println("No puedes asignar mas de 10 puntos de habilidad");
			}else {
				personaje.setVelocidad(spdIn);
				speed = false;
			}
		}
		personaje.describe();
		
		//  Empezar partida
		// Variables de control de flujo
		int estado = 1; // Estado marcar� en qu� parte de la partida te encuentras... Cuando llegues a 20, te enfrentar�s al monstruo final
		int turn = 1; // Variable que nos indicar� cuantos turnos hemos jugado
		// Mientras la variable estado sea menor de 100 iremos haciendo turnos de partida
		while(estado < 25) {
			//Reseteamos los valores de pifia y suerte cada turno
			int numberPL = 0;
			boolean pifia = false; // Tirada de pifia al principio del turno... Si sale 1 es pifia.
			boolean lucky = false; // Tirada de suerte al principio del turno... Si sale difPifia el jugador tendr� suerte.
			int numberAction = 0; // N�mero que nos dir� si nos enfrentamos a un enemigo o nos encontramos un item
			// Todo turno empieza con una tirada de pifia...
			numberPL = randomNumber(DifPifia);
			if(isPifia(numberPL)) {
				System.out.println("Te ha tocado una pifia");
				pifia = true;
			}
			//Tirada para ver si tenemos suerte en el turno...
			if(numberPL == DifPifia) {
				System.out.println("Vas a tener suerte este turno");
				// TO DO realizar sucesos por tener suerte, encontrarse alg�n tesoro (objeto, armadura, poci�n,...)
				lucky = true;
			
			}
			System.out.flush();
			System.out.println("Empezamos el turno");
			// TO DO
			// Tirada aleatoria para saber si nos encontramos un item o luchamos contra un enemigo
			numberAction = randomNumber(10); // Si el n�mero es mayor o igual a 8, nos encontraremos un objeto
			if(numberAction >= 8) {
				// Nos encontramos un item
				System.out.println("Mientras andabas en busca de aventuras, te has encontrado con un objeto");
				if (lucky) {
					// La suerte hace que se encuentre con un objeto legendario
					Weapon armaLegend = new Weapon(randomNumber(27));
					System.out.println("Has tenido mucha suerte y te has encontrado con un arma legendaria!");
					// Transformamos arma aleatoria en legendaria
					armaLegend.toLegend();
					armaLegend.describe();
				} else {
					// Aleatoriamente tocar� un objeto (3), una armadura(2) o un arma(1)
					switch(randomNumber(3)) {
						case 1:
							Weapon arma = new Weapon(randomNumber(27)); // Tocar� una weapon aleatoria dentro de las 27 definidas
							arma.describe();
							break;
						case 2:
							//TO DO
							// Creaci�n de armadura
							break;
						default:
							//TO DO
							//Creaci�n de objeto
							break;
					}
				}
			} else {
				// Nos enfrentamos a un enemigo
				System.out.println("Las aventuras llevan a encontrarte con un enemigo...");
				Enemy enemigo = new Enemy(estado, pifia);
				enemigo.describe();
				//COMBATE
				// TO DO
				fight(personaje, enemigo);
				// Despu�s de una pelea, el jugador podr� repartirse los puntos de habilidad pertinentes
				estado += 1;
			}
			turn += 1;
			userIn.nextLine();
			// Al final de cada turno...
		}
	}
	
	/**
	 *  M�todo isMoreThanTen(int);
	 *  M�todo que que devuelve verdadero si el n�mero pasado es mayor de 10 y falso si no lo es...
	 *  @param int
	 *  @return boolean
	 */
	static boolean isMoreThanTen(int number) {
		if( number > 10 ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 *  M�todo randomNumber(int);
	 *  M�todo que genera un n�mero aleatorio dependiendo del n�mero que le pases
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
	 * M�todo isPifia(int);
	 * Devuelve true si el n�mero aleatorio es un 1
	 * @param number Le pasamos el n�mero aleatorio que ha salido
	 * @return boolean
	 */
	static boolean isPifia(int number) {
		if(number == 1) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * M�todo fight que simula la pelea. Se le pasan los dos par�metros principales, el personaje y el enemigo al que se enfrenta
	 * @param Player p
	 * @param Enemy e
	 */
	static boolean fight(Player p, Enemy e) {
		boolean combatResult = true;
		while(p.getDefensa() > 0 || e.getDefensa() > 0) { // El combate seguir� hasta que una de las dos defensas llegue a 0
			System.out.println("Comparando las velocidades de los combatientes...");
			System.out.println(p.getName() + ": " + p.getVelocidad());
			System.out.println(e.getNombre() + ": " + e.getVelocidad());
			if(p.getVelocidad() > e.getVelocidad()) { // El personaje es m�s r�pido que el enemigo, empieza atacando
				e.setDefensa((byte) (p.getAtaque() - e.getDefensa()));
				if(p.getVelocidad()/e.getVelocidad() >= 2 && e.getDefensa() > 0) { // El personaje es el doble de r�pido que el enemigo  y adem�s le queda defensa del ataque anterior, por eso, atacar� dos veces antes que el enemigo
					System.out.println("El jugador hace uso de su velocidad desmesurada en comparaci�n a su enemigo y le azota con dos golpes");
					e.setDefensa((byte) (p.getAtaque() - e.getDefensa()));
					if(e.getDefensa() <= 0) {
						System.out.println("El enemigo ha perdido el conocimiento, " + p.getName() + " gana el combate _2");
						break;
					}
				}
			} else {
				System.out.println("El enemigo es m�s r�pido que " + p.getName());
			}
		}
		return combatResult;
	}
}
