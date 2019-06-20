package com.dj.runner.locales;

import java.util.Locale;
import java.util.ResourceBundle;

public enum LocalizedMessages {
  PluginManager_PluginIsAlreadyInstalled_RestartRequired;

  private String propertyName;

  LocalizedMessages() {
    this.propertyName = this.name().replace("_", ".");
  }

  public String getPropertyName() {
    return propertyName;
  }

  public String toLocale() {
    return propertyName; // TODO: grab localized file load if not cached and grab actual string.
  }

  public static void main(String... args) {
    System.out.println("Hello World!");
    ResourceBundle bundle = ResourceBundle.getBundle(hudson.Messages.class.getName(), Locale.ENGLISH);
    for (String key : bundle.keySet()) {
      System.out.println("Got key=" + key);
    }
  }
}
