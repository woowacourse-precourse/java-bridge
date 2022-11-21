package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.ConstantMessage;

import java.util.*;

import static bridge.domain.ConstantMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStartMessage(){
        System.out.println(BRIDGE_GAME_START_MESSAGE);
    }

    public void printRequestBridgeLengthMessage(){
        System.out.println(REQUEST_BRIDGE_LENGTH_MESSAGE);
    }

    public void printNotNumberBridgeLengthInputErrorMessage(){
        System.out.println(NOT_NUMBER_BRIDGE_LENGTH_MESSAGE);
    }

    public void printInValidRangeBridgeLengthErrorMessage(){
        System.out.println(INVALID_RANGE_BRIDGE_LENGTH_MESSAGE);
    }

    public void printRequestMoveDirectionMessage(){
        System.out.print(REQUEST_MOVE_DIRECTION_MESSAGE);
    }

    public void printInValidMoveDirectionErrorMessage(){
        System.out.println(INVALID_DIRECTION_MESSAGE);
    }

    public void printRetryGameMessage(){
        System.out.println(REQUEST_GAME_RETRY_ANSWER_MESSAGE);
    }

    public void printRetryGameErrorMessage(){
        System.out.println(INVALID_RETRY_COMMAND_MESSAGE);
    }



    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        bridgeGame.makePrintResult();
        bridgeGame.printResult();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT_MAP_MESSAGE);
        printMap(bridgeGame);
        bridgeGame.printFinalResult();
    }
}
