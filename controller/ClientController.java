package controller;

import java.util.ArrayList;
import java.util.List;

import model.Client;

//iria ser usada, mas foi despriorizada por má gestão de tempo
public class ClientController {
    private List<Client> clientList;

    public ClientController() {
        // Inicializar a lista de clientes
        clientList = new ArrayList<>();
    }

    // Método para adicionar um novo cliente à lista
    public void addClient(Client client) {
        clientList.add(client);
    }

    // Método para remover um cliente da lista
    public void removeClient(Client client) {
        clientList.remove(client);
    }

    // Método para obter todos os clientes da lista
    public List<Client> getAllClients() {
        return clientList;
    }

    // Método para buscar um cliente pelo nome
    public Client getClientByName(String name) {
        for (Client client : clientList) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    // Método para atualizar informações de um cliente existente
    public void updateClient(Client client, String name, String email, String phoneNumber) {
        // Verificar se o cliente está na lista
        if (clientList.contains(client)) {
            // Atualizar as informações do cliente
            client.setName(name);
            client.setEmail(email);
            client.setPhoneNumber(phoneNumber);
        }
    }
}
