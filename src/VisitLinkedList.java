public class VisitLinkedList {
    private Visit head;   

    public VisitLinkedList() {
        this.head = null;
    }

    // Add a new visit 
    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        Visit newVisit = new Visit(visitId, visitDate, doctorName, diagnosis, treatment);

        if (head == null) {
            head = newVisit;
        } else {
            Visit current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newVisit);
        }
        System.out.println("Visit added successfully.");
    }

    // Remove a visit by visitId
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history to remove from.");
            return;
        }

        // if head itself needs removing
        if (head.getVisitId() == visitId) {
            head = head.getNext();
            System.out.println("Visit removed successfully.");
            return;
        }

        Visit current = head;
        while (current.getNext() != null) {
            if (current.getNext().getVisitId() == visitId) {
                current.setNext(current.getNext().getNext());
                System.out.println("Visit removed successfully.");
                return;
            }
            current = current.getNext();
        }

        System.out.println("Visit ID " + visitId + " not found.");
    }

    // Search for a visit by visitId
    public Visit searchVisit(int visitId) {
        Visit current = head;
        while (current != null) {
            if (current.getVisitId() == visitId) {
                return current;
            }
            current = current.getNext();
        }
        return null;   
    }

    // Display all visits
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        Visit current = head;
        while (current != null) {
            current.displayInfo();
            System.out.println("-----------------------");
            current = current.getNext();
        }
    }
}