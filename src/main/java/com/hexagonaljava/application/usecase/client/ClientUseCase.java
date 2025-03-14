package com.hexagonaljava.application.usecase.client;

import java.util.List;

import com.hexagonaljava.domain.entity.Client;
import com.hexagonaljava.domain.repository.ClientRespository;

public class ClientUseCase {
    private final ClientRespository repository;

    public ClientUseCase(ClientRespository repository) {
        this.repository = repository;
    }

    public void registrarCliente(String id, String nombre, String email) {
        Client cliente = new Client(id, nombre, email);
        repository.guardar(cliente);
    }

    public Client obtenerCliente(String id) {
        return repository.buscarPorId(id);
    }

    public List<Client> listarClientes() {
        return repository.listarTodos();
    }

    public void actualizarCliente(String id, String nombre, String email) {
        Client cliente = new Client(id, nombre, email);
        repository.actualizar(cliente);
    }

    public void eliminarCliente(String id) {
        repository.eliminar(id);
    }
}
