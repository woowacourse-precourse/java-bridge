package bridge.Output;

import bridge.BridgeGame;
import bridge.CommandConstant;

import java.util.List;

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
        StringBuilder upLineResult = new StringBuilder(MapConstant.START);
        StringBuilder downLineResult = new StringBuilder(MapConstant.START);

        makeSuccessResult(bridgeGame, upLineResult, downLineResult);
        makeFailResult(bridgeGame, upLineResult, downLineResult);

        upLineResult.append(MapConstant.END);
        downLineResult.append(MapConstant.END);
        System.out.println(upLineResult + "\n" + downLineResult + "\n");
    }

    private void makeSuccessResult(BridgeGame bridgeGame, StringBuilder upLineResult, StringBuilder downLineResult) {
        for (int length = 0; length < bridgeGame.getLocation(); length++) {
            addSuccessResult(bridgeGame.getBridge().get(length), upLineResult, downLineResult);
            upLineResult.append(MapConstant.SEPARATOR);
            downLineResult.append(MapConstant.SEPARATOR);
        }

    }

    private void addSuccessResult(String moveCommand, StringBuilder upLineResult, StringBuilder downLineResult) {
        if (moveCommand.equals(CommandConstant.UP_COMMAND)) {
            upLineResult.append(MapConstant.SUCCESS);
            downLineResult.append(MapConstant.PASS);
            return;
        }

        upLineResult.append(MapConstant.PASS);
        downLineResult.append(MapConstant.SUCCESS);
    }

    private void makeFailResult(BridgeGame bridgeGame, StringBuilder upLineResult, StringBuilder downLineResult) {
        if (bridgeGame.succeedMove()) {
            eraseLastSeparator(upLineResult);
            eraseLastSeparator(downLineResult);
            return;
        }
        addFailResult(bridgeGame, upLineResult, downLineResult);
    }

    private void addFailResult(BridgeGame bridgeGame, StringBuilder upLineResult, StringBuilder downLineResult) {
        List<String> bridge = bridgeGame.getBridge();
        String lastMoveCommand = bridge.get(bridgeGame.getLocation());

        if (lastMoveCommand.equals(CommandConstant.UP_COMMAND)) {
            upLineResult.append(MapConstant.PASS);
            downLineResult.append(MapConstant.FAIL);
            return;
        }
        upLineResult.append(MapConstant.FAIL);
        downLineResult.append(MapConstant.PASS);
    }

    private void eraseLastSeparator(StringBuilder lineResult) {
        int separatorLength = MapConstant.SEPARATOR.length();
        lineResult.delete(lineResult.length() - separatorLength, lineResult.length());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GameMessage.FINAL_GAME_RESULT_MESSAGE);
        printMap(bridgeGame);
        printGameSuccessResult(bridgeGame);
        printTotalGameCount(bridgeGame);
    }

    public void printGameSuccessResult(BridgeGame bridgeGame) {
        if (bridgeGame.isGameEnd()) {
            System.out.println(GameMessage.GAME_SUCCESS_MESSAGE);
            return;
        }
        System.out.println(GameMessage.GAME_FAIL_MESSAGE);
    }

    public void printTotalGameCount(BridgeGame bridgeGame) {
        String totalGameCount = Integer.toString(bridgeGame.getTotalGameCount());
        System.out.println(GameMessage.RETRY_NUMBER_MESSAGE + totalGameCount);
    }

    public void printGameStart() {
        System.out.println(GameMessage.START_MESSAGE + "\n");
    }

    public void printBridgeSizeInput() {
        System.out.println(GameMessage.BRIDGE_SIZE_INPUT_MESSAGE);
    }

    public void printMoveCommandInput() {
        System.out.println(GameMessage.MOVE_COMMAND_INPUT_MESSAGE);
    }

    public void printGameCommandInput() {
        System.out.println(GameMessage.GAME_COMMAND_INPUT_MESSAGE);
    }
}
