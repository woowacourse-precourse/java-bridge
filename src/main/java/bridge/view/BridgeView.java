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

  public void printUpper() {
    System.out.print(START_BRIDGE);
    for (Cross cross: crossResult) {
      System.out.print(eachCrossUpper(cross));
      System.out.print(needSeparator(cross));
    }
    System.out.println(END_BRIDGE);
  }

  public void printLower() {
    System.out.print(START_BRIDGE);
    for (Cross cross: crossResult) {
      System.out.print(eachCrossLower(cross));
      System.out.print(needSeparator(cross));
    }
    System.out.println(END_BRIDGE);
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

  public String needSeparator(Cross cross) {
    if(cross != crossResult.get(crossResult.size() - 1)) {
      return SEPARATOR;
    }
    return NONE;
  }

}
