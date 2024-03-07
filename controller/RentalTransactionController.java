package controller;

import java.util.ArrayList;
import java.util.List;

import model.RentalTransaction;

public class RentalTransactionController {
    private List<RentalTransaction> rentalTransactionList;

    public RentalTransactionController() {
        // Inicializar a lista de transações de aluguel
        rentalTransactionList = new ArrayList<>();
    }

    // Método para adicionar uma nova transação de aluguel à lista
    public void addRentalTransaction(RentalTransaction rentalTransaction) {
        rentalTransactionList.add(rentalTransaction);
    }

    // Método para remover uma transação de aluguel da lista
    public void removeRentalTransaction(RentalTransaction rentalTransaction) {
        rentalTransactionList.remove(rentalTransaction);
    }

    // Método para obter todas as transações de aluguel da lista
    public List<RentalTransaction> getAllRentalTransactions() {
        return rentalTransactionList;
    }

    // Método para buscar transações de aluguel por aeronave
    public List<RentalTransaction> getRentalTransactionsByAircraft(String aircraftModel) {
        List<RentalTransaction> transactionsByAircraft = new ArrayList<>();
        for (RentalTransaction transaction : rentalTransactionList) {
            if (transaction.getAircraft().getModel().equalsIgnoreCase(aircraftModel)) {
                transactionsByAircraft.add(transaction);
            }
        }
        return transactionsByAircraft;
    }
}
