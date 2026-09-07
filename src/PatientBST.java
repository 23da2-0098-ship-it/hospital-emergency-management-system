public class PatientBST {

    // BST Node - holds a Patient object
    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public PatientBST() {
        this.root = null;
    }

    // ---------- INSERT ----------
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node current, Patient patient) {
        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRec(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRec(current.right, patient);
        } else {
            System.out.println("Patient ID " + patient.getPatientId() + " already exists.");
        }

        return current;
    }

    // ---------- SEARCH ----------
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Node current, int patientId) {
        if (current == null) {
            return null;   // not found
        }

        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        } else if (patientId < current.patient.getPatientId()) {
            return searchRec(current.left, patientId);
        } else {
            return searchRec(current.right, patientId);
        }
    }

    // ---------- DELETE ----------
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node current, int patientId) {
        if (current == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRec(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRec(current.right, patientId);
        } else {
            // This is the node to be deleted

            // Case 1: no children (leaf node)
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only one child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Case 3: two children
            // Find the smallest value in the right subtree (inorder successor)
            Node successor = findMin(current.right);
            current.patient = successor.patient;
            current.right = deleteRec(current.right, successor.patient.getPatientId());
        }

        return current;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // ---------- IN-ORDER TRAVERSAL ----------
    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);       // visit left subtree first
            current.patient.displayInfo();  // then print current node
            System.out.println("-----------------------");
            inOrderRec(current.right);      // then visit right subtree
        }
    }
}