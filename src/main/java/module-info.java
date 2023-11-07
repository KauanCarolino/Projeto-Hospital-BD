module com.example.dahospitalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
//    requires mysql.connector.j;

    opens com.example.dahospitalproject to javafx.fxml;
    exports interfaceFX; // Adicione a exportação do pacote interfaceFX
    exports com.example.dahospitalproject; // Se necessário, exporte o pacote principal
}
