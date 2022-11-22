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
    String successOrFail = getSuccessOrFailure(moveDir, bridgeDir);
    upLineShape.add(getUpLineString(moveDir, successOrFail));
    downLineShape.add(getDownLineString(moveDir, successOrFail));
  }

  public String getMapString() {
    String upLine = getLineString(this.upLineShape);
    String downLine = getLineString(this.downLineShape);
    return upLine + "\n" + downLine;
  }

  public void clearMap() {
    this.upLineShape.clear();
    this.downLineShape.clear();
  }

  private String getLineString(List<String> lineShape) {
    return new StringBuilder()
        .append(BRIDGE_LEFT_SHAPE)
        .append(String.join(BRIDGE_CENTER_SHAPE, lineShape))
        .append(BRIDGE_RIGHT_SHAPE)
        .toString();
  }

  private String getSuccessOrFailure(String moveDir, String bridgeDir) {
    if (moveDir.equals(bridgeDir)) {
      return MOVE_SUCCESS_SIGN;
    }
    return MOVE_FAIL_SIGN;
  }

  private String getUpLineString(String moveDir, String successOrFail){
    if (moveDir.equals(Direction.UP.getDirection())) {
      return successOrFail;
    }
    return BRIDGE_BLACK_SHAPE;
  }

  private String getDownLineString(String moveDir, String successOrFail){
    if (moveDir.equals(Direction.DOWN.getDirection())) {
      return successOrFail;
    }
    return BRIDGE_BLACK_SHAPE;
  }
}
