import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.AircraftController;
import controller.RentalTransactionController;
import model.Aircraft;
import model.JetPlane;
import model.PropellerPlane;
import model.RentalTransaction;
import view.AircraftView;
import view.RentalTransactionView;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AircraftController aircraftController = new AircraftController();
    private static final RentalTransactionController rentalTransactionController = new RentalTransactionController();
    private static final AircraftView aircraftView = new AircraftView();
    private static final RentalTransactionView rentalTransactionView = new RentalTransactionView();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Menu ====");
            System.out.println("1. Cadastrar nova aeronave");
            System.out.println("2. Listar aeronaves disponíveis");
            System.out.println("3. Atualizar informações de uma aeronave");
            System.out.println("4. Excluir aeronave");
            System.out.println("5. Registrar transação de aluguel");
            System.out.println("6. Listar transações de aluguel");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    registerNewAircraft();
                    break;
                case 2:
                    listAvailableAircrafts();
                    break;
                case 3:
                    updateAircraft();
                    break;
                case 4:
                    deleteAircraft();
                    break;
                case 5:
                    registerRentalTransaction();
                    break;
                case 6:
                    listRentalTransactions();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
        System.out.println("Sistema encerrado.");
    }

private static void registerNewAircraft() {
    System.out.println("=== Cadastro de Nova Aeronave ===");
    System.out.print("Modelo: ");
    String model = scanner.nextLine();
    System.out.print("Fabricante: ");
    String manufacturer = scanner.nextLine();
    System.out.print("Ano de Fabricação: ");
    int year = scanner.nextInt();
    System.out.print("Capacidade de Passageiros: ");
    int capacity = scanner.nextInt();
    System.out.print("Autonomia de Voo(Km): ");
    int autonomy = scanner.nextInt();
    System.out.print("Preço por Hora de Voo(R$): ");
    double pricePerHour = scanner.nextDouble();

    // Exibir opções de tipo de aeronave
    System.out.println("Selecione o tipo de aeronave:");
    System.out.println("1. Avião a Jato");
    System.out.println("2. Avião a Hélice");
    System.out.print("Opção: ");
    int option = scanner.nextInt();
    scanner.nextLine(); 

    Aircraft newAircraft;
    switch (option) {
        case 1:
            System.out.println("Digite a velocidade máxima do avião: ");
            int fast = scanner.nextInt();
            scanner.nextLine();
            newAircraft = new JetPlane(model, manufacturer, year, capacity, autonomy, pricePerHour, fast);
            break;
        case 2:
            System.out.println("Digite a altitude máxima do avião: ");
            int maxAltitude = scanner.nextInt();
            scanner.nextLine();
            newAircraft = new PropellerPlane(model, manufacturer, year, capacity, autonomy, pricePerHour, maxAltitude);
            break;
        default:
            System.out.println("Opção inválida. Aeronave cadastrada como Avião Genérico.");
            newAircraft = new Aircraft(model, manufacturer, year, capacity, autonomy, pricePerHour);
            break;
        }
    aircraftController.addAircraft(newAircraft);    
    }


    private static void listAvailableAircrafts() {
        System.out.println("=== Aeronaves Disponíveis ===");
        List<Aircraft> aircraftList = aircraftController.getAllAircraft();
        aircraftView.displayAircraftList(aircraftList);
    }

    private static void updateAircraft() {
        System.out.println("=== Atualização de Aeronave ===");
        System.out.print("Informe o ID da aeronave que deseja atualizar: ");
        int aircraftId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        Aircraft aircraftToUpdate = aircraftController.getAircraftById(aircraftId);
        if (aircraftToUpdate == null) {
            System.out.println("Aeronave não encontrada.");
            return;
        }

        System.out.print("Novo preço por hora de voo: ");
        double newPricePerHour = scanner.nextDouble();
        aircraftToUpdate.setPricePerHour(newPricePerHour);
        aircraftController.updateAircraft(aircraftToUpdate);
        System.out.println("Informações da aeronave atualizadas com sucesso.");
    }

    private static void deleteAircraft() {
        System.out.println("=== Exclusão de Aeronave ===");
        System.out.print("Informe o ID da aeronave que deseja excluir: ");
        int aircraftId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        Aircraft aircraftToDelete = aircraftController.getAircraftById(aircraftId);
        if (aircraftToDelete == null) {
            System.out.println("Aeronave não encontrada.");
            return;
        }

        aircraftController.deleteAircraft(aircraftToDelete);
        System.out.println("Aeronave excluída com sucesso.");
    }

    private static void registerRentalTransaction() {
        System.out.println("=== Registro de Transação de Aluguel ===");

        // Listar todas as aeronaves disponíveis
        System.out.println("Aeronaves disponíveis para aluguel:");
        List<Aircraft> aircraftList = aircraftController.getAllAircraft();
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.getId() + ". " + aircraft.getModel());
        }

        // Solicitar ao usuário que escolha uma aeronave
        System.out.print("Escolha o ID da aeronave a ser alugada: ");
        int aircraftId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        // Verificar se a aeronave escolhida existe
        Aircraft aircraft = aircraftController.getAircraftById(aircraftId);
        if (aircraft == null) {
            System.out.println("Aeronave não encontrada.");
            return;
        }

        scanner.nextLine();
        System.out.print("Data do aluguel (formato yyyy-MM-dd HH:mm): ");
        String rentalDateStr = scanner.nextLine();

        Date rentalDate;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            rentalDate = sdf.parse(rentalDateStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato yyyy-MM-dd HH:mm.");
            return;
        }
        
        System.out.print("Duração do aluguel (em horas): ");
        int rentalDurationHours = scanner.nextInt();
        scanner.nextLine();



        RentalTransaction rentalTransaction = new RentalTransaction(aircraft, rentalDate, rentalDurationHours);
        rentalTransactionController.addRentalTransaction(rentalTransaction);
        System.out.println("Transação de aluguel registrada com sucesso.");
    }

    private static void listRentalTransactions() {
        System.out.println("=== Transações de Aluguel ===");
        List<RentalTransaction> rentalTransactionList = rentalTransactionController.getAllRentalTransactions();
        rentalTransactionView.displayRentalTransactionList(rentalTransactionList);
    }
}
