package bridge.io.validation;

import bridge.constant.ExceptionMessage;

public class ROrQValidation extends ValidationDecorator{

  public ROrQValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    if (!input.equals("R") && !input.equals("Q")) {
      throw new IllegalArgumentException(ExceptionMessage.NOT_R_OR_Q.getMessage());
    }
  }
}
