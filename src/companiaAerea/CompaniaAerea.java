package companiaAerea;

import java.util.ArrayList;
import java.util.Scanner;

public class CompaniaAerea {
    private Aeropuertos aeropuertos;
    private Vuelos vuelos;
    private Pilotos pilotos;
    private Aviones aviones;
    Scanner read;
    public  CompaniaAerea() {
        read = new Scanner(System.in);
        aeropuertos = new Aeropuertos();
        pilotos = new Pilotos();
        aviones = new Aviones();
        vuelos = new Vuelos(aeropuertos, aviones);

        mostrarMenu();
    }

    public void mostrarMenu() {
        while(true) {
            System.out.println("1: Dar de alta aviones y sus datos");
            System.out.println("2: Consultar aviones por tipo");
            System.out.println("3: Dar de alta pilotos");
            System.out.println("4: Dar de alta aeropuertos");
            System.out.println("5: Registrar vuelos");
            System.out.println("6: Consultar vuelos ya sea por origen o por destino");
            System.out.println("7: Consultar aeropuertos por ciudad");
            System.out.println("8: Salir");
            System.out.print("Elige la opción que deseas realizar: ");

            int opcion = Integer.valueOf(read.nextLine());
            if(opcion == 1) {
                pedirDatosDeAviones(); continue;
            }
            if(opcion == 2) {
                pedirDatosConsultarAvionesTipo(); continue;
            }
            if(opcion == 3) {
                pedirDaotosPilotos(); continue;
            }
            if(opcion == 4) {
                pedirDatosAeropuertos(); continue;
            }
            if(opcion == 5) {
                // TODO: registrar vuelos
            }
            if(opcion == 6) {
                // TODO: consultar vuelos por origen o destino
            }
            if(opcion == 7) {
                // TODO: consultar aeropuertos por ciudad
            }
            if(opcion == 8) {
                break;
            }
        }

    }

    public  void pedirDatosDeAviones() {
        System.out.print("¿Cuántos aviones deseas registrar?: ");
        int cantidad = Integer.valueOf(read.nextLine()) ;
        for(int curAvion = 0; curAvion < cantidad; curAvion++) {
            System.out.print("Ingresa la matricula del avion: ");
            String matricula = read.nextLine();
            System.out.println("1: Carga\n 2: Pasajeros\n 3: Militar\n 4: Recreación\n 5: Excursión\n");
            System.out.print("Ingresa el tipo de avion de las opciones disponibles: ");
            int tipoAvion = Integer.valueOf(read.nextLine());
            System.out.print("Ingresa el fabricante del avion: ");
            String fabricante = read.nextLine();
            System.out.print("Ingresa el modelo del avion: ");
            String modelo = read.nextLine();
            System.out.print("Ingresa la capacidad del avion: ");
            int capacidad = Integer.valueOf(read.nextLine());
            System.out.print("Ingresa la autonomía del avion en km: ");
            int autonomia = Integer.valueOf(read.nextLine());
            Avion avion = new Avion(matricula,tipoAvion,fabricante,modelo,capacidad,autonomia);
            aviones.agregarAvion(avion);
            System.out.println("\nAvión agregado correctamente\n");
        }
    }

    public  void pedirDatosConsultarAvionesTipo() {
        System.out.println("1: Carga\n 2: Pasajeros\n 3: Militar\n 4: Recreación\n 5: Excursión\n");
        System.out.println("¿Cuál tipo de avión deseas consultar?: ");
        int tipoAvion = Integer.valueOf(read.nextLine());
        ArrayList<Avion> res = aviones.getPorTipo(tipoAvion);
        System.out.println("Lista de aviones: \n");
        for(var avion: res ) {
            System.out.println(avion);
        }
        System.out.print("\n");
    }

    public  void pedirDaotosPilotos() {
        System.out.print("¿Cuántos pilotos deseas registrar?: ");
        int cantidad = Integer.valueOf(read.nextLine()) ;
        for(int curPiloto = 0; curPiloto < cantidad; curPiloto++) {
            System.out.println("1: Carga\n 2: Pasajeros\n 3: Militar\n 4: Recreación\n 5: Excursión\n");
            System.out.print("Ingresa el tipo de licencia del piloto: ");
            int tipoPiloto = Integer.valueOf(read.nextLine());
            String nombre = read.nextLine();
            System.out.print("Ingresa la matrícula del piloto: ");
            String matricula = read.nextLine();
            Piloto piloto = new Piloto(tipoPiloto,nombre, matricula);
            pilotos.agregarPiloto(piloto);
        }
    }

    public void pedirDatosAeropuertos() {
        System.out.print("¿Cuántos aeropuertos deseas registrar?: ");
        int cantidad = Integer.parseInt(read.nextLine()) ;
        for(int curAeropuerto = 0; curAeropuerto < cantidad; curAeropuerto++) {
            System.out.print("Ingresa la ciudad del aeropuerto: ");
            String ciudad = read.nextLine();
            System.out.print("Ingresa el país del aeropuerto: ");
            String pais = read.nextLine();
            System.out.print("Ingresa el codigo del aeropuerto: ");
            String codigo = read.nextLine();
            Aeropuerto aeropuerto = new Aeropuerto(ciudad,pais,codigo);
            aeropuertos.agregarAeropuerto(aeropuerto);
        }
        System.out.print("\n");
    }

    public void pedirDatosVuelos() {
        System.out.print("¿Cuántos vuelos deseas registrar?: ");
        int cantidad = Integer.parseInt(read.nextLine());
        for(int curVuelo = 0; curVuelo < cantidad; curVuelo++) {
            System.out.print("Ingresa la matricula del avion que realizó el vuelo: ");

            System.out.print("Ingresa la matricula del avion que realizó el vuelo: ");
            String matriculaAvion = read.nextLine(); // TODO: validar que exista esta matricula
            System.out.print("Ingresa el código del aeropuerto de origen: ");
            String aeropuertoOrigen = read.nextLine();
            System.out.print("Ingresa el código del aeropuerto de destino: ");
            String aeropuertoDestino = read.nextLine();

        }
    }

}
