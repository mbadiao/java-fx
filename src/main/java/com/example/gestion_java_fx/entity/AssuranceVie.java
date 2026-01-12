package com.example.gestion_java_fx.entity;

public class AssuranceVie extends Assurance{
    private int ageAssure;
    private double capitalGaranti;
    private String beneficiaire;
    public AssuranceVie(Double montantCotisation, String nomClient , int ageAssure , double capitalGaranti , String beneficiaire) {
        super(montantCotisation, nomClient);
        this.ageAssure = ageAssure;
        this.capitalGaranti = capitalGaranti;
        this.beneficiaire = beneficiaire;
    }
    @Override
    public double calculPrime() {
        return getMontantCotisation() * (1 + ageAssure/100 ) * (capitalGaranti/100);
    }

    @Override
    public String getTypeAssurance() {
        return "entity.Assurance vie";
    }

    @Override
    public String toString() {
        return "entity.AssuranceVie{" +
                "montantCotisation=" + montantCotisation +
                ", nomClient='" + nomClient + '\'' +
                ", numeroContrat='" + numeroContrat + '\'' +
                ", beneficiaire='" + beneficiaire + '\'' +
                ", capitalGaranti=" + capitalGaranti +
                ", ageAssure=" + ageAssure +
                '}';
    }
}
