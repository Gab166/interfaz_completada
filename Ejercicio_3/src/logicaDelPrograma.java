
public class logicaDelPrograma {

	public boolean comprobacionCorreo(String correo) {
		
		//PROGRAMACON PARA LA COMPROBACION DEL CORREO ELECTRONICO
		
		int arroba = 0;
		int punto = 0;
		
		for(int i = 0; i < correo.length();i++) {
			if(correo.charAt(i) == '@') {
				arroba++;
			}else if (correo.charAt(i) == '.') {
				punto++;
			}
		}
	
		if(arroba == 1 && punto >=1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean comprobacionNombre(String nombre) {
		
		//PROGRAMACON PARA LA COMPROBACION DEL NOMBRE DEL USUARIO
		
		if("".equals(nombre)) {
			return false;
		}
		
		int numbersAndSigns = 0;
		
		for (int i=0;i<nombre.length();i++) {
			if((nombre.charAt(i) == '0')
				|| (nombre.charAt(i) == '1')
				|| (nombre.charAt(i) == '2')
				|| (nombre.charAt(i) == '3')
				|| (nombre.charAt(i) == '4')
				|| (nombre.charAt(i) == '5')
				|| (nombre.charAt(i) == '6')
				|| (nombre.charAt(i) == '7')
				|| (nombre.charAt(i) == '8')
				|| (nombre.charAt(i) == '.')
				|| (nombre.charAt(i) == ',')
				|| (nombre.charAt(i) == '_')
				|| (nombre.charAt(i) == '*')) 
			{
				numbersAndSigns++;
			}
		}
		
		if(numbersAndSigns >= 1) {
			return false;
		}else {
			return true;
		}	
	}
	
		public boolean comprobacionEdad(String edad) {
			 
			int cantidadCaracterFecha = edad.length();
			
			if(cantidadCaracterFecha==10 && edad.charAt(2)=='/' && edad.charAt(5)=='/')
			{
				return true;
				
		}else {
			return false;
		}
	
	

	}
}
