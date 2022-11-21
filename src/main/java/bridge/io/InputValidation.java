package bridge.io;

import bridge.io.validation.*;

public class InputValidation {

  public int validateAndReturnBridgeSize(String size) {
    Validation validation = new RangeValidation(new NumberValidation(new NullValidation()));
    validation.validate(size);
    return Integer.parseInt(size);
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
