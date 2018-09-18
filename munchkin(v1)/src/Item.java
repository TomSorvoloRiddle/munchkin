/**
 * 
 */
package base;

/**
 * @author Christian y Miquel
 * Superclase Item, todos los objetos del juego, serán subclases de item
 * 
 */
public class Item {
	private String nombre;
	private int peso;
	private String descripcion;
	
	/** Getter del nombre de la clase
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/** Setter del nombre de la clase
	 * @param String nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** Getter del peso
	 * @return int peso
	 */
	public int getPeso() {
		return peso;
	}
	/** Setter del peso de la clase
	 * @param int peso
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/** Getter atributo descripción
	 * @return String descripción
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/** Setter atributo descripcion
	 * @param String descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}