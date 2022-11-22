package bridge.view;

import static bridge.constant.MovingDirection.D;
import static bridge.constant.MovingDirection.U;
import static bridge.view.constant.BridgeShape.DIFFERENT_DIRECTION;
import static bridge.view.constant.BridgeShape.MIDDLE_BRIDGE;
import static bridge.view.constant.BridgeShape.NONE_DIRECTION;
import static bridge.view.constant.BridgeShape.PREFIX_BRIDGE;
import static bridge.view.constant.BridgeShape.SAME_DIRECTION;
import static bridge.view.constant.BridgeShape.SUFFIX_BRIDGE;

import bridge.BridgeGame;
import bridge.constant.MovingDirection;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param bridgeGame
     */
    public void printMap(BridgeGame bridgeGame) {
        printBridgeByDirection(bridgeGame, U);
        printBridgeByDirection(bridgeGame, D);
    }

    private void printBridgeByDirection(BridgeGame bridgeGame, MovingDirection movingDirection) {
        System.out.print(PREFIX_BRIDGE.getShape());
        for (int i = 0; i < bridgeGame.getCurrentPosition(); i++) {
            printMiddleBridgeByDirection(bridgeGame, movingDirection, i);
            if (i != bridgeGame.getCurrentPosition() - 1) {
                System.out.print(MIDDLE_BRIDGE.getShape());
            }
        }
        System.out.println(SUFFIX_BRIDGE.getShape());
    }

    private void printMiddleBridgeByDirection(BridgeGame bridgeGame,
        MovingDirection movingDirection, int position) {
        if (bridgeGame.hasSameDirectionAtPosition(position, movingDirection)) {
            if (bridgeGame.hasCorrectDirectionAtPosition(position)) {
                System.out.print(SAME_DIRECTION.getShape());
                return;
            }
            System.out.print(DIFFERENT_DIRECTION.getShape());
            return;
        }
        System.out.print(NONE_DIRECTION.getShape());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param bridgeGame
     */
    public void printResult(BridgeGame bridgeGame) {
        if (bridgeGame.isNotFail()) {
            System.out.println("최종 게임 결과");
            printMap(bridgeGame);
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
            return;
        }
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    public void printStartPhrase() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeSizePhrase() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printOnGamePhrase() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetryOrQuitPhrase() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
