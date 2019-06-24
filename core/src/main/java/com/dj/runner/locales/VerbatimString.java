package com.dj.runner.locales;

public class VerbatimString implements Localizable {

  private String verbatim;

  public VerbatimString(String verbatim) {
    this.verbatim = verbatim;
  }

  @Override
  public String toLocale(Object... args) {
    return this.verbatim;
  }

  @Override
  public String toLocale() {
    return this.verbatim;
  }

}
