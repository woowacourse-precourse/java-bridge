package bridge.io.validation;

import bridge.enums.ControlKey;
import bridge.enums.ExceptionMessage;

public class ROrQValidation extends ValidationDecorator{

  public ROrQValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    if (!input.equals(ControlKey.RETRY.getKey()) && !input.equals(ControlKey.QUIT.getKey())) {
      throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NOT_R_OR_Q.getMessage());
    }
  }
}
