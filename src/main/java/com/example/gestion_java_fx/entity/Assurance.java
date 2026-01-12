package com.example.gestion_java_fx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assurance")
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "numero")
    protected String numeroContrat;

    @Column(name = "nom")
    protected String nomClient;

    @Column(name = "montant")
    protected Double montantCotisation;

    private static int compteur = 0;

    public Assurance() {
    }

    public Assurance(Double montantCotisation, String nomClient) {
        this.montantCotisation = montantCotisation;
        this.nomClient = nomClient;
        this.numeroContrat = generateNumero();
    }

    public Assurance(int id, String numeroContrat, String nomClient, Double montantCotisation) {
        this.id = id;
        this.numeroContrat = numeroContrat;
        this.nomClient = nomClient;
        this.montantCotisation = montantCotisation;
    }

    private String generateNumero(){
        return String.format("ASS%04d", compteur++);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Double getMontantCotisation() {
        return montantCotisation;
    }

    public void setMontantCotisation(Double montantCotisation) {
        this.montantCotisation = montantCotisation;
    }

    public double calculPrime(){
        return 0;
    };
    public  String getTypeAssurance(){
        return "Assurance";
    };


    public double calculerCoutTotal(int nbAnnees){
        return nbAnnees * calculPrime() ;
    }

    @Override
    public String toString() {
        return "entity.Assurance{" +
                "numeroContrat='" + numeroContrat + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", montantCotisation=" + montantCotisation +
                '}';
    }
    public static  int getNombreContrats(){

        return compteur;
    }
}
