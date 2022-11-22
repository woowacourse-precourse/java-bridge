package bridge.io.validation;

import bridge.io.validation.*;

public class InputValidation {

  public void validateBridgeSize(String size) {
    Validation validation = new RangeValidation(new NumberValidation(new NullValidation()));
    validation.validate(size);
  }

  public String validateAndReturnMove(String move) {
    Validation validation = new UOrDValidation(new NullValidation());
    validation.validate(move);
    return move;
  }

  public String validateAndReturnCommand(String command) {
    Validation validation = new ROrQValidation(new NullValidation());
    validation.validate(command);
    return command;
  }
}
