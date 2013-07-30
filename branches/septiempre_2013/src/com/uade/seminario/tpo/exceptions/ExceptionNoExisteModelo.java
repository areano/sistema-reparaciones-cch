package exceptions;

public class ExceptionNoExisteModelo extends RuntimeException {
	private final int codigo;
	
	public int getCodigo(){
		return this.codigo;
	}
	public ExceptionNoExisteModelo (int codigo){
		super("El modelo de codigo: " +codigo + "no existe");
		this.codigo=codigo;		
	}	

}
