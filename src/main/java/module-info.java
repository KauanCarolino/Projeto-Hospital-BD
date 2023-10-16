module com.example.dahospitalproject {
    requires javafx.controls;
    requires javafx.fxml;
            
                        requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.dahospitalproject to javafx.fxml;
    exports com.example.dahospitalproject;
}