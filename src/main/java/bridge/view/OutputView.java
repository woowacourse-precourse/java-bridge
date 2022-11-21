package bridge.view;

import bridge.view.text.OutputText;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(List<String> map) {
    }

    public void printResult(String gameClear, int trialCount) {
        System.out.println(OutputText.GAME_RESULT_TITLE.getMessage());
        System.out.printf(OutputText.GAME_CLEAR.getMessage(), gameClear);
        System.out.printf(OutputText.TRIAL_COUNT.getMessage(), trialCount);
    }

    public void printGameStart(){
        System.out.println(OutputText.GAME_START.getMessage());
    }

    public void printBridgeLengthInputRequest(){
        System.out.println(OutputText.BRIDGE_LENGTH_INPUT_REQUEST.getMessage());
    }

    public void printMoveInputRequest(){
        System.out.println(OutputText.MOVE_INPUT_REQUEST.getMessage());
    }

    public void printRetryInputRequest(){
        System.out.println(OutputText.RETRY_INPUT_REQUEST.getMessage());
    }

}
