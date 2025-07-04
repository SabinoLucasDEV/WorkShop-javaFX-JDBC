package gui;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.service.DepartmentService;

public class DepartmentControler implements Initializable {
	
	private DepartmentService service;
	
	@FXML
	public TableView<Department> tableView;
	
	private ObservableList<Department> obsList;
	
	@FXML
	public TableColumn<Department, Integer> tableCollumId;
	

	@FXML
	public TableColumn<Department, String> tableCollumName;
	
	@FXML
	public Button btNew;
	
	@FXML
	public void onBtNewAction(ActionEvent event ) {
		Stage parentStage = Utils.curretStage(event);
		createDialogForm("DepartmentForm.fxml", parentStage );
	}
	
	public void setDepartmentService(DepartmentService  service) {
		this.service = service;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNode();
		
	}

	private void initializeNode() {
	    tableCollumId.setCellValueFactory(new PropertyValueFactory<>("id"));
	    tableCollumName.setCellValueFactory(new PropertyValueFactory<>("name"));
	    
	    Stage stage = (Stage)Main.getMainScene().getWindow();
	    tableView.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("service was null");
			
		}
		
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableView.setItems(obsList);
	}
	
	private void createDialogForm(String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Department data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
