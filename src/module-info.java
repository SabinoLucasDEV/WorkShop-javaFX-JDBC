module WorkShop_JDBC_JAVAFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	 exports gui;
	 opens model.entitys;
	
	opens application to javafx.graphics, javafx.fxml;
}
