package bridge.io.validation;

import bridge.constant.ExceptionMessage;

public class RangeValidation extends ValidationDecorator{

  public RangeValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    int num = Integer.parseInt(input);
    if (num < 3 || num > 20) {
      throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE.getMessage());
    }
  }
}
