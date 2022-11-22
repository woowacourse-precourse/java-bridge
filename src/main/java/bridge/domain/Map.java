package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Map {
  public static final String BRIDGE_LEFT_SHAPE = "[ ";
  public static final String BRIDGE_CENTER_SHAPE = " | ";
  public static final String BRIDGE_RIGHT_SHAPE = " ]";
  public static final String BRIDGE_BLACK_SHAPE = " ";
  public static final String MOVE_SUCCESS_SIGN = "O";
  public static final String MOVE_FAIL_SIGN = "X";

  private List<String> upLineShape;
  private List<String> downLineShape;

  public Map() {
    this.upLineShape = new ArrayList<>();
    this.downLineShape = new ArrayList<>();
  }

  public void updateMap(String moveDir, String bridgeDir) {
    upLineShape.add(getString(moveDir, bridgeDir, true));
    downLineShape.add(getString(moveDir, bridgeDir, false));
  }

  /** 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다. */
  public String getMapString() {
    String upLine = getLineString(this.upLineShape);
    String downLine = getLineString(this.downLineShape);
    return upLine + "\n" + downLine;
  }

  private String getLineString(List<String> lineShape) {
    return new StringBuilder()
        .append(BRIDGE_LEFT_SHAPE)
        .append(String.join(BRIDGE_CENTER_SHAPE, lineShape))
        .append(BRIDGE_RIGHT_SHAPE)
        .toString();
  }

  private static String getSuccessOrFailure(String moveDir, String bridgeDir) {
    if (moveDir.equals(bridgeDir)) {
      return MOVE_SUCCESS_SIGN;
    }
    return MOVE_FAIL_SIGN;
  }

  private static String getString(String moveDir, String bridgeDir, boolean isUp) {
    String successOrFail = getSuccessOrFailure(moveDir, bridgeDir);
    if (moveDir.equals(Direction.UP.getDirection())) {
      if (isUp) return successOrFail;
      return BRIDGE_BLACK_SHAPE;
    } else {
      if (isUp) return BRIDGE_BLACK_SHAPE;
      return successOrFail;
    }
  }
}
