module JavaFxTesting.gui.main {
  requires JavaFxTesting.api.main;
  requires JavaFxTesting.base.main;
  requires javafx.controls;
  requires javafx.fxml;
  opens de.hhn.it.jobernberg.gui to javafx.fxml;
  uses de.hhn.it.jobernberg.api.GreetingGenerator;
  exports de.hhn.it.jobernberg.gui;
}
