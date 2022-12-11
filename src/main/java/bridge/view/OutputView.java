package bridge.view;

import bridge.util.ConstantMessage;

import java.util.List;

import static bridge.util.Constant.EXCEPTIONS;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public OutputView() {
        super();
    }

    public void printGameStartPhrase() {
        System.out.println(ConstantMessage.GAME_START_PHRASE);
    }

    public void printBridgeLengthInputPhrase() {
        System.out.println(ConstantMessage.BRIDGE_LENGTH_INPUT_PHRASE);
    }

    public String printBridgeLengthInputErrorMessage(String readLine) {
        String result;
        result = EXCEPTIONS.validateBridgeLength(readLine);
        if (!result.equals(ConstantMessage.BRIDGE_LENGTH_ERROR_MESSAGE)) {
            return result;
        }
        System.out.println(result);
        return result;
    }

    public void printMovingBlockInputPhrase() {
        System.out.println(ConstantMessage.MOVING_BLOCK_INPUT_PHRASE);
    }

    public String printMovingBlockInputErrorMessage(String readLine) {
        String result;
        result = EXCEPTIONS.validateMovingBlock(readLine);
        if (!result.equals(ConstantMessage.MOVING_BLOCK_ERROR_MESSAGE)) {
            return result;
        }
        System.out.println(result);
        return result;
    }

    public void printRestartMessage() {
        System.out.println(ConstantMessage.RESTART_GAME_PHRASE);
    }

    public String printRestartInputErrorMessage(String readLine) {
        String result;
        result = EXCEPTIONS.validateRestartGame(readLine);
        if (!result.equals(ConstantMessage.RESTART_GAME_ERROR_MESSAGE)) {
            return result;
        }
        System.out.println(result);
        return result;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> result) {
        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printClearResult(List<String> result) {
        System.out.println(ConstantMessage.GAME_RESULT_PHRASE);
        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println("게임 성공 여부: 성공");
    }

    public void printFailResult(List<String> result) {
        System.out.println(ConstantMessage.GAME_RESULT_PHRASE);
        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println("게임 성공 여부: 실패");
    }
}
