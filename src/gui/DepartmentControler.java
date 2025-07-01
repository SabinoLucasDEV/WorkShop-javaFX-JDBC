package gui;


import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entitys.Department;

public class DepartmentControler implements Initializable {
	
	@FXML
	public TableView<Department> tableView;
	

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

}
