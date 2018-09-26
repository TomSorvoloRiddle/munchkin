
public class Fight {
	private Player jugador;
	private Enemy enemigo;
	
	// Constructor vac�o
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
	
	// M�todos de la clase
	// -------------------- M�todos para el jugador --------------------------------
	/**
	 * playerIsFaster();
	 * M�todo que comprueba si el jugador es m�s r�pido que el enemigo
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
	 * M�todo que comprueba si el jugador es el doble de r�pido que el enemigo
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
	 * M�todo que hace que el jugador ataque
	 * Sin par�metros
	 */
	public void playerAtack() {
		this.enemigo.setDefensa( (byte) (this.enemigo.getDefensa()- this.jugador.getAtaque()) );
	}
	
	/**
	 * playerIsKo();
	 * M�todo que devuelve verdadero si el jugador se ha quedado sin defensa y por lo tanto ha perdido la batalla
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
	 * M�todo que nos dir� si el personaje del jugador est� muerto o no.
	 * @return boolean died;
	 */
	public boolean playerIsDead() {
		boolean died = false;
		if( this.jugador.getVida() > 0 ) {
			died = true;
		}
		return died;
	}
	
	// ---------------------- M�todos para el enemigo -------------------------------------------
	/**
	 * enemyIsFaster();
	 * M�todo que comprueba si el enemigo es m�s r�pido que el jugador
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
	 * M�todo que comprueba si el enemigo es el doble de r�pido que el jugador
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
	 * M�todo que hace que el enemigo ataque
	 * Sin par�metros
	 */
	public void enemyAtack() {
		this.jugador.setDefensa( (byte) (this.jugador.getDefensa()- this.enemigo.getAtaque()) );
	}
	
	/**
	 * enemyIsKo();
	 * M�todo que devuelve verdadero si el enemigo se ha quedado sin defensa y por lo tanto ha perdido la batalla
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
