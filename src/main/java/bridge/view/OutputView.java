package bridge.view;

import static bridge.constant.BridgeGameGuideConstant.GAME_FAIL;
import static bridge.constant.BridgeGameGuideConstant.GAME_SUCCESS;
import static bridge.constant.BridgeGameGuideConstant.INPUT_BRIDGE_LENGTH;
import static bridge.constant.BridgeGameGuideConstant.INPUT_MOVE_DIRECTION;
import static bridge.constant.BridgeGameGuideConstant.INPUT_RETRY_QUESTION;
import static bridge.constant.BridgeGameGuideConstant.RESULT_OF_FINAL_GAME;
import static bridge.constant.BridgeGameGuideConstant.RUN;
import static bridge.constant.BridgeGameGuideConstant.TOTAL_ATTEMPT_NUMBER;
import static bridge.constant.NumberConstant.FIRST_ROW;
import static bridge.constant.NumberConstant.SECOND_ROW;

import bridge.domain.CompareResult;
import bridge.util.Analyze;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private List<String> storedMap;

    public OutputView() {
        this.init();
    }

    public void init() {
        this.storedMap = new ArrayList<>();

        for (int i = FIRST_ROW.getCode(); i <= SECOND_ROW.getCode(); ++i) {
            storedMap.add("");
        }
    }

    public CompareResult printMap(CompareResult compareResult) {
        Analyze.analyzePrintType(this.storedMap, compareResult);

        currentMapPrint();

        return compareResult;
    }

    public void currentMapPrint() {
        System.out.print("[" + storedMap.get(FIRST_ROW.getCode()) + "]\n");
        System.out.print("[" + storedMap.get(SECOND_ROW.getCode()) + "]\n");
    }

    public void finalMapPrint(boolean isSuccess) {
        System.out.print(RESULT_OF_FINAL_GAME.getMessage());
        currentMapPrint();

        if (isSuccess) {
            System.out.print(GAME_SUCCESS.getMessage());
            return;
        }

        System.out.print(GAME_FAIL.getMessage());
    }

    public void printResult() {
        finalMapPrint(false);
    }

    public boolean isQuitGame(String gameCommand) {
        if (Analyze.analyzeIsRetry(gameCommand)) {
            this.init();

            return true;
        }

        printResult();

        return false;
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printStart() {
        System.out.print(RUN.getMessage());
    }

    public void printInputBridgeLength() {
        System.out.print(INPUT_BRIDGE_LENGTH.getMessage());
    }

    public void printInputMoveDirection() {
        System.out.print(INPUT_MOVE_DIRECTION.getMessage());
    }

    public void inputGameCommand() {
        System.out.print(INPUT_RETRY_QUESTION.getMessage());
    }

    public void printAttemptNumber(int attemptNumber) {
        System.out.print(TOTAL_ATTEMPT_NUMBER.getMessage() + attemptNumber);
    }

}
