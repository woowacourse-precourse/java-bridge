package bridge.view;

import bridge.constants.ErrorMessages;
import bridge.domain.BridgeGame;
import bridge.domain.enums.GameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param footPrints 현재까지 이동한 다리의 상태
     */
    public void printMap(String footPrints) {
        System.out.println(footPrints);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param bridgeGame 다리 건너기 게임 정보
     * @param status     게임 상태
     */
    public void printResult(BridgeGame bridgeGame, GameStatus status) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getFootPrintsLog());
        System.out.printf("게임 성공 여부: %s\n", status.getStatus());
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getTryCount());
    }

    public void printError(String message) {
        System.out.println(ErrorMessages.PREFIX + message);
    }
}
