package bridge.Model;

import Utils.Validator.BridgeMoveValidator;
import bridge.Controller.InputController;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private static final String BLANK = " ";
    private static final String INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private List<String> result;
    private final String inputMove;
    private final String correctMove;


    public Move(String correctMove) {
        System.out.println(INPUT_MOVE);
        InputController inputController = new InputController();
        this.inputMove = inputController.getMovement();
        this.correctMove = correctMove;
        this.result = new ArrayList<>();
    }

    /**
     *
     * @return [" ", "O"] 형식의 리스트를 반환한다.
     */
    public List<String> getMove() {
        int index = BridgeMoveValidator.compareMoveInputAndNextMove(inputMove, correctMove).getIndex();
        for (int i = 0; i < 2; i++) {
            if (index == i) {
                result.add(BridgeMoveValidator.compareMoveInputAndNextMove(inputMove, correctMove).getOorX());
            }
            result.add(BLANK);
        }
        return result;
    }

}
