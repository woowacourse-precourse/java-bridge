package bridge.io.validation;

import bridge.enums.ExceptionMessage;
import bridge.enums.Range;

public class RangeValidation extends ValidationDecorator{

  public RangeValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    int num = Integer.parseInt(input);
    if (num < Range.MIN_RANGE.getRange() || num > Range.MAX_RANGE.getRange()) {
      throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NOT_IN_RANGE.getMessage());
    }
  }
}
