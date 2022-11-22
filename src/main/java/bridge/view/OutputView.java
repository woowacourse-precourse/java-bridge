package bridge.view;

import static bridge.view.map.OutputMapView.printLowerBridge;
import static bridge.view.map.OutputMapView.printUpperBridge;

import bridge.result.GameResult;
import bridge.result.Result;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String INPUT_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부: ";
    private static final String GAME_COUNT_MESSAGE = "총 시도한 횟수: ";


    public void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        List<String> squares = result.getSquares();
        GameResult gameResult = result.getGameStatus();
        printUpperBridge(squares, gameResult);
        printLowerBridge(squares, gameResult);
    }

    public void printInputGameCommand() {
        System.out.println(INPUT_GAME_COMMAND_MESSAGE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result, Integer gameCount) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(result);
        System.out.println(SUCCESS_OR_NOT_MESSAGE + result.getGameStatus().toString());
        System.out.println(GAME_COUNT_MESSAGE + gameCount);
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printInputBridgeSizeMessage() {
        System.out.println(INPUT_SIZE_MESSAGE);
    }

    public void printInputMoveMessage() {
        System.out.println(INPUT_MOVE_MESSAGE);
    }
}
