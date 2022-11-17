package bridge;

import java.util.ArrayList;
import java.util.List;

public class answerReplace {
  public List<String> replace(int size) {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator =  new BridgeRandomNumberGenerator();
    List<String> replacedAnswer = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      int num = bridgeRandomNumberGenerator.generate();
      if (num == 1) {
        replacedAnswer.add("U");
      }
      if (num == 0) {
        replacedAnswer.add("D");
      }
    }
    return replacedAnswer;
  }
}
