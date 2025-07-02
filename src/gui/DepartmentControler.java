package gui;


import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entitys.Department;
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
	public void onBtNewAction() {
		System.out.println("on button");
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

}
