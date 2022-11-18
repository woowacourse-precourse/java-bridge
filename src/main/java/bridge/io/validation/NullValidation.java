package bridge.io.validation;

import bridge.constant.ExceptionMessage;

public class NullValidation implements Validation{

  @Override
  public void validate(String input) {
    if (input == null || input.trim().length() == 0) {
      throw new IllegalArgumentException(ExceptionMessage.NULL.getMessage());
    }
  }
}
