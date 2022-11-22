package bridge.io.validation;

import bridge.enums.ControlKey;
import bridge.enums.ExceptionMessage;

public class UOrDValidation extends ValidationDecorator{

  public UOrDValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    if (!input.equals(ControlKey.UP.getKey()) && !input.equals(ControlKey.DOWN.getKey())) {
      throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NOT_U_OR_D.getMessage());
    }
  }
}
