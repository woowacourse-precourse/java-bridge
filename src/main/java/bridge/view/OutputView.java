package bridge.view;

import bridge.BridgeMark;
import bridge.GameStatus;
import bridge.dto.GameResultDto;

import java.util.List;

import static bridge.view.BridgeMapViewCreator.BridgeMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 *
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printBridgeLength() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
    }

    public static void printMove() {
        System.out.println(INPUT_MOVE_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(GameStatus gameStatus, GameResultDto gameResultDto) {
        List<BridgeMark> records = gameResultDto.getRecord();
        BridgeMap bridgeMap = BridgeMapViewCreator.create(gameStatus, records);

        System.out.println(bridgeMap.getUpBridge());
        System.out.println(bridgeMap.getDownBridge());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
