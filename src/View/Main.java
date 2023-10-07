package View;



import Controller.DoctorController;
import Controller.Validate;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DoctorController doctorController = new DoctorController();

    public static void main(String[] args) {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    doctorController.addDoctor();
                    break;
                case 2:
                    doctorController.updateDoctor();
                    break;
                case 3:
                    doctorController.deleteDoctor();
                    break;
                case 4:
                    doctorController.searchDoctor();
                    break;
                case 5:
                    doctorController.displayAllDoctors();
                    break;
                case 6:
                    return;
            }
        }
    }

    public static int menu() {
        System.out.println("========== Doctor Management System ==========");
        System.out.println("||1. Add Doctor                             ||");
        System.out.println("||2. Update Doctor                          ||");
        System.out.println("||3. Delete Doctor                          ||");
        System.out.println("||4. Search Doctor                          ||");
        System.out.println("||5. Display All Doctors                    ||");
        System.out.println("||6. Exit                                   ||");
        System.out.println("==============================================");
        System.out.print("Enter your choice: ");
        return Validate.checkInputIntLimit(1, 6);
    }
}
