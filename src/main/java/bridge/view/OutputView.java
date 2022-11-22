package bridge.view;

import bridge.etc.GameState;
import bridge.game.Bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 메시지 출력
     */
    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 다리 길이 입력 요청 메시지 출력
     */
    public void printInputBridgeLengthMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸 선택 메시지 출력
     */
    public void printInputMoveDirectionMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 재시작 선택 메시지 출력
     */
    public void printInputRetryMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(Bridge bridge, GameState state) {
        System.out.println(bridge.getBridgeView(state));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(Bridge bridge, Integer count, GameState state) {
        System.out.println("최종 게임 결과");
        printMap(bridge, state);
        System.out.println();
        System.out.println("최종 게임 결과");
        System.out.println(String.format("총 시도한 횟수: %d", count));
    }
}
