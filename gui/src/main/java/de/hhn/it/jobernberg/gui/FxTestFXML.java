package de.hhn.it.jobernberg.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxTestFXML {
  FxTestFXML() {
    Stage newStage = new Stage();
    newStage.setTitle("FXML Welcome");
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/welcome.fxml"));
    Parent root = null;
    try {
      root = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Scene newScene = new Scene(root, 300, 275);
    try{
      newScene.getStylesheets().add(FxTest.class.getResource("/NewScene.css").toExternalForm());
    } catch (Exception e){
      System.out.println("CSS not found");
    }
    newStage.setScene(newScene);
    newStage.show();
  }
}
