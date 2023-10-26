package de.hhn.it.jobernberg.gui;

import javafx.application.Application;

import de.hhn.it.jobernberg.api.GreetingGenerator;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ServiceLoader;

public class FxHelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GreetingGenerator generator = loadServiceProvider();
        String greeting = generator.getGreeting("World");
        Scene scene = new Scene(new javafx.scene.control.Label(greeting), 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    GreetingGenerator loadServiceProvider(){
        ServiceLoader<GreetingGenerator> loader = ServiceLoader.load(GreetingGenerator.class);
        return loader.findFirst().get();
    }

}
