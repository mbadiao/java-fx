package com.example.gestion_java_fx.entity;

public class AssuranceHabitation extends    Assurance{
    private String adresse;
    private double superficie;
    private boolean zoneRisque;

    public AssuranceHabitation(Double montantCotisation, String nomClient) {
        super(montantCotisation, nomClient);
        this.adresse = adresse;
        this.zoneRisque = zoneRisque;
        this.superficie = superficie;
    }

    @Override
    public double calculPrime() {
        return montantCotisation * (1 + superficie/100) * (zoneRisque ? 1.3 : 1.5);
    }

    @Override
    public String getTypeAssurance() {
        return "entity.Assurance habitation";
    }

    @Override
    public String toString() {
        return "entity.AssuranceHabitation{" +
                "montantCotisation=" + montantCotisation +
                ", nomClient='" + nomClient + '\'' +
                ", numeroContrat='" + numeroContrat + '\'' +
                ", zoneRisque=" + zoneRisque +
                ", superficie=" + superficie +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
