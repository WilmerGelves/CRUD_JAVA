package com.hexagonaljava.application.usecase.client;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.product.ProcesoProducto;

public class MenuPrincipal {
    public static void menuCliente(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        String mensaje = """
                =======================
                ||   Menu Principal  ||
                =======================
                1.Procesos de Productos.
                2.Porcesos de Cliente.
                3.Salir
                =======================
                """
                ;
            System.out.print(mensaje);
            System.out.print("Seleccione una opcion\n->");
            opcion = sc.nextInt();
            while (opcion <1 || opcion >3) {
                System.out.print("Debe ingresar un valor correcto\n Intente nuevamente\n->");
                opcion = sc.nextInt();
            }
            switch (opcion) {
                case 1:
                    ProcesoProducto.procesoCliente();
                    break;
                case 2:
                break;
            
                default:
                    System.out.println("Ha salido del sistema.\nPor favor vuelva pronto.");
                    break;
            }
    }
}
