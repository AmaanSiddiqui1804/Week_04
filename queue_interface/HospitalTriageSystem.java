/* Hospital Triage System
Simulate a hospital triage system using a PriorityQueue where patients with higher severity are treated first.
Example:
Patients: [("John", 3), ("Alice", 5), ("Bob", 2)] → Order: Alice, John, Bob.
 */
package com.queue_interface;

import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    // Constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}
public class HospitalTriageSystem {

    public static void main(String[] args) {
        PriorityQueue<Patient> p1 = new PriorityQueue<>((a, b) -> Integer.compare(b.severity, a.severity));

        //Adding patients to the priority queue
        p1.add(new Patient("Aman", 5));
        p1.add(new Patient("Aeram", 1));
        p1.add(new Patient("Billu", 2));
        p1.add(new Patient("Tikku", 3));

        System.out.println("Treatment Order:");
        while (!p1.isEmpty()) {
            Patient patient = p1.poll();
            System.out.println(patient);
        }
    }
}

