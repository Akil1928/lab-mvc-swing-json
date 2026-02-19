module edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;

    opens edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model to com.fasterxml.jackson.databind;
    exports edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson;
}