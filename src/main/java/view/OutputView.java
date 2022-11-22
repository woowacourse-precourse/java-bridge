package view;

import static bridge.enums.Direction.DOWNWARD_DIRECTION;
import static bridge.enums.Direction.UPWARD_DIRECTION;
import static bridge.enums.GameMessages.GAME_RESULT_MESSAGE;
import static bridge.enums.GameMessages.GAME_START_MESSAGE;
import static bridge.enums.GameMessages.RECEIVE_BRIDGE_SIZE_MESSAGE;
import static bridge.enums.GameMessages.RECEIVE_GAME_COMMAND_MESSAGE;
import static bridge.enums.GameMessages.RECEIVE_MOVING_DIRECTION_MESSAGE;

import java.text.MessageFormat;
import java.util.List;
import model.Bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param lowerBridge 두개의 다리 중 아래.
     * @param upperBridge 두개의 다리 중 위.
     */
    public void printMap(Bridge upperBridge, Bridge lowerBridge) {
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * @param outputBridge 위, 아래 두개의 다리.
     * @param gameResult   성공 또는 실패.
     * @param tryCount     게임 시도 횟수.
     */
    public void printResult(List<Bridge> outputBridge, String gameResult, int tryCount) {
        Bridge lowerBridge = outputBridge.get(DOWNWARD_DIRECTION.getValue());
        Bridge upperBridge = outputBridge.get(UPWARD_DIRECTION.getValue());
        String resultFormat = MessageFormat.format(GAME_RESULT_MESSAGE.toString(),
                upperBridge, lowerBridge, gameResult, tryCount);
        System.out.println(resultFormat);
    }

    /**
     * 게임의 시작을 알리는 메시지를 형식에 맞춰 출력한다.
     */
    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 다리의 길이를 입력받는 메시지를 형식에 맞춰 출력한다.
     */
    public void printReceiveSizeMessage() {
        System.out.println(RECEIVE_BRIDGE_SIZE_MESSAGE);
    }

    /**
     * 플레이어의 이동방향을 입력받는 메시지를 형식에 맞춰 출력한다.
     */
    public void printReceiveMovingDirectionMessage() {
        System.out.println(RECEIVE_MOVING_DIRECTION_MESSAGE);
    }

    /**
     * 게임의 재시작 여부를 입력받는 메시지를 형식에 맞춰 출력한다.
     */
    public void printReceiveGameCommandMessage() {
        System.out.println(RECEIVE_GAME_COMMAND_MESSAGE);
    }
}
