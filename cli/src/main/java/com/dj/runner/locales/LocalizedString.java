package com.dj.runner.locales;

import java.util.Locale;
import java.util.ResourceBundle;

public enum LocalizedString implements Localizable {

  CLI_NoSuchFileExists,
  CLI_NoURL,
  CLI_BadAuth,
  CLI_Usage;

  private String                propertyName;

  private static ResourceBundle bundle = ResourceBundle.getBundle(LocalizedString.class.getName(), Locale.ENGLISH);

  LocalizedString() {
    this.propertyName = this.name().replace("_", ".");
  }

  public String getPropertyName() {
    return propertyName;
  }

  public String toString() {
    return toLocale();
  }

  public String toLocale() {
    return bundle.getString(propertyName);
  }

  public String toLocale(Object... args) {
    return toLocale(); // TODO: substitute formated args into locale string
  }

  public Localizable asLocale(Object... args) {
    return new Localizable() {

      @Override
      public String toLocale(Object... args) {
        // overriding the args
        return bundle.getString(propertyName);
      }

      @Override
      public String toLocale() {
        // uses the passed args
        return bundle.getString(propertyName);
      }

    };
  }

  public String toString(Locale english) {
    // TODO Auto-generated method stub
    return null;
  }
}
