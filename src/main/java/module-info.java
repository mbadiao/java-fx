module com.example.gestion_java_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.example.gestion_java_fx.entity;
    opens com.example.gestion_java_fx to javafx.fxml;
    exports com.example.gestion_java_fx;
}
