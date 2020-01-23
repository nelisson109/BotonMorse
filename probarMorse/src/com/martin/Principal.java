package com.martin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import martin.BotonMorse;
import martin.LetraResultado;

public class Principal extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();

        BotonMorse componenteMorse = new BotonMorse();

        componenteMorse.addListaLetras(new LetraResultado() {
            @Override
            public void ejecuta(char letra) {
                System.out.println(letra);
                Label label = new Label("");
                vBox.getChildren().add(label);
            }
        });

        vBox.getChildren().addAll(componenteMorse);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
