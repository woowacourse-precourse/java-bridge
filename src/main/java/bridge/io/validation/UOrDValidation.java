package bridge.io.validation;

import bridge.enums.ExceptionMessage;

public class UOrDValidation extends ValidationDecorator{

  public UOrDValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    if (!input.equals("U") && !input.equals("D")) {
      throw new IllegalArgumentException(ExceptionMessage.NOT_U_OR_D.getMessage());
    }
  }
}
