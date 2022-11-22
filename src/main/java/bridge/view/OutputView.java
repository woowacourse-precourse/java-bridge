package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Status;

import java.util.List;

import static bridge.constants.Constants.*;

public class OutputView {

    public static final String PRINT_CELL_START = "[ ";
    public static final String PRINT_CELL_FINISH = " ]";
    public static final String PRINT_CELL_DIVIDER = " | ";
    public static final String ACCESS_CELL = "O";
    public static final String BLANK_CELL = " ";
    public static final String FAIL_CELL = "X";

    public void printMap(BridgeGame bridgeGame) {
        StringBuilder upLine = settingPrintLine(bridgeGame, GAME_COMMAND_UP);
        StringBuilder downLine = settingPrintLine(bridgeGame, GAME_COMMAND_DOWN);

        System.out.println(upLine);
        System.out.println(downLine);
    }

    public StringBuilder settingPrintLine(BridgeGame bridgeGame, String gameCommand) {
        StringBuilder printLine = drawMapBeforeLast(bridgeGame, gameCommand); // 시작 부분
        printLine.append(drawMapLast(bridgeGame, gameCommand)); //마지막 부분
        return printLine;
    }

    private StringBuilder drawMapBeforeLast(BridgeGame bridgeGame, String draw) {
        //마지막 이전까지를 그린다.
        StringBuilder drawnLine = new StringBuilder(PRINT_CELL_START);
        List<String> bridge = bridgeGame.getBridge();
        int nowLocation = bridgeGame.getNowLocation();
        for (int cell = 0; cell < nowLocation - 1; cell++) {
            drawnLine.append(drawEachCell(bridge.get(cell), draw)).append(PRINT_CELL_DIVIDER);
        }
        return drawnLine;
    }

    private String drawMapLast(BridgeGame bridgeGame, String draw) {
        Status status = bridgeGame.getStatus();
        List<String> bridge = bridgeGame.getBridge();
        int nowLocation = bridgeGame.getNowLocation() - 1;

        if (status == Status.FAIL) { //실패한 경우는 마지막이 X로 출력된다.
            return printFailMap(bridge.get(nowLocation), draw) + PRINT_CELL_FINISH;
        }
        return printPlayingMap(bridge.get(nowLocation), draw) + PRINT_CELL_FINISH;
    }

    private String drawEachCell(String answer, String draw) {
        if (answer.equals(draw)) {
            return ACCESS_CELL;
        }
        return BLANK_CELL;
    }

    private String printPlayingMap(String last, String draw) {
        if (last.equals(draw)) {
            return ACCESS_CELL;
        }
        return BLANK_CELL;
    }

    private String printFailMap(String last, String draw) {
        if (last.equals(draw)) {
            return BLANK_CELL;
        }
        return FAIL_CELL;
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println('\n' + GAME_RESULT_MESSAGE);
        printMap(bridgeGame);
        System.out.println('\n' + checkStatus(bridgeGame.getStatus()));
        System.out.println(TOTAL_CHALLENGES_COUNT + bridgeGame.getChallengesCnt());
    }

    public String checkStatus(Status status) {
        if (status == Status.ENDING) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAILED_MESSAGE;
    }
}
