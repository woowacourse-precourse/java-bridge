package bridge.Model;

import bridge.Utils.Validator.BridgeMoveValidator;
import bridge.Controller.ViewController;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private static final String BLANK = " ";

    private List<String> result;
    private final String inputMove;
    private final String correctMove;


    public Move(String correctMove) {
        ViewController inputController = new ViewController();
        this.inputMove = inputController.getMovement();
        this.correctMove = correctMove;
        this.result = new ArrayList<>();
    }

    /**
     * @return [" ", "O"] 형식의 리스트를 반환한다.
     */
    public List<String> getMove() {
        int index = BridgeMoveValidator.compareMoveInputAndNextMove(inputMove, correctMove).getIndex();
        for (int current = 0; current < 2; current++) {
            result = addOorX(index, current);
        }
        return result;
    }

    private List<String> addOorX(int index, int currentIndex) {
        if (index == currentIndex) {
            result.add(BridgeMoveValidator.compareMoveInputAndNextMove(inputMove, correctMove).getOorX());
        }
        if (index != currentIndex) {
            result.add(BLANK);
        }
        return result;
    }

}
