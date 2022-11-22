package view;

import java.util.ArrayList;
import java.util.List;

public class TranslateBridge {
  List<String> upper_bridge;
  List<String> lower_bridge;

  public TranslateBridge () {
    upper_bridge = new ArrayList<>();
    lower_bridge = new ArrayList<>();
  }

  public void setBridge(List<String> bridge, boolean is_answer) {
    setUpperBridge(bridge);
    setLowerBridge(bridge);
    setAnswer(is_answer);
  }

  private void setAnswer(boolean is_answer) {
    if (!is_answer) {
      int i = lower_bridge.size() - 2;
      changeBridgeChar(i);
    }
  }

  private void changeBridgeChar(int i) {
    if (upper_bridge.get(i).equals(" O "))
      upper_bridge.set(i, " X ");
    if (lower_bridge.get(i).equals(" O "))
      lower_bridge.set(i, " X ");
  }

  private void setLowerBridge(List<String> bridge) {
    lower_bridge.add("[");
    for (int i = 0; i < bridge.size(); i++) {
      if (i > 0 && bridge.get(i) != null)
        lower_bridge.add("|");
      if (bridge.get(i).equals("U"))
        lower_bridge.add("   ");
      if (bridge.get(i).equals("D"))
        lower_bridge.add(" O ");
    }
    lower_bridge.add("]");
  }

  private void setUpperBridge(List<String> bridge) {
    upper_bridge.add("[");
    for (int i = 0; i < bridge.size(); i++) {
      if (i > 0 && bridge.get(i) != null)
        upper_bridge.add("|");
      if (bridge.get(i).equals("U"))
        upper_bridge.add(" O ");
      if (bridge.get(i).equals("D"))
        upper_bridge.add("   ");
    }
    upper_bridge.add("]");
  }

  public void printBridge() {
    for (int i = 0; i < upper_bridge.size(); i++)
      System.out.print(upper_bridge.get(i));
    System.out.println();
    for (int i = 0; i < lower_bridge.size(); i++)
      System.out.print(lower_bridge.get(i));
    System.out.println();
  }
}
