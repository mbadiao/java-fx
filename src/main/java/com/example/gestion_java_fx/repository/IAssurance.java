package com.example.gestion_java_fx.repository;

import com.example.gestion_java_fx.entity.Assurance;

import java.util.List;

public interface IAssurance {
    public List<Assurance> getAssurances();
    public void insertAssurance(Assurance assurance);
    public void deleteAssurance(int id);
    public Assurance getAssurance(int id);
    public void updateAssurance(Assurance assurance);
}
