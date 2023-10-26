package de.hhn.it.jobernberg.base;
import de.hhn.it.jobernberg.api.GreetingGenerator;

public class SimpleGreetingGenerator implements GreetingGenerator{
  @Override
  public String getGreeting(final String name) {
    return "Hello " + name;
  }
}
