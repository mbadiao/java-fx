package com.example.gestion_java_fx.enumeration;

public enum AssuranceEnum {
    habitat("entity.Assurance Habitation"),
    Auto("entity.Assurance auto");

    public String label;
    AssuranceEnum(String label) {
        this.label = label;
    }
}
