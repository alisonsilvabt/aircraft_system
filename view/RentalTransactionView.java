package view;

import java.text.SimpleDateFormat;
import java.util.List;

import model.RentalTransaction;

public class RentalTransactionView {
    // Método para exibir uma lista de transações de aluguel
    public void displayRentalTransactionList(List<RentalTransaction> rentalTransactionList) {
        System.out.println("List of Rental Transactions:");
        for (RentalTransaction rentalTransaction : rentalTransactionList) {
            System.out.println(rentalTransactionDetailsToString(rentalTransaction));
        }
    }

    // Método para exibir os detalhes de uma transação de aluguel específica
    public void displayRentalTransactionDetails(RentalTransaction rentalTransaction) {
        System.out.println("Rental Transaction Details:");
        System.out.println(rentalTransactionDetailsToString(rentalTransaction));
    }

    // Método utilitário para converter os detalhes de uma transação de aluguel em
    // uma string formatada
    private String rentalTransactionDetailsToString(RentalTransaction rentalTransaction) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return "Aircraft: " + rentalTransaction.getAircraft().getModel() +
                ", Rental Date: " + dateFormat.format(rentalTransaction.getRentalDate()) +
                ", Rental Duration (hours): " + rentalTransaction.getRentalDurationHours();
    }
}
