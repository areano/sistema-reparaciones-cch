package exceptions;

public class ExceptionExisteModelo extends RuntimeException {
	private final int codigo;
	
	public int getCodigo(){
		return this.codigo;
	}
	public ExceptionExisteModelo (int codigo){
		super("El modelo de codigo: " +codigo + "ya existe");
		this.codigo=codigo;		
	}	

}
