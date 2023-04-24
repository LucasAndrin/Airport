import Models.Airport;
import Models.Plane;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite true para continuar o programa e false para parar: ");
        boolean response = scanner.nextBoolean();
        while(response) {
            System.out.println("###################### TEMPO " + airport.time + " ######################");

            int landingQueue = random.nextInt(3);
            int takingOffQueue = random.nextInt(3);

            System.out.println("Aviões adicionados na fila de aterrisagem: " + landingQueue);
            for (int i = 0; i < landingQueue; i++) {
                Plane plane = airport.addPlaneLanding(random.nextInt(1, 20));
                System.out.println("    " + plane);
            }

            System.out.println("Aviões adicionados na fila de decolagem: " + takingOffQueue);
            for (int i = 0; i < takingOffQueue; i++) {
                Plane plane = airport.addPlaneTakingOff();
                System.out.println("    " + plane);
            }

            System.out.println("Primeira " + airport.getPrimaryTrack());
            System.out.println("Segunda " + airport.getSecondaryTrack());
            System.out.println();

            System.out.println("##################### Gerenciando Aeronaves #####################");
            airport.manageAirport();
            System.out.println("Primeira " + airport.getPrimaryTrack());
            System.out.println("Segunda " + airport.getSecondaryTrack());
            System.out.println();


            System.out.println("########### ?????? ###########");
            System.out.println("Digite true para continuar o programa e false para parar...");
            response = scanner.nextBoolean();
        }

        System.out.println("Expediente encerrado!");
    }
}