/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea3_carmencastillo12311146;

import java.util.Scanner;

/**
 *
 * @author casti
 */
public class Tarea3_CarmenCastillo12311146 {

    static Scanner leer = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in, "ISO-8859-1");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguirmenu = true;
        while (seguirmenu) {
            System.out.println(" ");
            System.out.println("Menu");
            System.out.println("1. Veamos si podemos formar la palabra.");
            System.out.println("2. Números primero.");
            System.out.println("3. Ordenar alfabéticamente.");
            System.out.println("4. Codificar cadenas.");
            System.out.println("5. Jugando con arreglos.");
            System.out.println("6. Salir.");
            System.out.print("Ingrese su opcion: ");
            int opcionmenu = leer.nextInt();
            System.out.println("");

            switch (opcionmenu) {
                case 1:
                    System.out.println("Opción 1 [Veamos si podemos formar la palabra]");
                    System.out.print("Ingrese su primera cadena / oración: ");
                    String cadena1 = sc.nextLine();
                    System.out.print("Ingrese su segunda cadena / oración: ");
                    String cadena2 = sc.nextLine();
                    while (cadena1.length() == cadena2.length()) {
                        System.out.print("Reingrese su cadena / oracion con un diferente tamaño: ");
                        cadena2 = sc.nextLine();
                    }
                    if (cadena1.length() > cadena2.length()) {
                        if (recorrerCadena(cadena1, cadena2)) { //en caso que la primera cadena sea mayor
                            System.out.println("Si se puede armar " + cadena2 + ".");
                        } else {
                            System.out.println("No se puede armar " + cadena2 + ".");
                        }
                    } else {
                        if (recorrerCadena(cadena2, cadena1)) { //si la cadena 2 es mayor
                            System.out.println("Si se puede armar " + cadena1 + ".");
                        } else {
                            System.out.println("No se puede armar " + cadena1 + ".");
                        }

                    }

                    break;

                case 2:
                    System.out.println("Opción 2 [Números primero]");
                    System.out.print("Ingrese su cadena / oracion con numeros: ");
                    String oracion = sc.nextLine();
                    boolean contiene = false;//para saber si contiene lo necesario
                    //Validar la cadena
                    int contadorLetras = 0,
                     contadorNumeros = 0;
                    for (int i = 0; i < oracion.length(); i++) {
                        int c = (int) oracion.charAt(i);
                        if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) { //si contiene letras
                            contadorLetras++;
                        }
                        if (c >= 48 && c <= 57) { //contiene numeros
                            contadorNumeros++;
                        }
                    }
                    if (contadorLetras == 0) {
                        System.out.println("La cadena no tiene letras.");
                    } else if (contadorNumeros == 0) {
                        System.out.println("La cadena no tiene numeros.");
                    } else {
                        contiene = true;
                    }

                    if (contiene) {
                        cadenaNumeros(oracion);
                    }

                    break;

                case 3:
                    System.out.println("Opción 3 [Ordenar alfabéticamente]");
                    System.out.print("Ingrese su cadena / oracion para ordenar alfabeticamente: ");
                    String input = sc.nextLine().toLowerCase();

                    int contadorLetr = 0;
                    for (int i = 0; i < input.length(); i++) {
                        int c = (int) input.charAt(i);
                        if ((c >= 97 && c <= 122)) { //validar contiene letras
                            contadorLetr++;
                        }
                    }
                    while (contadorLetr == 0) {
                        System.out.print("Ingrese su cadena con letras: ");
                        input = sc.nextLine();
                    }

                    ordenarAlfabeticamente(input);

                    break;

                case 4:
                    System.out.println("Opción 4 [Codificar cadenas]");
                    System.out.print("Ingrese su texto: ");
                    String textoing = sc.nextLine();
                    while (textoing.contains("0")) {
                        System.out.print("No se permite ingresar cero en la cadena, re-ingreselo: ");
                        textoing = sc.nextLine();
                    }
                    String encodedText = codInput(textoing);
                    System.out.println("Texto codificado: " + encodedText);

                    break;

                case 5:
                    System.out.println("Opción 5 [Jugando con arreglos]");
                    int[] jArreglo = new int[10];
                    boolean seguirsubmenu = true;
                    while (seguirsubmenu) {
                        System.out.println("");
                        System.out.println("Menu");
                        System.out.println("1. Rellenar Arreglo.");
                        System.out.println("2. Imprimir Arreglo.");
                        System.out.println("3. Salir.");
                        System.out.print("Ingrese su opcion: ");
                        int opcionsubmenu = leer.nextInt();
                        System.out.println("");

                        switch (opcionsubmenu) {
                            case 1:
                                System.out.println("Opción 1 [Rellenar Arreglo]");
                                System.out.println("Ingrese 10 valores para el arreglo.");
                                llenarArreglo(jArreglo);
                                break;
                                
                            case 2:
                                System.out.println("Opción 2 [Imprimir Arreglo]");
                                imprimirArreglo(jArreglo);
                                break;
                                
                            default:
                                seguirsubmenu = false;
                        }
                        
                        
                        
                    }
                    break;

                default:
                    System.out.println("Gracias por usar el programa.");
                    seguirmenu = false;

                    break;

            }

        }

    }

    public static boolean recorrerCadena(String cadenalarga, String cadenacorta) {
        for (int i = 0; i < cadenacorta.length(); i++) {
            char letra = cadenacorta.charAt(i);
            boolean encontrada = false;

            for (int j = 0; j < cadenalarga.length(); j++) {
                if (cadenalarga.charAt(j) == letra) {
                    cadenalarga = cadenalarga.substring(0, j) + cadenalarga.substring(j + 1); //substring para verificar
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                return false;
            }
        }
        return true;
    }

    public static String cadenaNumeros(String cadenanum) {
        String cadenanump = ""; //cadenanueva
        //char c = cadenanum.charAt(0);

        for (int i = 0; i < cadenanum.length(); i++) {
            char c = cadenanum.charAt(i);
            if (c >= 48 && c <= 57) { //anadir si son numeros
                cadenanump += c;
            }
        }
        for (int i = 0; i < cadenanum.length(); i++) {
            char c = cadenanum.charAt(i);
            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) { //anadir si son letras
                cadenanump += c;
            }
        }

        System.out.println("Su nueva cadena re-organizada es: " + cadenanump + ".");

        return cadenanump;
    }

    public static int ordenarAlfabeticamente(String cadenain) {
        int contadorNum = 0;
        String cadenaNueva = ""; //cadena nueva para adjuntar todos los caracteres en orden
        //char c = cadenanum.charAt(0);

        for (char c = 97; c <= 122; c++) { //recorre el rango de char con la tabla ascii
            for (int i = 0; i < cadenain.length(); i++) {
                if (cadenain.charAt(i) == c) {
                    cadenaNueva += c; // se le suma el caracter
                }
            }
        }

        for (int i = 0; i < cadenain.length(); i++) {
            int c = (int) cadenain.charAt(i);
            if (c >= 48 && c <= 57) { //contiene numeros
                contadorNum++; //el valor retornado + la cantidad 
            }
        }

        System.out.println("Su nueva cadena alfabetica es: " + cadenaNueva + ".");
        System.out.println("Valor entero retornado: " + contadorNum + ".");

        return contadorNum;
    }

    public static String codInput(String textoingr) {
        String resultado = "";

        for (int i = 0; i < textoingr.length(); i++) { //recorrer cadena
            char c = textoingr.charAt(i);

            switch (c) {
                case ' ': //espacio no pasa nada
                    break;

                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': //remplazar numero con su respectiva letra
                    char letra = (char) (c - '0' + 96);
                    resultado += letra;
                    break;

                default:
                    // reempazar letra por numero
                    int numero = (int) (c - 96);
                    resultado += numero;
                    break;
            }

            //despues de cada uno ingresa un guion
            if (i < textoingr.length() - 1) {
                resultado += '-';
            }

        }

        return resultado.toUpperCase(); //to upper case para poner las letras (numeros anteriormente) en mayuscula

    }

    public static void llenarArreglo(int[] jugarreglo) {
        for (int i = 0; i < jugarreglo.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            int num = leer.nextInt();
            jugarreglo[i] = num;
        }

    }

    public static void imprimirArreglo(int[] imprarreglo) {
        System.out.println("");
        System.out.println("Contenido del arreglo:");
        for (int i = 0; i < imprarreglo.length; i++) {
            System.out.println("Posición " + (i + 1) + ": " + imprarreglo[i]);
        }
    }

}
