package view;

import static bridge.enums.GameMessages.GAME_RESULT_MESSAGE;
import static bridge.enums.GameMessages.GAME_START_MESSAGE;
import static bridge.enums.GameMessages.RECEIVE_BRIDGE_SIZE_MESSAGE;
import static bridge.enums.GameMessages.RECEIVE_GAME_COMMAND_MESSAGE;
import static bridge.enums.GameMessages.RECEIVE_MOVING_DIRECTION_MESSAGE;

import java.text.MessageFormat;
import model.Bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge upperBridge, Bridge lowerBridge) {
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // TODO: 함수인자 세개이하로 줄이기
    public void printResult(Bridge upperBridge, Bridge lowerBridge, String gameResult, int tryCount) {
        String format = MessageFormat.format(GAME_RESULT_MESSAGE.toString(),
                upperBridge, lowerBridge, gameResult, tryCount);
        System.out.println(format);
    }

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printReceiveSizeMessage() {
        System.out.println(RECEIVE_BRIDGE_SIZE_MESSAGE);
    }

    public void printReceiveMovingDirectionMessage() {
        System.out.println(RECEIVE_MOVING_DIRECTION_MESSAGE);
    }

    public void printReceiveGameCommandMessage() {
        System.out.println(RECEIVE_GAME_COMMAND_MESSAGE);
    }
}
