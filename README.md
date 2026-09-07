# Mini Hospital Emergency Management System

## Overview
This is a console-based Java application that simulates a Mini Hospital Emergency 
Management System. It was developed as the Individual Mid Assignment for the module 
CIT300 - Data Structures and Algorithms.

The system manages patient registration, emergency treatment requests, treatment 
completion, and patient visit history using four core data structures.

## Data Structures Used

### 1. Binary Search Tree (BST) - Patient Records
Each patient is stored in a BST using Patient ID as the key. Supports:
- Insert a new patient
- Search a patient by ID
- Delete a patient
- In-order traversal (displays patients in ascending order of Patient ID)

### 2. Queue - Emergency Patient Queue
Patients waiting for emergency treatment are managed with a FIFO queue. Supports:
- Enqueue (add patient to waiting queue)
- Dequeue (remove next patient for treatment)
- Display all waiting patients
- Empty queue handling

### 3. Stack - Treatment History
Completed treatment records are stored using a LIFO stack. Supports:
- Push (add completed treatment record)
- Pop (remove most recent treatment record)
- Display all treatment records
- Empty stack handling

### 4. Singly Linked List - Patient Visit History
Each patient has a linked list containing their previous hospital visits. Supports:
- Add a new visit
- Remove a visit
- Search for a visit
- Display visit history

## Project Structure