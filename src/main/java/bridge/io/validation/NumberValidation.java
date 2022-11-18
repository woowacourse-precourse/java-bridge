package bridge.io.validation;

import bridge.constant.ExceptionMessage;

public class NumberValidation extends ValidationDecorator{

  public NumberValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    try {
      int num = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ExceptionMessage.NOT_A_NUMBER.getMessage());
    }
  }
}
