package bridge.io;

import bridge.domain.BridgeGameCheck;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;
import bridge.enums.Constant;
import bridge.enums.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        BridgeMap bridgeMap = new BridgeMap(bridgeGame.getAnswerDirections(), bridgeGame.getPlayerDirections());
        bridgeMap.getMap()
                .forEach(System.out::println);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        printFinalBridgeResult(bridgeGame);
        printStatusResult(bridgeGame);
    }

    private static void printFinalBridgeResult(BridgeGame bridgeGame) {
        System.out.println(Message.GAME_RESULT_PREV_MSG.getMessage());
        printMap(bridgeGame);
    }

    private static void printStatusResult(BridgeGame bridgeGame) {
        System.out.println(Message.GAME_RESULT_STATE_MSG.getMessage() + getGameStatus(bridgeGame));
        System.out.println(Message.GAME_RESULT_TRY_MSG.getMessage() + "" + bridgeGame.getTrial());
    }

    private static String getGameStatus(BridgeGame bridgeGame) {
        if (BridgeGameCheck.isGameWin(bridgeGame)) {
            return Constant.SUCCESS.getValue();
        }
        return Constant.FAIL.getValue();
    }

    public static void printMessage(Message message){
        System.out.println(message.getMessage());
    }
}
