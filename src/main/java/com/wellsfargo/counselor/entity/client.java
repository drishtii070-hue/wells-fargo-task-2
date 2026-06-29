package com.wellsfargo.counselor.entity;

public class client {
   package com.wellsfargo.counselor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

    @Entity
    public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long clientId;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        // Arrow from Client points back to FinancialAdvisor
        @ManyToOne
        @JoinColumn(name = "advisor_id", nullable = false)
        private Advisor advisor;

        // Constructor with all fields
        public Client(String firstName, String lastName, Advisor advisor) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.advisor = advisor;
        }

        // Default no-arg constructor required by JPA
        protected Client() {
        }

        // Getters and Setters
        public long getClientId() {
            return clientId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Advisor getAdvisor() {
            return advisor;
        }

        public void setAdvisor(Advisor advisor) {
            this.advisor = advisor;
        }
    }
}