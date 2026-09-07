import java.util.Scanner;

public class Main {

    // Main data structures
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();

    private static Scanner scanner;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            scanner = input;
            int choice;

            do {
                printMenu();
                choice = getIntInput("Enter your choice: ");

                switch (choice) {
                    case 1 -> addPatient();
                    case 2 -> searchPatient();
                    case 3 -> deletePatient();
                    case 4 -> patientBST.inOrderTraversal();
                    case 5 -> enqueuePatient();
                    case 6 -> dequeuePatient();
                    case 7 -> emergencyQueue.displayQueue();
                    case 8 -> addTreatmentRecord();
                    case 9 -> removeLastTreatment();
                    case 10 -> treatmentStack.displayStack();
                    case 11 -> addVisitToPatient();
                    case 12 -> removeVisitFromPatient();
                    case 13 -> searchVisitOfPatient();
                    case 14 -> displayPatientVisits();
                    case 0 -> System.out.println("Exiting system. Goodbye!");
                    default -> System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 0);
        }
    }

    // ---------- MENU ----------
    private static void printMenu() {
        System.out.println("\n===== HOSPITAL EMERGENCY MANAGEMENT SYSTEM =====");
        System.out.println("--- Patient Records (BST) ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. Search Patient by ID");
        System.out.println("3. Delete Patient by ID");
        System.out.println("4. Display All Patients (In-order)");
        System.out.println("--- Emergency Queue ---");
        System.out.println("5. Enqueue Patient (Add to Waiting Queue)");
        System.out.println("6. Dequeue Patient (Next for Treatment)");
        System.out.println("7. Display Waiting Queue");
        System.out.println("--- Treatment History (Stack) ---");
        System.out.println("8. Add Completed Treatment Record");
        System.out.println("9. Remove Last Treatment Record");
        System.out.println("10. Display Treatment Records");
        System.out.println("--- Patient Visit History (Linked List) ---");
        System.out.println("11. Add Visit to Patient");
        System.out.println("12. Remove Visit from Patient");
        System.out.println("13. Search Visit of Patient");
        System.out.println("14. Display Patient Visit History");
        System.out.println("0. Exit");
    }

    // ---------- PATIENT (BST) OPERATIONS ----------
    private static void addPatient() {
        int id = getIntInput("Enter Patient ID: ");
        String name = getStringInput("Enter Patient Name: ");
        int age = getIntInput("Enter Age: ");
        String contact = getStringInput("Enter Contact Number: ");
        String condition = getStringInput("Enter Medical Condition: ");

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient added successfully.");
    }

    private static void searchPatient() {
        int id = getIntInput("Enter Patient ID to search: ");
        Patient found = patientBST.search(id);

        if (found != null) {
            found.displayInfo();
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    private static void deletePatient() {
        int id = getIntInput("Enter Patient ID to delete: ");
        patientBST.delete(id);
    }

    // ---------- QUEUE OPERATIONS ----------
    private static void enqueuePatient() {
        int id = getIntInput("Enter Patient ID to add to queue: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found. Please add the patient first.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    private static void dequeuePatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient != null) {
        System.out.println(patient.getName() + " has been moved for treatment.");
        }
    }

    // ---------- STACK OPERATIONS ----------
    private static void addTreatmentRecord() {
        int treatmentId = getIntInput("Enter Treatment ID: ");
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        String details = getStringInput("Enter Treatment Details: ");
        String date = getStringInput("Enter Completion Date: ");

        Treatment treatment = new Treatment(treatmentId, patientId, patient.getName(), details, date);
        treatmentStack.push(treatment);
    }

    private static void removeLastTreatment() {
        treatmentStack.pop();
    }

    // ---------- VISIT HISTORY (LINKED LIST) OPERATIONS ----------
    private static void addVisitToPatient() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");
        String date = getStringInput("Enter Visit Date: ");
        String doctor = getStringInput("Enter Doctor Name: ");
        String diagnosis = getStringInput("Enter Diagnosis: ");
        String treatment = getStringInput("Enter Treatment: ");

        patient.getVisitHistory().addVisit(visitId, date, doctor, diagnosis, treatment);
    }

    private static void removeVisitFromPatient() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = getIntInput("Enter Visit ID to remove: ");
        patient.getVisitHistory().removeVisit(visitId);
    }

    private static void searchVisitOfPatient() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = getIntInput("Enter Visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        if (visit != null) {
            visit.displayInfo();
        } else {
            System.out.println("Visit ID " + visitId + " not found.");
        }
    }

    private static void displayPatientVisits() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.getVisitHistory().displayVisits();
    }

    // ---------- INPUT HELPER METHODS ----------
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();  // clear the newline character
        return value;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}