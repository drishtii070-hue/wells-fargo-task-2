package com.wellsfargo.counselor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    // Arrow from Portfolio points to Client (Many Portfolios can belong to one Client, or a basic relationship mapping)
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // Constructor initializing all instance variables (Requirement 4.4)
    public Portfolio(Client client) {
        this.client = client;
    }

    // Default no-arg constructor required by JPA (Requirement 4.4)
    protected Portfolio() {
    }

    // Getters and Setters (Requirement 4.5 - Omit setter for portfolioId)
    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
