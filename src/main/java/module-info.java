module com.example.simulacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.simulacion to javafx.fxml;
    exports com.example.simulacion;
}