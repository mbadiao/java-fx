package com.example.gestion_java_fx.entity;

public class AssanceAutomobile extends  Assurance{
    private String immatriculation ;
    private int puissanceFiscale ;
    private int bonusMalus ;



    public AssanceAutomobile(Double montantCotisation, String nomClient) {
        super(montantCotisation, nomClient);
        this.immatriculation = immatriculation ;
        this.puissanceFiscale = puissanceFiscale;
        this.bonusMalus = bonusMalus;
    }

    public AssanceAutomobile(int id, String numeroContrat, String nomClient, Double montantCotisation) {
        super(id, numeroContrat, nomClient, montantCotisation);
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getPuissanceFiscale() {
        return puissanceFiscale;
    }

    public void setPuissanceFiscale(int puissanceFiscale) {
        this.puissanceFiscale = puissanceFiscale;
    }

    public int getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(int bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    @Override
    public double calculPrime() {
        return montantCotisation * (1 + puissanceFiscale * 0.05 ) * (bonusMalus/100);
    }

    @Override
    public String getTypeAssurance() {
        return "entity.Assurance auto";
    }

    @Override
    public String toString() {
        return "entity.AssuranceAutomobile{" +
                "montantCotisation=" + montantCotisation +
                ", nomClient='" + nomClient + '\'' +
                ", numeroContrat='" + numeroContrat + '\'' +
                ", bonusMalus=" + bonusMalus +
                ", puissanceFiscale=" + puissanceFiscale +
                ", immatriculation='" + immatriculation + '\'' +
                '}';
    }
}
