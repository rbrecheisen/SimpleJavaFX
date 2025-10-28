package org.example;

import org.example.experiments.Experiment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        List<Button> buttons = new ArrayList<>();
        buttons.add(new Button("Show alert"));
        buttons.add(new Button("Run experiment"));

        buttons.get(0).setOnAction(e -> {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                    javafx.scene.control.Alert.AlertType.INFORMATION,
                    "You clicked the alert button!"
            );
            alert.showAndWait();
        });

        buttons.get(1).setOnAction(e -> {
            Experiment experiment = new Experiment();
            experiment.run();
        });

        for(Button button : buttons) {
            button.setMaxWidth(Double.MAX_VALUE);
        }

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        root.getChildren().addAll(buttons);
        root.setFillWidth(true);

        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX Experiments");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}