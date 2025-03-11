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

@SuppressWarnings("unused")
public class ProcesoProducto {
    public static void procesoCliente(){
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
                                5. Listar productos.
                                6. Volver al menu anterior.
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
                System.out.print("Id del producto:");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Ingrese Nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese Stock: ");
                int stock = sc.nextInt();
                productUseCase.registrarproducto(id,nombre, stock);
                procesoCliente();
                break;
            case 2: 
                ProductRepository busqueda = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
                ProductUseCase busquedaCase = new ProductUseCase(busqueda);
                System.out.print("ID del producto: ");
                id = sc.nextInt();
                busquedaCase.obtenerproducto(id); 
                procesoCliente();
                break;
            case 3: 
                ProductRepository actualizar = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
                ProductUseCase procActualizar = new ProductUseCase(actualizar);
                System.out.print("ID del producto: ");
                id = sc.nextInt();
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                nombre = sc.nextLine();
                System.out.print("Nuevo stock: ");
                stock = sc.nextInt();
                procActualizar.actualizarproducto(id,nombre,stock);
                procesoCliente();
                break;
            case 4:
                ProductRepository eliminar = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
                ProductUseCase proDelete = new ProductUseCase(eliminar);
                System.out.print("Id del producto a eliminar: ");
                id = sc.nextInt();
                proDelete.eliminarproducto(id);
                procesoCliente();
                break;
            case 5:
                ProductRepository listar = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
                ProductUseCase proListar = new ProductUseCase(listar);
                proListar.listarproductos();
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
