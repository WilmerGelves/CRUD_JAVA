package com.hexagonaljava.infrastructure.persistence.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexagonaljava.domain.entity.Client;
import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.infrastructure.database.ConnectionDb;

public class ClientRepositoryImpl implements ClientRespository {
    private final ConnectionDb connection;
    
    public ClientRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Client cliente) {
        String sql = "INSERT INTO client (id, name, email) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getId());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client buscarPorId(String id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("=======Resultado=======");
                System.out.println("|" + "ID del cliente: " + rs.getString("id"));
                System.out.println("|" + "Nombre: " + rs.getString("name"));
                System.out.println("|" + "Email : " + rs.getString("email"));
                System.out.println("=======================");
            }else{
                System.out.println("Id no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> listarTodos() {
        List<Client> client = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("|" + "ID: " + rs.getString("id") + " " + "|" + "Nombre: " + rs.getString("name") + " " + "|" + "Email: " + rs.getString("email")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void actualizar(Client cliente) {
        String sql = "UPDATE client SET name = ?, email = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM client WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}
