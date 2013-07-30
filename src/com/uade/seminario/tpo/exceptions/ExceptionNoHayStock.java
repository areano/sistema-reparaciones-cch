package exceptions;

public class ExceptionNoHayStock extends RuntimeException {
	private final int codigo;
	
	public int getCodigo(){
		return this.codigo;
	}
	public ExceptionNoHayStock (int codigo){
		super("La pieza de codigo: " +codigo + "no tiene stock");
		this.codigo=codigo;		
	}	
}
