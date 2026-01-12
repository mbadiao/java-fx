package com.example.gestion_java_fx;

import com.example.gestion_java_fx.entity.Assurance;
import com.example.gestion_java_fx.repository.impl.AssuranceRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    private AssuranceRepository assuranceRepository;
    private ObservableList<Assurance> masterData;
    private FilteredList<Assurance> filteredData;

    @FXML
    private Button bt_add;

    @FXML
    private Button bt_clear;

    @FXML
    private Button bt_delete;

    @FXML
    private Button bt_update;

    @FXML
    private TableColumn<?, ?> nom_tab;

    @FXML
    private TableColumn<?, ?> numero_tab;

    @FXML
    private TableView<Assurance> tab;

    @FXML
    private TableColumn<?, ?> id_tab;

    @FXML
    private TableColumn<?, ?> montant_tab;

    @FXML
    private TextField momtant_input;

    @FXML
    private TextField nom_input;

    @FXML
    private TextField search_input;

    public HelloController() {
        assuranceRepository = new AssuranceRepository();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupTable();
        getALLAssurance();
        setupSearch();
        Onclick();
    }

    void setupTable() {
        id_tab.setCellValueFactory(new PropertyValueFactory<>("id"));
        numero_tab.setCellValueFactory(new PropertyValueFactory<>("numeroContrat"));
        nom_tab.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
        montant_tab.setCellValueFactory(new PropertyValueFactory<>("montantCotisation"));
    }

    void setupSearch() {
        search_input.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(assurance -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (assurance.getNomClient().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                if (assurance.getNumeroContrat().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
    }

    public void addAssurance(ActionEvent actionEvent) {
        Assurance assurance = new Assurance(Double.parseDouble(momtant_input.getText()), nom_input.getText());
        assuranceRepository.insert(assurance);
        getALLAssurance();
        clearInterface(actionEvent);
    }

    public void updateAssurance(ActionEvent actionEvent) {
        Assurance assurance = tab.getSelectionModel().getSelectedItem();
        if (assurance != null) {
            assurance.setNomClient(nom_input.getText());
            assurance.setMontantCotisation(Double.parseDouble(momtant_input.getText()));
            assuranceRepository.update(assurance);
            getALLAssurance();
        }
    }

    public void deleteAssurance(ActionEvent actionEvent) {
        Assurance selected = tab.getSelectionModel().getSelectedItem();
        if (selected != null) {
            assuranceRepository.delete(selected.getId());
            getALLAssurance();
        }
    }

    public void clearInterface(ActionEvent actionEvent) {
        momtant_input.clear();
        nom_input.clear();
    }

    void getALLAssurance() {
        masterData = assuranceRepository.getAll();
        filteredData = new FilteredList<>(masterData, p -> true);
        tab.setItems(filteredData);
    }

    void Onclick() {
        tab.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                Assurance assurance = tab.getSelectionModel().getSelectedItem();
                if (assurance != null) {
                    nom_input.setText(assurance.getNomClient());
                    momtant_input.setText(String.valueOf(assurance.getMontantCotisation()));
                }
            }
        });
    }
}
