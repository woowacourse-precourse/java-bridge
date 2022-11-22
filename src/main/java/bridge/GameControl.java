package bridge;

import java.util.*;

public class GameControl {

    InputView input = new InputView();
    OutputView output = new OutputView();
    CentralGame bring = new CentralGame();
    String retry = "R";

    public List<Integer> oneGame(List<String> answer, int blankNumber) {
        int count = 1;
        while (true) {
            blankNumber = oneStep(answer, blankNumber);
            if (blankNumber == answer.size()) {
                break;
            }
            if (!bring.Compare(retry, input.readGameCommand())) {
                break;
            }
            count = bring.centralRetry(count);
            blankNumber = 0;
        }
        return bring.result(blankNumber, count);
    }

    public int oneStep(List<String> answer, int blankNumber) {
        while (blankNumber < answer.size()) {
            String answerUpDown = bring.answerStep(answer, blankNumber);
            String userUpDown = input.readMoving();
            output.printMap(answer, userUpDown, blankNumber);
            if (!bring.Compare(answerUpDown, userUpDown)) {
                break;
            }
            blankNumber = bring.centralMove(blankNumber);
        }
        return blankNumber;
    }
}

