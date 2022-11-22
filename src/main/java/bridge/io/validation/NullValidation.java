package bridge.io.validation;

import bridge.enums.ExceptionMessage;

public class NullValidation implements Validation{

  @Override
  public void validate(String input) {
    if (input == null || input.trim().length() == 0) {
      throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NULL.getMessage());
    }
  }
}
