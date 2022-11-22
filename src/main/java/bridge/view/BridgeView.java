package bridge.view;

import bridge.Cross;
import bridge.Direction;

import java.util.List;

public class BridgeView {

  public static final String START_BRIDGE = "[";
  public static final String END_BRIDGE = "]";
  public static final String CORRECT = " O ";
  public static final String INCORRECT = " X ";
  public static final String BLANK = "   ";
  public static final String SEPARATOR = "|";
  public static final String NONE = "";

  private final List<Cross> crossResult;

  public BridgeView(List<Cross> crossResult) {
    this.crossResult = crossResult;
  }

  public String eachCrossUpper(Cross cross) {
    if (cross.getDirection() == Direction.U) {
      if (cross.isCanCross()) return CORRECT;
      return INCORRECT;
    }
    return BLANK;
  }

  public String eachCrossLower(Cross cross) {
    if (cross.getDirection() == Direction.D) {
      if (cross.isCanCross()) return CORRECT;
      return INCORRECT;
    }
    return BLANK;
  }

}
