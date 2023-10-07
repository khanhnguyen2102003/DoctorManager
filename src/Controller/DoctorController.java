package Controller;


import Model.Doctor;
import Controller.Validate;

import java.util.ArrayList;

public class DoctorController {
    private final ArrayList<Doctor> doctorList = new ArrayList<>();

    public void addDoctor() {
        System.out.println("Enter Doctor Information:");
        System.out.print("Code: ");
        String code = Validate.checkInputString();
        if (!Validate.checkCodeExist(doctorList, code)) {
            System.out.println("Code already exists.");
            return;
        }

        System.out.print("Name: ");
        String name = Validate.checkInputString();
        System.out.print("Specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Availability: ");
        int availability = Validate.checkInputIntLimit(0, Integer.MAX_VALUE);

        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctorList.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    public void updateDoctor() {
        System.out.print("Enter the code of the doctor to update: ");
        String code = Validate.checkInputString();
        int index = findDoctorIndex(code);

        if (index == -1) {
            System.out.println("Doctor not found.");
            return;
        }

        Doctor currentDoctor = doctorList.get(index);

        System.out.println("Current Information:");
        System.out.println(currentDoctor);

        System.out.println("Enter new information:");

        System.out.print("Name: ");
        String name = Validate.checkInputString();
        System.out.print("Specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Availability: ");
        int availability = Validate.checkInputIntLimit(0, Integer.MAX_VALUE);

        Doctor updatedDoctor = new Doctor(code, name, specialization, availability);
        doctorList.set(index, updatedDoctor);

        System.out.println("Doctor information updated successfully.");
    }

    public void deleteDoctor() {
        System.out.print("Enter the code of the doctor to delete: ");
        String code = Validate.checkInputString();
        int index = findDoctorIndex(code);

        if (index == -1) {
            System.out.println("Doctor not found.");
            return;
        }

        doctorList.remove(index);
        System.out.println("Doctor deleted successfully.");
    }

    public void searchDoctor() {
        System.out.print("Enter the code of the doctor to search: ");
        String code = Validate.checkInputString();
        int index = findDoctorIndex(code);

        if (index == -1) {
            System.out.println("Doctor not found.");
        } else {
            System.out.println("Doctor found:");
            System.out.println(doctorList.get(index));
        }
    }

    public void displayAllDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors in the list.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doctor : doctorList) {
                System.out.println(doctor);
            }
        }
    }

    private int findDoctorIndex(String code) {
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
}
