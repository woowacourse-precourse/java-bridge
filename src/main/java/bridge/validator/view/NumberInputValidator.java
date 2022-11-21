package bridge.validator.view;

import bridge.exception.NotIntegerException;

public class NumberInputValidator {
  public static void validate(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new NotIntegerException();
    }
  }
}
