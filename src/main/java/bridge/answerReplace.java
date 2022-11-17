package bridge;

import java.util.ArrayList;
import java.util.List;

public class answerReplace {

  // replaceAnswers(generateAnswers(InputView.readsize())); 이런 식으루.. 지저분한가
  public List<Integer> generateAnswers(int size) {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    List<Integer> answers = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      int num = bridgeRandomNumberGenerator.generate();
      answers.add(num);
    }
    return answers;
  }

  public List<String> replaceAnswers(List<Integer> answers) {
    ArrayList<String> replacedAnswer = new ArrayList<>();
    for (Integer answer : answers) {
      if (answer == 1) {
        replacedAnswer.add("U");
      }
      if (answer == 0) {
        replacedAnswer.add("D");
      }
    }
    return replacedAnswer;
  }
}
