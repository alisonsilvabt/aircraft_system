package view;

import java.util.List;

import model.Client;


//iria ser usada, mas foi despriorizada por má gestão de tempo
public class ClientView {
    public void displayClientList(List<Client> clientList) {
        System.out.println("List of Clients:");
        for (Client client : clientList) {
            System.out.println(clientDetailsToString(client));
        }
    }

    public void displayClientDetails(Client client) {
        System.out.println("Client Details:");
        System.out.println(clientDetailsToString(client));
    }

    private String clientDetailsToString(Client client) {
        return "Name: " + client.getName() +
                ", Email: " + client.getEmail() +
                ", Phone Number: " + client.getPhoneNumber();
    }
}
