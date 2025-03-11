package com.hexagonaljava.application.usecase.product;

import java.util.Scanner;
import com.hexagonaljava.application.usecase.client.MenuPrincipal;
//import com.hexagonaljava.application.usecase.client.ClientUseCase;
import com.hexagonaljava.application.usecase.product.ProductUseCase;
//import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.domain.repository.ProductRepository;
import com.hexagonaljava.infrastructure.database.ConnectionFactory;
//import com.hexagonaljava.infrastructure.persistence.client.ClientRepositoryImpl;
import com.hexagonaljava.infrastructure.persistence.product.ProductRepositoryImpl;

public class ProcesoProducto {
    public static void procesoCliente(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int opcion;
        String menuProductos = """
                                =========================
                                ||  Procesos Productos  ||
                                =========================
                                1. Crear producto.
                                2. Buscar producto.
                                3. Actualizar producto.
                                4. Eliminar producto.
                                5. Volver al menu anterior.
                                6. Listar productos.
                                7. Salir.
                                =========================
                               """;
        System.out.println(menuProductos);
        System.out.print("Seleccione una opcion\n->");
        opcion = sc.nextInt();
        while (opcion < 1 || opcion > 7) {
            System.out.print("Ingrese una opcion valida\n->");
            opcion = sc.nextInt();
        }
        switch (opcion) {
            case 1:
                sc.nextLine();//formateo del buffer 
                ProductRepository repositorio = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
                ProductUseCase productUseCase = new ProductUseCase(repositorio);
                System.out.print("Ingrese Nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese Stock: ");
                int stock = sc.nextInt();
                productUseCase.registrarproducto(nombre, stock);
                procesoCliente();
                break;
            case 2: 
                ProductRepository busqueda = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
                ProductUseCase busquedaCase = new ProductUseCase(busqueda);
                System.out.print("ID del producto: ");
                int id = sc.nextInt();
                System.out.println(busquedaCase.obtenerproducto(id)); 
                procesoCliente();
                break;
            case 3: 
                procesoCliente();
                break;
            case 4:
                procesoCliente();
                break;
            case 5:
                MenuPrincipal.menuCliente();
                break;
            case 6:
                procesoCliente();
                break;
            default:
                System.out.println("Ha salido del sistema.\nPor favor vuelva pronto.");
                break;
        }
        
    }
}
