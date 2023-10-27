package de.hhn.it.jobernberg.gui;

import javafx.application.Application;

import de.hhn.it.jobernberg.api.GreetingGenerator;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ServiceLoader;

public class FxTest extends Application {

  @Override
  public void start(Stage primaryStage) {
    GreetingGenerator generator = loadServiceProvider();
    String greeting = generator.getGreeting("World");

    primaryStage.setTitle("Hello World!");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Text sceneTitle = new Text();
    sceneTitle.setText("Welcome");
    sceneTitle.setId("welcome-text");

    grid.add(sceneTitle, 0, 0, 2, 1);

    Label stringInputLabel = new Label("Enter a String");
    grid.add(stringInputLabel, 0, 1);

    TextField stringInputField = new TextField();
    grid.add(stringInputField, 1, 1);

    Label stringOutputLabel = new Label("Output");
    grid.add(stringOutputLabel, 0, 2);

    TextField stringOutputField = new TextField();
    grid.add(stringOutputField, 1, 2);

    Button btn = new Button();
    btn.setText("Say 'Hello World'");
    btn.setOnAction(event -> {
      stringOutputField.setText(generator.getGreeting(stringInputField.getText()));
    });
    grid.add(btn, 0, 3);

    Label greetingLabel = new Label(greeting);
    greetingLabel.setId("greeting-label");
    grid.add(greetingLabel, 0, 4);

    Button openNewWindowButton = new Button("Open New Window");
    openNewWindowButton.setOnAction(e -> openNewWindow());
    grid.add(openNewWindowButton, 0, 5);


    StackPane root = new StackPane();
    root.getChildren().add(grid);

    Scene scene = new Scene(root, 300, 200);
    primaryStage.setScene(scene);
    try{
      scene.getStylesheets().add(FxTest.class.getResource("/Test.css").toExternalForm());
    } catch (Exception e){
      System.out.println("CSS not found");
    }


    primaryStage.show();
  }
  private void openNewWindow() {
    Stage newStage = new Stage();
    newStage.setTitle("FXML Welcome");
    Parent root;
    try {
      root = new FXMLLoader().load(getClass().getResourceAsStream("/fxml/welcome.fxml"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Button closeButton = new Button("Close New Window");
    closeButton.setOnAction(e -> newStage.close());

    StackPane newRoot = new StackPane(closeButton);
    newStage.setScene(new Scene(newRoot, 300, 200));
    newStage.show();
  }
  GreetingGenerator loadServiceProvider() {
    ServiceLoader<GreetingGenerator> loader = ServiceLoader.load(GreetingGenerator.class);
    return loader.findFirst().get();
  }
}
