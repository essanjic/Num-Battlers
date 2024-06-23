module org.example.numbattlers {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.google.gson;

    opens org.example.numbattlers to javafx.fxml;
    exports org.example.numbattlers;
    exports org.example.numbattlers.internal.entity;
    opens org.example.numbattlers.internal.entity to javafx.fxml;
    exports org.example.numbattlers.src.controller;
    opens org.example.numbattlers.src.controller to javafx.fxml;
}