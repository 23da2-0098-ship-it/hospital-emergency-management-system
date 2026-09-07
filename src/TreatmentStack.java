public class TreatmentStack {

    // Node for the stack (linked list based stack)
    private class Node {
        Treatment treatment;
        Node next;

        Node(Treatment treatment) {
            this.treatment = treatment;
            this.next = null;
        }
    }

    private Node top;   // top of the stack (most recently added treatment)

    public TreatmentStack() {
        this.top = null;
    }

    // ---------- PUSH ----------
    public void push(Treatment treatment) {
        Node newNode = new Node(treatment);
        newNode.next = top;   // new node points to the current top
        top = newNode;        // new node becomes the top

        System.out.println("Treatment record for Patient " + treatment.getPatientName() + " added.");
    }

    // ---------- POP ----------
    public Treatment pop() {
        if (top == null) {
            System.out.println("No treatment records available. Stack is empty.");
            return null;
        }

        Treatment poppedTreatment = top.treatment;
        top = top.next;   // move top pointer to the next node

        System.out.println("Treatment record for Patient " + poppedTreatment.getPatientName() + " removed.");
        return poppedTreatment;
    }

    // ---------- DISPLAY ----------
    public void displayStack() {
        if (top == null) {
            System.out.println("No treatment records available.");
            return;
        }

        Node current = top;
        System.out.println("Treatment records (most recent first):");
        while (current != null) {
            current.treatment.displayInfo();
            System.out.println("-----------------------");
            current = current.next;
        }
    }

    // ---------- CHECK EMPTY ----------
    public boolean isEmpty() {
        return top == null;
    }
}