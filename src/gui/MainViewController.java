package gui;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	@FXML
	public MenuItem menuItemSeller;
	@FXML
	public MenuItem menuItemDepartment;
	@FXML
	public MenuItem menuItemAbout;
	
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartmentAction");
	}
	
	public void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
