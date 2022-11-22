package bridge;

import java.util.*;

public class GameControl {

    InputView input = new InputView();
    OutputView output = new OutputView();
    CentralGame bring = new CentralGame();

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

