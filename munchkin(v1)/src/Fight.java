
public class Fight {
	private Player jugador;
	private Enemy enemigo;
	
	// Constructor vacío
	public Fight() {
		
	}
	
	// Constructor completo
	public Fight(Player p, Enemy e ) {
		this.jugador = p;
		this.enemigo = e;
	}
	
	// Getters y Setters
	/**
	 * Devuelve el jugador pasado
	 * @return Player jugador
	 */
	public Player getJugador() {
		return jugador;
	}
	/**
	 * Inserta jugador en la pelea
	 * @param Player jugador
	 */
	public void setJugador(Player jugador) {
		this.jugador = jugador;
	}

	/**
	 * Devuelve el enemigo
	 * @return Enemy enemigo
	 */
	public Enemy getEnemigo() {
		return enemigo;
	}
	/**
	 * Inserta enemigo para la pelea
	 * @param Enemy enemigo
	 */
	public void setEnemigo(Enemy enemigo) {
		this.enemigo = enemigo;
	}
	
	// Métodos de la clase
	// -------------------- Métodos para el jugador --------------------------------
	/**
	 * playerIsFaster();
	 * Método que comprueba si el jugador es más rápido que el enemigo
	 * @return boolean faster;
	 */
	public boolean playerIsFaster() {
		boolean faster = true;
		if(this.enemigo.getVelocidad() > this.jugador.getVelocidad() ) {
			faster = false;
		}
		return faster;
	}
	
	/**
	 * playerIsDoubleFaster();
	 * Método que comprueba si el jugador es el doble de rápido que el enemigo
	 * @return boolean faster;
	 */
	public boolean playerIsDoubleFaster() {
		boolean faster = false;
		if(this.enemigo.getVelocidad()*2 <= this.jugador.getVelocidad() ) {
			faster = true;
		}
		return faster;
	}
	
	/**
	 * playerAtack();
	 * Método que hace que el jugador ataque
	 * Sin parámetros
	 */
	public void playerAtack() {
		this.enemigo.setDefensa( (byte) (this.enemigo.getDefensa()- this.jugador.getAtaque()) );
	}
	
	/**
	 * playerIsKo();
	 * Método que devuelve verdadero si el jugador se ha quedado sin defensa y por lo tanto ha perdido la batalla
	 * @return boolean ko
	 */
	public boolean playerIsKo(){
		boolean ko = true;
		if(this.jugador.getDefensa() > 0) {
			ko = false;
		}
		return ko;
	}
	
	/**
	 * playerIsDead();
	 * Método que nos dirá si el personaje del jugador está muerto o no.
	 * @return boolean died;
	 */
	public boolean playerIsDead() {
		boolean died = false;
		if( this.jugador.getVida() > 0 ) {
			died = true;
		}
		return died;
	}
	
	// ---------------------- Métodos para el enemigo -------------------------------------------
	/**
	 * enemyIsFaster();
	 * Método que comprueba si el enemigo es más rápido que el jugador
	 * @return boolean faster;
	 */
	public boolean enemyIsFaster() {
		boolean faster = true;
		if(this.enemigo.getVelocidad() < this.jugador.getVelocidad() ) {
			faster = false;
		}
		return faster;
	}
	
	/**
	 * enemyIsDoubleFaster();
	 * Método que comprueba si el enemigo es el doble de rápido que el jugador
	 * @return boolean faster;
	 */
	public boolean enemyIsDoubleFaster() {
		boolean faster = false;
		if(this.enemigo.getVelocidad() >= this.jugador.getVelocidad()*2 ) {
			faster = true;
		}
		return faster;
	}
	
	/**
	 * enemyAtack();
	 * Método que hace que el enemigo ataque
	 * Sin parámetros
	 */
	public void enemyAtack() {
		this.jugador.setDefensa( (byte) (this.jugador.getDefensa()- this.enemigo.getAtaque()) );
	}
	
	/**
	 * enemyIsKo();
	 * Método que devuelve verdadero si el enemigo se ha quedado sin defensa y por lo tanto ha perdido la batalla
	 * @return boolean ko
	 */
	public boolean enemyIsKo(){
		boolean ko = true;
		if(this.enemigo.getDefensa() > 0) {
			ko = false;
		}
		return ko;
	}
	
}
