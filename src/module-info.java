module WorkShop_JDBC_JAVAFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	 exports gui;
	 
	 
	 opens model.entities;
	opens application to javafx.graphics, javafx.fxml;
}
