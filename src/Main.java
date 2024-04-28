import com.romeulima.location.domain.carrental.CarRental;
import com.romeulima.location.domain.vehicle.Vehicle;
import com.romeulima.location.services.AccountService;
import com.romeulima.location.services.BrazilTaxService;
import com.romeulima.location.services.CarRentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Entre com o preço por hora: ");
        Double pricePerHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        Double pricePerDay = sc.nextDouble();

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        CarRentalService carRentalService = new CarRentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        carRentalService.processAccount(carRental);


        System.out.println("FATURA:");
        System.out.println("Pagamento básico: " + carRental.getAccount().getBasicPayment());
        System.out.println("Imposto: " + carRental.getAccount().getTax());
        System.out.println("Pagamento total: " + carRental.getAccount().getTotalPayment());

        sc.close();
    }
}