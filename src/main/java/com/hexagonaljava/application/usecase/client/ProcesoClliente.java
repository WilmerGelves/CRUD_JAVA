package com.hexagonaljava.application.usecase.client;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.client.MenuPrincipal;
import com.hexagonaljava.application.usecase.client.ClientUseCase;
import com.hexagonaljava.application.usecase.product.ProductUseCase;
import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.domain.repository.ProductRepository;
import com.hexagonaljava.infrastructure.database.ConnectionFactory;
import com.hexagonaljava.infrastructure.persistence.client.ClientRepositoryImpl;
import com.hexagonaljava.infrastructure.persistence.product.ProductRepositoryImpl;

public class ProcesoClliente {
    public static void procesoCliente(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        String menuCliente = """
                                =========================
                                ||   Procesos Cliente  ||
                                =========================
                                1. Registrar cliente.
                                2. Buscar cliente.
                                3. Actualizar datos del cliente.
                                4. Eliminar cliente.
                                5. Listar clientes.
                                6. Volver al menu anterior.
                                7. Salir.
                                =========================
                               """;
        System.out.println(menuCliente);
        System.out.print("Seleccione una opcion\n->");
        opcion = sc.nextInt();
        while (opcion < 1 || opcion > 7) {
            System.out.print("Ingrese una opcion valida\n->");
            opcion = sc.nextInt();
        }
        switch (opcion) {
            case 1:
                sc.nextLine();//formateo del buffer 
                ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
                ClientUseCase clienteCasoUso = new ClientUseCase(repositorio);
                System.out.print("Ingrese ID del Cliente: ");
                String id = sc.nextLine();
                System.out.print("Ingrese Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese Email: ");
                String email = sc.nextLine();
                clienteCasoUso.registrarCliente(id, nombre, email);   
                procesoCliente();   
                break;
            case 2: 
            sc.nextLine();
                ClientRespository  busqueda = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
                ClientUseCase busquedaCase = new ClientUseCase(busqueda);
                System.out.print("ID del cliente: ");
                id = sc.nextLine();
                busquedaCase.obtenerCliente(id); 
                procesoCliente();
                break;
            case 3: 
                sc.nextLine();
                ClientRespository actualizar = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
                ClientUseCase procActualizar = new ClientUseCase(actualizar);
                System.out.print("ID del cliente: ");
                id = sc.nextLine();
                System.out.print("Nuevo nombre: ");
                nombre = sc.nextLine();
                System.out.print("Nuevo email: ");
                email = sc.nextLine();
                procActualizar.actualizarCliente(id, nombre, email);
                procesoCliente();
                break;
            case 4:
                sc.nextLine();
                ClientRespository  eliminar = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
                ClientUseCase proDelete = new ClientUseCase(eliminar);
                System.out.print("Id del cliente que desea eliminar: ");
                id = sc.nextLine();
                proDelete.eliminarCliente(id);
                procesoCliente();
                break;
            case 5:
                ClientRespository listar = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
                ClientUseCase proListar = new ClientUseCase(listar);
                proListar.listarClientes();
                procesoCliente();
                break;
            case 6:
                MenuPrincipal.menuCliente();
                break;
            default:
                System.out.println("Ha salido del sistema.\nPor favor vuelva pronto.");
                break;
        }
       sc.close(); 
    }
}
