package es.educastur.biblioteca2025;

public class MetodosAux {
    public static boolean esInt(String s){
        int n;
        try{
            n=Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }

    public boolean validarDNI(String dni) {
        // Verificar que el DNI tiene un formato válido
        if (dni.isBlank() || !dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            return false;
        }
        // Extraer el número y la letra del DNI
        String numeroStr = dni.substring(0, 8);
        char letra = dni.charAt(8);

        // Calcular la letra correspondiente al número del DNI
        char letraCalculada = calcularLetraDNI(Integer.parseInt(numeroStr));
        // Comparar la letra calculada con la letra proporcionada y devolver
        // el resultado de la comparación TRUE/FALSE
        return letra == letraCalculada; 
    }
    public char calcularLetraDNI(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(numero % 23);
    } 

    // Ejemplo de uso de la función validarDNI

    /*String dni;
        do {          
            System.out.println("teclea DNI:");
            dni=sc.next();
        } while(!validarDNI(dni));
        System.out.println("El dni bueno es: " + dni);
        */


        /*
         *   	//Ejemplo de uso esInt() esDouble en un bloque de código cualquiera para
        //solicitar las unidades (tipo int) y el precio (tipo doublé) de un libro

	String unidadesSt;
        do {          
            System.out.println("Unidades disponibles LIBRO:");
            unidadesSt=sc.next();
        } while(!esInt(unidadesSt));
        int unidades=Integer.parseInt(unidadesSt);
        
        String precioSt;
        do {          
            System.out.println("Precio LIBRO:");
            precioSt=sc.next();
        } while(!esDouble(precioSt));
        double precio=Double.parseDouble(precioSt);
        
        System.out.println("Unidades tecleadas (En formato int: " + unidades);
        System.out.println("precio (En formato Double: " + precio);


    public boolean esInt(String s) {
        int n;
        try {
            n=Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean esDouble(String s) {
        double n;
        try {
            n = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false; 
        }
    }
         */
}
