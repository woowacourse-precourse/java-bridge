package bridge;

import java.util.ArrayList;
import java.util.List;

public class CentralGame {

    BridgeRandomNumberGenerator random = new BridgeRandomNumberGenerator();
    BridgeMaker answer = new BridgeMaker(random);
    BridgeGame core = new BridgeGame();

    public String answerStep(List<String> answerList, int blankNumber) {
        return answerList.get(blankNumber);
    }

    public List<String> correctAnswer(int bridgeLength) {
        return answer.makeBridge(bridgeLength);
    }

    public boolean Compare(String answerBlank, String userUpDown) {
        return answerBlank.equals(userUpDown);
    }

    public int centralMove(int blankNumber) {
        return blankNumber + 1;
    }

    public int centralRetry(int count) {
        return core.retry(count);
    }

    public List<Integer> result(int blankNumber, int count) {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(blankNumber);
        resultList.add(count);
        return resultList;
    }

}
