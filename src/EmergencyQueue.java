public class EmergencyQueue {

    // Node for the queue (linked list based queue)
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;   // front of the queue (next to be dequeued)
    private Node rear;    // rear of the queue (last added patient)

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    // ---------- ENQUEUE ----------
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        if (rear == null) {
            // queue is empty, this is the first patient
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Patient " + patient.getName() + " added to the waiting queue.");
    }

    // ---------- DEQUEUE ----------
    public Patient dequeue() {
        if (front == null) {
            System.out.println("Queue is empty. No patients waiting.");
            return null;
        }

        Patient dequeuedPatient = front.patient;
        front = front.next;

        if (front == null) {
            // queue became empty after removing the last node
            rear = null;
        }

        System.out.println("Patient " + dequeuedPatient.getName() + " removed for treatment.");
        return dequeuedPatient;
    }

    // ---------- DISPLAY ----------
    public void displayQueue() {
        if (front == null) {
            System.out.println("No patients waiting in the queue.");
            return;
        }

        Node current = front;
        System.out.println("Patients waiting:");
        while (current != null) {
            current.patient.displayInfo();
            System.out.println("-----------------------");
            current = current.next;
        }
    }

    // ---------- CHECK EMPTY ----------
    public boolean isEmpty() {
        return front == null;
    }
}