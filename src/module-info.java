module WorkShop_JDBC_JAVAFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	 exports gui;
	
	opens application to javafx.graphics, javafx.fxml;
}
