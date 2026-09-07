public class Treatment {
    private int treatmentId;
    private int patientId;
    private String patientName;
    private String treatmentDetails;
    private String completionDate;

    public Treatment(int treatmentId, int patientId, String patientName, String treatmentDetails, String completionDate) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.completionDate = completionDate;
    }

    // Getters
    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    // Display treatment info
    public void displayInfo() {
        System.out.println("Treatment ID: " + treatmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Treatment: " + treatmentDetails);
        System.out.println("Completed On: " + completionDate);
    }
}