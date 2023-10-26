module JavaFxTesting.base.main {
  requires JavaFxTesting.api.main;
  provides de.hhn.it.jobernberg.api.GreetingGenerator with de.hhn.it.jobernberg.base.SimpleGreetingGenerator;
  exports de.hhn.it.jobernberg.base;
}
