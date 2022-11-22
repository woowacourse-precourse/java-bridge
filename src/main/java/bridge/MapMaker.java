package bridge;

import bridge.enums.ControlKey;
import bridge.enums.MapOutputFormat;

import java.util.ArrayList;
import java.util.List;

public class MapMaker {
  private List<String> topLine;
  private List<String> bottomLine;
  private StringBuilder builder;

  public MapMaker() {
    builder = new StringBuilder();
    initBridge();
  }

  public void initBridge() {
    topLine = new ArrayList<>();
    bottomLine = new ArrayList<>();
  }

  public String getMap() {
    return getBothLayer();
  }


  public String makeResultMap() {
    return getBothLayer();
  }

  private void drawWay(String move, String way) {
    if (move.equals(ControlKey.UP.getKey())) {
      topLine.add(way);
      bottomLine.add(MapOutputFormat.EMPTY_SPACE.getFormat());
      return;
    }
    topLine.add(MapOutputFormat.EMPTY_SPACE.getFormat());
    bottomLine.add(way);
  }

  private String getBothLayer() {
    builder.setLength(0);
    return builder.append(MapOutputFormat.START_SQUARE_BRACKET.getFormat()).append(String.join(MapOutputFormat.SEPARATOR.getFormat(), topLine)).append(MapOutputFormat.END_SQUARE_BRACKET.getFormat())
      .append("\n").append(MapOutputFormat.START_SQUARE_BRACKET.getFormat()).append(String.join(MapOutputFormat.SEPARATOR.getFormat(), bottomLine)).append(MapOutputFormat.END_SQUARE_BRACKET.getFormat()).toString();
  }
}
