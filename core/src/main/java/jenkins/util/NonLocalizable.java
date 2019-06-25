package jenkins.util;

import java.util.Locale;

import hudson.Localizable;

/**
 * {@link Localizable} implementation that actually doesn't localize.
 */
public class NonLocalizable implements Localizable {
  /**
   * The string that we don't know how to localize
   */
  private final String nonLocalizable;

  /**
   * Creates a non-localizable string.
   *
   * @param nonLocalizable the string.
   */
  public NonLocalizable(String nonLocalizable) {
    this.nonLocalizable = nonLocalizable;
  }

  public String toString(Locale locale) {
    return nonLocalizable;
  }

  @Override
  public String toString() {
    return nonLocalizable;
  }

  @Override
  public String toLocale(Object... args) {
    return toString();
  }

  @Override
  public String toLocale() {
    return toString();
  }
}
