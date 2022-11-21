package bridge;

import bridge.enums.ControlKey;
import bridge.enums.MapOutputFormat;

public class MapMaker {
  private StringBuilder builderTopLine;
  private StringBuilder builderBottomLine;

  public String makeCurrentMap(Bridge bridge, int index, String move) {
    initBridge();
    for (int i = 0; i < index; i++) {
      if (!bridge.canCross(move, index)) {
        drawWrongWay(move);
        break;
      }
      drawRightWay(move);
    }
    finishBridge();
    return builderTopLine + "\n" + builderBottomLine;
  }

  private void initBridge() {
    builderTopLine = new StringBuilder();
    builderBottomLine = new StringBuilder();
    builderTopLine.append(MapOutputFormat.START_SQUARE_BRACKET.getFormat());
    builderBottomLine.append(MapOutputFormat.START_SQUARE_BRACKET.getFormat());
  }

  private void drawRightWay(String move) {
    if (move.equals(ControlKey.UP.getKey())) {
      builderTopLine.append(MapOutputFormat.RIGHT_WAY.getFormat() + MapOutputFormat.SEPARATOR.getFormat());
      return;
    }
    builderBottomLine.append(MapOutputFormat.EMPTY_SPACE.getFormat() + MapOutputFormat.SEPARATOR.getFormat());
  }

  private void drawWrongWay(String move) {
    if (move.equals(ControlKey.UP.getKey())) {
      builderTopLine.append(MapOutputFormat.WRONG_WAY.getFormat());
      return;
    }
    builderBottomLine.append(MapOutputFormat.EMPTY_SPACE.getFormat());
  }

  private void finishBridge() {
    builderTopLine.append(MapOutputFormat.END_SQUARE_BRACKET.getFormat());
    builderBottomLine.append(MapOutputFormat.END_SQUARE_BRACKET.getFormat());
  }

  private void drawSuccessResultMap() {

  }
}
