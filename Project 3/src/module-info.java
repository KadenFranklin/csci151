module covid{

    requires javafx.fxml;
    requires javafx.controls;
    requires opencsv;
    requires java.desktop;
    exports covid.gui;
    opens covid.gui;

}