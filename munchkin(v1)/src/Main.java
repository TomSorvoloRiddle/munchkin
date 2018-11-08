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
		boolean speed = true; // Controlar si entramos en el bucle de asignar puntos de velocidad
		
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
				boolean playerWin = false;
				Enemy enemigo = new Enemy(estado, pifia);
				enemigo.describe();
				//COMBATE
				// TO DO
				playerWin = goToFight(personaje, enemigo);
				personaje.setDefensa(dfsIn);
				// Despu�s de una pelea, el jugador podr� repartirse los puntos de habilidad pertinentes
				if(playerWin) {
					// Si el jugador ha ganado la pelea, se tiene que repartir los puntos de habilidad
					// TO DO
					System.out.println(personaje.getName() + " ha ganado la batalla, ahora puedes repartirte la experiencia adquirida: " + enemigo.getPHabilidad() + " puntos de habilidad");
					addExperience( personaje, enemigo.getPHabilidad() );
					estado += 1;
				} else {
					// El jugador ha perdido la batalla y por lo tanto se le resta una vida, si ha perdido las 2 vidas, pierde la partida
					// TO DO
					System.out.println(personaje.getName() + " ha perdido la batalla");
				}
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
	static boolean goToFight(Player p, Enemy e) {
		// Creamos una variable pelea donde encontraremos los m�todos necesarios para realizar las comprobaciones de la pelea. Esta clase nos servir� para limpiar el Main();
		Fight pelea = new Fight(p,e);
		
		boolean combatResult = true;
		while(p.getDefensa() > 0 || e.getDefensa() > 0) { // El combate seguir� hasta que una de las dos defensas llegue a 0
			System.out.println("Comparando las velocidades de los combatientes...");
			System.out.println(p.getName() + ": " + p.getVelocidad());
			System.out.println(e.getNombre() + ": " + e.getVelocidad());
			
			if( pelea.playerIsFaster() ) { // El personaje es m�s r�pido que el enemigo, empieza atacando
				// El personaje ataca
				//e.setDefensa((byte) (p.getAtaque() - e.getDefensa())); 
				pelea.playerAtack();
				// Comprobamos si el enemigo est� muerto
				if( pelea.enemyIsKo() ) {
					System.out.println("El enemigo ha perdido el conocimiento, " + p.getName() + " gana el combate");
					break;
				} else {
					if( pelea.playerIsDoubleFaster() ) { // El personaje es el doble de r�pido que el enemigo y atacar� dos veces antes que el enemigo
						System.out.println("El jugador hace uso de su velocidad desmesurada en comparaci�n a su enemigo y le azota con dos golpes");
						// El personaje vuelve a atacar
						pelea.playerAtack();
						// Volvemos a comprobar si el enemigo est� muerto
						if( pelea.enemyIsKo() ) {
							System.out.println("El enemigo ha perdido el conocimiento, " + p.getName() + " gana el combate _2");
							break;
						}
					}
				}
				// Turno del enemigo despu�s que el jugador haya atacado
				pelea.enemyAtack();
				// Comprobamos si el jugador a muerto
				if( pelea.playerIsKo() ) {
					p.setVida( p.getVida() - 1 );
					// El jugador ha perdido, le quedan vidas?
					if( pelea.playerIsDead() ) {
						// El jugador est� muerto... Si le queda m�s de 0 est� vivo
						System.out.println("Has perdido la partida. Esta vez, los enemigos han sido m�s fuertes que tu");
					} else {
						// El jugador a perdido la pelea, pero no est� muerto
						System.out.println("Has perdido una de tus vidas, ves con m�s cuidado la pr�xima vez");
					}
				} else {
					// Despu�s del ataque del enemigo, el jugador sigue vivo
					System.out.println("Resumen: " + p.getName() + " ha atacado primero dejando a " + e.getNombre() + " con " + e.getDefensa() + " de vida");
					System.out.println("Despu�s, " + e.getNombre() + " ha contraatacado dejando a " + p.getName() + " con " + p.getDefensa() + " de vida");
				}

			} else {
				System.out.println("El enemigo es m�s r�pido que " + p.getName() + ". Por lo tanto, ataca primero" );
				pelea.enemyAtack();
				if( pelea.playerIsKo() ) {
					combatResult = false;
					System.out.println("El ataque de "+ e.getNombre() + " ha dejado KO a " + p.getName() );
					p.setVida( p.getVida() - 1 );
					if( pelea.playerIsDead() ) {
						// El jugador ha perdido y est� muerto
						System.out.println("Has perdido la partida. Esta vez, los enemigos han sido m�s fuertes que tu");
						break;
					} else {
						// El jugador ha perdido la batalla pero no est� muerto
						System.out.println("Has perdido una de tus vidas, ves con m�s cuidado la pr�xima vez");
						break;
					}
				} else if( pelea.enemyIsDoubleFaster() ) {
					System.out.println("El enemigo ha hecho uso de su velocidad para atacad 2 veces seguidas...");
					pelea.enemyAtack();
					if( pelea.playerIsKo() ) {
						combatResult = false;
						System.out.println("El ataque de "+ e.getNombre() + " ha dejado KO a " + p.getName() );
						p.setVida( p.getVida() - 1 );
						if( pelea.playerIsDead() ) {
							// El jugador ha perdido y est� muerto
							System.out.println("Has perdido la partida. Esta vez, los enemigos han sido m�s fuertes que tu");
							break;
						} else {
							// El jugador ha perdido la batalla pero no est� muerto
							System.out.println("Has perdido una de tus vidas, ves con m�s cuidado la pr�xima vez");
							break;
						}
					} else {
						pelea.playerAtack();
						if( pelea.enemyIsKo() ) {
							System.out.println("El enemigo ha perdido el conocimiento, " + p.getName() + " gana el combate");
							break;
						} else {
							// Despu�s del ataque del enemigo, el jugador sigue vivo
							System.out.println("Resumen: " + p.getName() + " ha atacado primero dejando a " + e.getNombre() + " con " + e.getDefensa() + " de vida");
							System.out.println("Despu�s, " + e.getNombre() + " ha contraatacado dejando a " + p.getName() + " con " + p.getDefensa() + " de vida");
						}
					}
				}
			}
		}
		return combatResult;
	}
	/* M�todo que le pasamos el jugador y la experiencia para repartirse y se le a�ade seg�n quiera el jugador.
	 * @param Player, int
	 * 
	 */
	static void addExperience(Player jugador, int experiencia) throws IOException {
		while(experiencia > 0){
			System.out.println("Quieres repartir todos los puntos a un solo aspecto? Indicar con si o no. (Ataque, Defensa, Velocidad)");
			String respuesta1;
			String respuesta2;
			String respuesta3;
			BufferedReader userInput = new BufferedReader(new InputStreamReader (System.in));
			respuesta1 = userInput.readLine(); // Leemos variable String
			// Revisamos si la respuesta es si o no
			switch(respuesta1.toLowerCase()) {
				case "si":
					System.out.println("Has decidido asignar todos los puntos a un mismo aspecto");
					System.out.println("Al ataque, a la defensa o la velocidad");
					respuesta2 = userInput.readLine();
					switch(respuesta2.toLowerCase()) {
						case "ataque":
							jugador.setAtaque(jugador.getAtaque() + experiencia);
							experiencia = 0;
							break;
						case "defensa":
							jugador.setDefensa(jugador.getDefensa() + experiencia);
							experiencia = 0;
							break;
						case "velocidad":
							jugador.setVelocidad(jugador.getVelocidad() + experiencia);
							experiencia = 0;
							break;
						default:
							System.out.println("La respuesta no es la esperada, podr�as volver a intentarlo?");
							break;
					}
					break;
				case "no":
					System.out.println("D�nde quieres asignar puntos de experiencia: al ataque,a la defensa o a la velocidad");
					respuesta3 = userInput.readLine();
					switch(respuesta3.toLowerCase()) {
						case "ataque":
							jugador.setAtaque(jugador.getAtaque() + experiencia);
							experiencia--;
							break;
						case "defensa":
							jugador.setDefensa(jugador.getDefensa() + experiencia);
							experiencia--;
							break;
						case "velocidad":
							jugador.setVelocidad(jugador.getVelocidad() + experiencia);
							experiencia--;
							break;
						default:
							System.out.println("La respuesta no es la esperada, podr�as volver a intentarlo?");
							break;
					}
				default:
					System.out.println("No se ha dado una respuesta v�lida, vuelve a intentarlo.");
					break;
			}
			jugador.describe();
		}
	}
	
}