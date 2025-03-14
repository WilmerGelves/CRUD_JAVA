package com.hexagonaljava;

import java.util.Scanner;
import com.hexagonaljava.application.usecase.client.MenuPrincipal;
//import com.hexagonaljava.application.usecase.client.ClientUseCase;
import com.hexagonaljava.application.usecase.product.ProductUseCase;
//import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.domain.repository.ProductRepository;
import com.hexagonaljava.infrastructure.database.ConnectionFactory;
//import com.hexagonaljava.infrastructure.persistence.client.ClientRepositoryImpl;
import com.hexagonaljava.infrastructure.persistence.product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal.menuCliente();
        
        //ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        //ClientUseCase clienteCasoUso = new ClientUseCase(repositorio);
       /*  try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingrese ID del Cliente: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea
            System.out.print("Ingrese Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese Email: ");
            String email = sc.nextLine();
            clienteCasoUso.registrarCliente(id, nombre, email);
            System.out.println("✅ Cliente registrado exitosamente.");        
        }*/

        //PRUEBA DE CONEXIÓN 
       /*
       ProductRepository repositorio = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        ProductUseCase productUseCase = new ProductUseCase(repositorio);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingrese Nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese Stock: ");
            int stock = sc.nextInt();
            productUseCase.registrarproducto(nombre, stock);
            System.out.println("Cliente registrado exitosamente.");        
        }
       */ 
    }
}