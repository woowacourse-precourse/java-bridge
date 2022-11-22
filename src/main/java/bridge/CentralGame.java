package bridge;

import java.util.ArrayList;
import java.util.List;

public class CentralGame {

    BridgeRandomNumberGenerator random = new BridgeRandomNumberGenerator();
    BridgeMaker answer = new BridgeMaker(random);

    public String answerStep(List<String> answerList, int blankNumber) {
        return answerList.get(blankNumber);
    }

    public List<String> correctAnswer(int bridgeLength) {
        return answer.makeBridge(bridgeLength);
    }

    public boolean Compare(String answerBlank, String userUpDown) {
        return answerBlank.equals(userUpDown);
    }

}
