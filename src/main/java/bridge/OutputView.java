package bridge;

import java.util.List;

import static constants.Constants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        StringBuilder upLine = drawMap(bridgeGame, GAME_COMMAND_UP);
        StringBuilder downLine = drawMap(bridgeGame, GAME_COMMAND_DOWN);

        upLine.append(drawMapFinal(bridgeGame, GAME_COMMAND_UP));
        downLine.append(drawMapFinal(bridgeGame, GAME_COMMAND_DOWN));

        System.out.println(upLine);
        System.out.println(downLine);
    }

    private String drawMapFinal(BridgeGame bridgeGame, String draw) {
        Status status = bridgeGame.getStatus();
        List<String> bridge = bridgeGame.getBridge();
        int nowLocation = bridgeGame.getNowLocation() - 1;
        if (status == Status.FAIL) {
            return printFailMap(bridge.get(nowLocation), draw);
        }
        return printPlayingMap(bridge.get(nowLocation), draw);
    }

    private StringBuilder drawMap(BridgeGame bridgeGame, String draw) {
        //마지막 이전까지를 그린다.
        StringBuilder drawnLine = new StringBuilder("[ ");
        List<String> bridge = bridgeGame.getBridge();
        int nowLocation = bridgeGame.getNowLocation();
        for (int i = 0; i < nowLocation - 1; i++) {
            drawnLine.append(drawLine(bridge.get(i), draw));
        }
        return drawnLine;
    }

    private String drawLine(String answer, String draw) {
        if (answer.equals(draw)) {
            return "O | ";
        }
        return "  | ";
    }


    private String printPlayingMap(String last, String draw) {
        if (last.equals(draw)) {
            return "O ]";
        }
        return "  ]";
    }

    private String printFailMap(String last, String draw) {
        if (last.equals(draw)) {
            return "  ]";
        }
        return "X ]";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println('\n' + GAME_RESULT_MESSAGE);
        printMap(bridgeGame);
        System.out.println('\n' + checkStatus(bridgeGame.getStatus()));
        System.out.println(TOTAL_CHALLENGES_COUNT + bridgeGame.getChallengesCnt());
    }

    private String checkStatus(Status status) {
        if (status == Status.ENDING) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAILED_MESSAGE;
    }
}
