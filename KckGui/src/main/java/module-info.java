module com.example.kckgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.logging;
    requires MaterialFX;

    opens com.example.kckgui.Model.Class to javafx.base;

    exports com.example.kckgui;
    opens com.example.kckgui to javafx.base, javafx.fxml;
}