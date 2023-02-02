package companiaAerea;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

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

        iniciar();
    }


    public void iniciar() {
        while(true) {
            mostrarMenu();
            int opcion = Integer.parseInt(read.nextLine());
            if(opcion == 1) {
                pedirDatosRegistrarAviones(); continue;
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
                pedirDatosVuelos(); continue;
            }
            if(opcion == 6) {
                mostrarVuelosPorOrigen(); continue;
            }
            if(opcion == 7) {
                mostrarVuelosPorDestino(); continue;
            }
            if(opcion == 8) {
                consultarAeroPorCiudad(); continue;
            }
            if(opcion == 9) {
                break;
            }
        }

    }


    public  void pedirDatosRegistrarAviones() {
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
            System.out.print("Ingresa el nombre del piloto: ");
            String nombre = read.nextLine();
            Piloto piloto = new Piloto(tipoPiloto,nombre);
            pilotos.agregarPiloto(piloto);
            System.out.println("\nPiloto registrado correctamente\n");
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
            Aeropuerto aeropuerto = new Aeropuerto(ciudad,pais,aeropuertos.getListaAeropuertos().size() + 1);
            aeropuertos.agregarAeropuerto(aeropuerto);
            System.out.println("\nAeropuerto guardado correctamente");
        }
        System.out.print("\n");
    }

    public void pedirDatosVuelos() {
        System.out.print("¿Cuántos vuelos deseas registrar?: ");
        int cantidad = Integer.parseInt(read.nextLine());
        for(int curVuelo = 0; curVuelo < cantidad; curVuelo++) {
            System.out.println("1: Carga\n 2: Pasajeros\n 3: Militar\n 4: Recreación\n 5: Excursión\n");
            System.out.print("Ingresa el tipo de avión del vuelo: ");
            int tipoAvion = Integer.parseInt(read.nextLine());
            aviones.imprimirAvionesPorTipo(tipoAvion);
            if(aviones.getListaAviones().size() == 0) continue;
            System.out.print("Ingresa el ID del avion que realizó el vuelo: ");
            int idAvion = Integer.parseInt(read.nextLine());
            if(aviones.obtenerAvion(idAvion).isEmpty()) {
                System.out.println("\nEl avion con ese ID no está registrado");
                continue;
            }

            aeropuertos.imprimirAeropuertos();
            if(aeropuertos.getListaAeropuertos().size() == 0) continue;
            System.out.print("Ingresa el ID del aeropuerto de origen: ");
            int aeropuertoOrigen = Integer.parseInt(read.nextLine()) ;
            if(aeropuertos.obtenerAeropuerto(aeropuertoOrigen).isEmpty()) {
                System.out.println("\nEl avion con esa ID no está registrado");
                continue;
            }


            System.out.print("Ingresa el ID del aeropuerto de destino: ");
            int aeropuertoDestino = Integer.parseInt(read.nextLine());
            if(aeropuertos.obtenerAeropuerto(aeropuertoDestino).isEmpty()) {
                System.out.println("\nEl avión con esa ID no está registrado");
                continue;
            }

            pilotos.imprimirPilotos();
            if(pilotos.getListaPilotos().size() == 0) continue;

            System.out.print("Ingresa el piloto del vuelo: ");
            int idPiloto = Integer.parseInt(read.nextLine());

            System.out.print("Ingresa el día en el que se realizó el vuelo: ");
            int dia = Integer.parseInt(read.nextLine());
            System.out.print("Ingresa el mes en el que se realizó el vuelo: ");
            int mes = Integer.parseInt(read.nextLine());
            System.out.print("Ingresa el año en el que se realizó el vuelo: ");
            int anio = Integer.parseInt(read.nextLine());
            String fecha = dia + "/" + mes + "/" + anio;

            vuelos.agregarVuelo(idAvion,aeropuertoOrigen,aeropuertoDestino,idPiloto,fecha);

        }
    }



    public  void mostrarVuelosPorOrigen() {
        aeropuertos.imprimirAeropuertos();
        if(aeropuertos.getListaAeropuertos().size() == 0) return;
        System.out.print("Ingresa el ID del aeropuerto de origen: ");
        int idOrigen = Integer.parseInt(read.nextLine());
        ArrayList<Vuelo> vuelosOrigen = vuelos.getVueloPorOrigen(idOrigen);
        for(var vuelo: vuelosOrigen) System.out.println(vuelo);
    }

    public  void mostrarVuelosPorDestino() {
        aeropuertos.imprimirAeropuertos();
        if(aeropuertos.getListaAeropuertos().size() == 0) return;
        System.out.print("Ingresa el ID del aeropuerto de destino: ");
        int idDestino = Integer.parseInt(read.nextLine());
        ArrayList<Vuelo> vuelosDestino = vuelos.getVuelosPorDestino(idDestino);
        System.out.println(vuelosDestino.size());
        for(var vuelo: vuelosDestino) System.out.println(vuelo);
    }

    public void consultarAeroPorCiudad() {
        Set<String> ciudades = aeropuertos.getCiudades();
        int idx = 1;
        for(var ciudad : ciudades) {
            System.out.println(ciudad);
        }
        System.out.print("Ingresa el nombre de la ciudad: ");
        String ciudad = read.nextLine();
        ArrayList<Aeropuerto> aeropuertosCiudad = aeropuertos.getAeropuertoPorCiudad(ciudad);
        if(aeropuertosCiudad.size() == 0) {
            System.out.println("No hay ningún aeropuerto con esa ciudad"); return;
        }
        System.out.println("Estos son los aeropuertos que se encuentran en esa ciuadad: ");
        for(var aeropuerto: aeropuertosCiudad) {
            System.out.println(aeropuerto);
        }

    }

    private void mostrarMenu() {
        System.out.println("1: Dar de alta aviones y sus datos");
        System.out.println("2: Consultar aviones por tipo");
        System.out.println("3: Dar de alta pilotos");
        System.out.println("4: Dar de alta aeropuertos");
        System.out.println("5: Registrar vuelos");
        System.out.println("6: Consultar vuelos por origen");
        System.out.println("7: Consultar vuelos por destino");
        System.out.println("8: Consultar aeropuertos por ciudad");
        System.out.println("9: Salir");
        System.out.print("Elige la opción que deseas realizar: ");
    }




}
