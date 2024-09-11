package ui;

import java.util.Scanner;

public class Guacamaya {

    public static Scanner rd;
    public static double[] precios;
    public static int[] unidades;

   
    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner rd debe estar declarado
     * pos: El Scanner rd queda inicializado
    */
    public static void inicializarGlobales() {

        rd = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner rd debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = rd.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = rd.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    rd.close();
                    break;

                default:
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner rd debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        int referencias = rd.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }

    /**
     * Descripcion: Este metodo se encarga de solicitar al usuario el precio de cada referencia y la cantidad de unidades vendidas en el dia
     * pre: El Scanner rd debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan llenos de los datos ingresados por el usuario
     */
    public static void solicitarDatos(){
        for (int i = 0; i < precios.length; i++) {
            System.out.println("ingrese el precio de la  referencia N#"+(i+1));
            precios[i] = rd.nextDouble();
            System.out.println("ingrese la cantidad de unidades vendidas de la  referencia N#"+ (i+1));
            unidades[i] = rd.nextInt();
        }
        

     
    }

    /**
     * Descripcion: Este metodo calcula la cantidad total de unidades vendidas en el dia.
     * pre: El arreglo unidades debe estar inicializado.
     * @return totalUnidades, La cantidad total de unidades vendidas.
     */
    public static int calcularTotalUnidadesVendidas(){
        int totalUnidades = 0;
        for (int i = 0; i < unidades.length; i++) {
            totalUnidades += unidades[i];
        }

        return totalUnidades;

    }

    /**
     * Descripcion: Este metodo calcula el precio promedio de las referencias de producto vendidas en el dia.
     * pre: El arreglo precios debe estar inicializado.
     * @return promedio, El precio promedio de las referencias de producto vendidas.
     */
    public static double calcularPrecioPromedio(){
        double suma = 0;
        for (int i = 0; i < precios.length; i++) {
            suma += precios[i];
        }
        double promedio = suma / precios.length;
        return promedio;

    }

    /**
     * Descripcion: Este metodo calcula las ventas totales (dinero recaudado) durante el dia.
     * pre: Los arreglos precios y unidades deben estar inicializados.
     * @return total, Las ventas totales del dia.
     */
    public static double calcularVentasTotales(){
        double total = 0;
        for (int i = 0; i < precios.length; i++) {
            total += precios[i] * unidades[i];
        }

        return total;

    }

    /**
     * Descripcion: Este metodo consulta el numero de referencias de productos que en el dia han superado un limite minimo de ventas.
     * pre: Los arreglos precios y unidades deben estar inicializados.
     * @param limite El limite minimo de ventas a analizar.
     * @return sobreLimite, El numero de referencias de productos que superaron el limite minimo de ventas.
     */
    public static int consultarReferenciasSobreLimite(double limite){
        int sobreLimite = 0;
        for (int i = 0; i < unidades.length; i++) {
            if (precios[i] * unidades[i] > limite) {
                sobreLimite++;
            }
        }

        return sobreLimite;

    }

}
