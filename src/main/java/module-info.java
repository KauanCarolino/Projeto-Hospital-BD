module com.example.dahospitalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
//    requires mysql.connector.j;

    opens com.example.dahospitalproject to javafx.fxml;
    exports interfaceFX; // Adicione a exportação do pacote interfaceFX
    exports com.example.dahospitalproject; // Se necessário, exporte o pacote principal
}
