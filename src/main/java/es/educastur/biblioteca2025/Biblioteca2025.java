
package es.educastur.biblioteca2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Biblioteca2025 {
    
    private ArrayList <Libro> libros;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos;

    public Biblioteca2025() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
    }
    
    public static void main(String[] args) {
        Biblioteca2025 b= new Biblioteca2025();
        b.cargaDatos();
        for (Usuario u : b.usuarios) {
            System.out.println(u);
        }
        b.menu();
    }
    private void menu(){
        Scanner sc=new Scanner (System.in);
       int opcion=0;
       do{
           System.out.println("\n\n\n\n\n\t\t\t\tGESTIÓN DE LA BIBLIOTECA\n");
           System.out.println("\t\t\t\t1 - LIBROS");
           System.out.println("\t\t\t\t2 - USUARIOS");
           System.out.println("\t\t\t\t3 - PRESTAMOS/DEVOLUCIONES");
           System.out.println("\t\t\t\t9 - SALIR");
           opcion=sc.nextInt();
           switch (opcion){
               case 1:{
                   menuLibro();
                   break;
               }    
               case 2:{
                   menuUsuarios();
                   break;
               } 
               case 3:{
                   menuPrestamos();
                   break;
               } 
            
           }
       }while (opcion != 9);
   }

   //#region MENUS SECUNDARIOS

   private void menuLibro(){
    Scanner sc=new Scanner (System.in);
    int opcion=0;
    do{
        System.out.println("\n\n\n\n\n\t\t\t\tGESTIÓN DE LIBROS\n");
        System.out.println("\t\t\t\t1 - NUEVO LIBRO");
        System.out.println("\t\t\t\t2 - ELIMINAR LIBRO");
        System.out.println("\t\t\t\t3 - MODIFICAR DATOS DE LIBRO");
        System.out.println("\t\t\t\t4 - LISTADO");
        System.out.println("\t\t\t\t9 - SALIR");
        opcion=sc.nextInt();
        switch (opcion){
            case 1:{
                nuevoLibro();
                break;
            }    
            case 2:{
                eliminarLibro();
                break;
            } 
            case 3:{
                modificarLibro();
                break;
            } 
            case 4:{
                listaLibros();
                break;
            } 
        }
    }while (opcion != 9);
}

    private void menuUsuarios(){
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tGESTIÓN DE USUARIOS\n");
            System.out.println("\t\t\t\t1 - NUEVO USUARIO");
            System.out.println("\t\t\t\t2 - ELIMINAR USUARIO");
            System.out.println("\t\t\t\t3 - MODIFICAR USUARIO");
            System.out.println("\t\t\t\t4 - LISTA DE USUARIOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoUsuario();
                    break;
                }    
                case 2:{
                    eliminarUsuario();
                    break;
                } 
                case 3:{
                    modificarUsuario();
                    break;
                } 
                case 4:{
                    listaUsuarios();
                    break;
                } 
            }
        }while (opcion != 9);
    
}

private void menuPrestamos(){
    Scanner sc=new Scanner (System.in);
    int opcion=0;
    do{
        System.out.println("\n\n\n\n\n\t\t\t\tGESTIÓN DE PRESTAMOS\n");
        System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
        System.out.println("\t\t\t\t2 - DEVOLUCIONES");
        System.out.println("\t\t\t\t3 - PRÓRROGAS");
        System.out.println("\t\t\t\t4 - LISTA DE PRESTAMOS");
        System.out.println("\t\t\t\t9 - SALIR");
        opcion=sc.nextInt();
        switch (opcion){
            case 1:{
                nuevoPrestamo();
                break;
            }    
            case 2:{
                devolucion();
                break;
            } 
            case 3:{
                prorroga();
                break;
            } 
            case 4:{
                listaPrestamos();
                break;
            } 
        }
        }while (opcion != 9);
    }

    //#endregion

    //#region LIBRO
    
    private void nuevoLibro() {
        String  isbn, titulo, autor, genero;
        int ejemplares;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("NUEVO LIBRO:");
        System.out.println();
        System.out.println("______________");
        System.out.println("ISBN:");
        isbn=sc.nextLine();
        System.out.println("TITULO:");
        titulo=sc.next();
        System.out.println("AUTOR:");
        autor=sc.next();
        System.out.println("GENERO:");
        genero=sc.next();
        System.out.println("EJEMPLARES:");
        ejemplares=sc.nextInt();

        libros.add(new Libro(isbn,titulo,autor,genero,ejemplares));
    }

    private void eliminarLibro() {
        String isbn=solicitaIsbn();
        int pos=buscaIsbn(isbn);
        libros.remove(pos);
        System.out.println();
        System.out.println("La petición se ha procesado correctamente");
        System.out.println("El libro ha sido eliminado del registro de la Biblioteca");
        //System.out.println(libros);
    }

    private void modificarLibro() {
        Scanner sc=new Scanner (System.in);
        String isbn=solicitaIsbn();
        int pos=buscaIsbn(isbn);
            if (pos==-1){
                System.out.println("El ISBN que buscas no está en el registro"); 
            }else{
                System.out.println("Cambio de ejemplares");
                System.out.println();
                System.out.println("Introduce '+' si desea añadir unidades y '-' en el caso de eliminarlos más unidades");
                int ejemplares = sc.nextInt();
                libros.get(pos).setEjemplares(libros.get(pos).getEjemplares()+ejemplares);    
            }
            //System.out.println(libros);
    }

    private void listaLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    //#endregion

    //#region USUARIO

    private void nuevoUsuario() {
        String  dni, nombre, email, telefono, fechaNac;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("NUEVO USUARIO:");
        System.out.println();
        System.out.println("______________");
        System.out.println("DNI:");
        dni=sc.nextLine();
        System.out.println("NOMBRE:");
        nombre=sc.next();
        do{
            System.out.println("EMAIL:");
            email=sc.next();
        }while(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
        do{
            System.out.println("TELEFONO:");
            telefono=sc.next();
        }while(!telefono.matches("[6-7][0-9]{8}")); 

        usuarios.add(new Usuario(dni,nombre,email,telefono));
    }

    private void eliminarUsuario() {
        String dni=solicitaDni();
        System.out.println(dni);
        int pos=buscaDni(dni);
        usuarios.remove(pos);
        System.out.println(pos);
        System.out.println();
        System.out.println("La petición se ha procesado correctamente");
        System.out.println("El usuario ha sido eliminado del registro de la Biblioteca");
        //System.out.println(usuarios);
    }

    /**
     * Método para modificar el Usuario. Se puede modificar nombre, email y teléfono. 
     * Poner la comprobación del email
     * Método privado, no devuelve ni recoge nada, no obligatorio
     */

    private void modificarUsuario() {
        Scanner sc=new Scanner (System.in);
        System.out.println("El DNI de la persona cuyos datos se desea modificar: ");
        String dni=sc.nextLine();
        int pos=buscaDni(dni);
        int opcion=-1;
            if (pos==-1){
                System.out.println("El DNI que buscas no está en el registro"); 
            }else{
                System.out.println("");
                do{
                    System.out.println("\n\n\n\n\n\t\t\t\t¿Qué desea modificar?\n");
                    System.out.println("\t\t\t\t1 - NOMBRE");
                    System.out.println("\t\t\t\t2 - EMAIL");
                    System.out.println("\t\t\t\t3 - TELÉFONO");
                    System.out.println("\t\t\t\t9 - SALIR");
                    opcion=sc.nextInt();
                    switch (opcion){
                        case 1:{
                            System.out.println("Teclea el nombre de usuario nuevo");
                            String nombre = sc.nextLine();
                            usuarios.get(pos).setNombre(nombre);
                            break;
                        }    
                        case 2:{
                            System.out.println("Teclea el email nuevo");
                            String email = sc.nextLine();
                            usuarios.get(pos).setEmail(email);
                            break;
                        } 
                        case 3:{
                            System.out.println("Teclea el número de teléfono nuevo");
                            String telNuevo = sc.nextLine();
                            usuarios.get(pos).setTelefono(telNuevo);
                            break;
                        }  
                    }
                    }while (opcion != 9);
                }
                
    }

    /**
     * Método para mostrar el ArrayList de usuarios
     */

    private void listaUsuarios() {
       for (Usuario u : usuarios) {
        System.out.println(u);
       }
    }

    //#endregion

    //#region PRÉSTAMO

    /**
     * Método para crear un nuevo prestamo (Objeto tipo Prestamo) y añadirlo al ArrayList de prestamos.
     * No devuelve nada
     */

    private void nuevoPrestamo() {
        System.out.println("Identificación del usuario:");
        int posUsuario = buscaDni(solicitaDni());
        if (posUsuario==-1) {
            System.out.println("Aún no es usuario de la biblioteca");
            //System.out.println("¿Desea dar de alta a nuevo usuario?");

        } else{
            System.out.println("Identificación del libro:");
            int posLibro=buscaIsbn(solicitaIsbn());
            if (posLibro==-1) {
                System.out.println("El ISBN pertenece a un libro inexistente");
            }else if (libros.get(posLibro).getEjemplares()>0){
                LocalDate hoy=LocalDate.now();
                prestamos.add(new Prestamo(libros.get(posLibro), usuarios.get(posUsuario), hoy, hoy.plusDays(15)));
                libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
            }else{
                System.out.println("No quedan más unidades disponibles de este libro");
            }
        }
    }

    /**
     * Método para devolver al registro el libro prestado. Privado, no devuelve ni recoge nada  
     */

    private void devolucion() {
        System.out.println("Datos para la devolución:");
        String isbn=solicitaIsbn();
        int pos=buscaPrestamo(solicitaDni(), isbn);
        if (pos==-1){
            System.out.println("El prestamo que buscas no existe"); 
        }else{
            System.out.println("La fecha de la devolución se prolongará 15 días");
            prestamos.get(pos).setFechaDev(LocalDate.now());
            libros.get(buscaIsbn(isbn)).setEjemplares(+1);
        }
        System.out.println();
        System.out.println("La devolución se ha procesado correctamente");
        //System.out.println(prestamos);
    }

    /**
     * Método para modificar el prestamo. Añade otros 15 días a la fechaDev
     */

    private void prorroga() {
        int pos=buscaPrestamo(solicitaDni(), solicitaIsbn());
            if (pos==-1){
                System.out.println("El prestamo que buscas no existe"); 
            }else{
                System.out.println("La fecha de la devolución se prolongará 15 días");
                prestamos.get(pos).setFechaDev(prestamos.get(pos).getFechaDev().plusDays(15));
            }
            //System.out.println(prestamos);
    } 

    /**
     * Método que lista los prestamos. No pide ni devuelve nada
     */

    private void listaPrestamos() {
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }

    //#endregion

    //#region MÉTODOS AUXILIARES


    /**
     * Metodo para buscar un DNI en la colección de usuarios
     * @param dni dni(String) de usuario a buscar en la coleccion
     * @return int posicion del usuario en el ArrayList, valor -1 si no se encuentra
     */

    public int buscaDni(String dni){
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getDni().equals(dni)){
                pos=i;
                break;
            }
        }
        return pos;
    }

    /**
     * Metodo para buscar un Libro en la colección de libros
     * @param isbn (String) del libro a buscar en la coleccion 
     * @return posicion (int) del libro el ArrayList, valor -1 si no se encuentra
     */

    public int buscaIsbn(String isbn){
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if(libros.get(i).getIsbn().equals(isbn)){
                pos=i;
                break;
            }
        }
        return pos;
    }

    /**
     * Método para buscar un préstamo una vez recibido el DNI del usuario
     * @param dni (Sring) del usuario que realiza el préstamo
     * @param isbn (String) del libro prestado
     * @return pos int del préstamo. 
     */

    public int buscaPrestamo (String dni, String isbn){
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrest().equals(dni) && prestamos.get(i).getLibroPrest().equals(isbn)){ 
                pos=i;
                break;
            }
        }
        return pos;
    }


    /**
     * Método para solicitar por el teclado el DNI de un usuario. pdte de validación
     * @return (String) dni del usuario tecleado
     */

    public String solicitaDni(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea el DNI del Usuario:");
        String dni=sc.next();
        return dni;
    }

    /**
     * Metodo para solicitar un isbn. pdte de validacion
     * @return String isbn del libro tecleado. 
     */

    public String solicitaIsbn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea el ISBN del libro:");
        String isbn=sc.next();
        return isbn;
    }

    private void cargaDatos(){
            libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
            libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
            libros.add(new Libro("1-33","El Médico","N. Gordon","Aventuras",4)); 
            libros.add(new Libro("1-44","Chamán","N. Gordon","Aventuras",3)); 
            libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
            libros.add(new Libro("1-66","Paraíso inhabitado","A.M.Matute","Aventuras",2)); 
            libros.add(new Libro("1-77","Olvidado Rey Gudú","A.M.Matute","Aventuras",2)); 
            libros.add(new Libro("1-88","El último barco","D.Villar","Novela Negra",3)); 
            libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",2)); 
    
            usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
            usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
            usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
            usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
            usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
            usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
            
            LocalDate hoy= LocalDate.now();
            prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy,hoy.plusDays(15)));
            prestamos.add(new Prestamo(libros.get(8),usuarios.get(2), hoy,hoy.plusDays(15)));
            prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
            prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
            prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
            prestamos.add(new Prestamo(libros.get(2),usuarios.get(1), hoy,hoy.plusDays(15)));
        
            for (Libro l:libros) {
                System.out.println(l);
            }
            System.out.println("");
            for (Usuario u:usuarios) {
                System.out.println(u);
            }
            System.out.println("");
            for (Prestamo p:prestamos) {
                System.out.println(p);
            }
        
    }
    

    //#endregion
   
}
