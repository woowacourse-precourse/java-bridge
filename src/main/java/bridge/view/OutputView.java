package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Visited;
import bridge.dto.BridgeGameResultDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public final class OutputView {
    private static final String NOT_NULL_MESSAGE = "결과값에 null이 올 수 없습니다";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Visited visited) {
        validateVisited(visited);
        System.out.println(visited.printVisited());
    }

    private void validateVisited(Visited visited) {
        if (visited == null) {
            throw new IllegalArgumentException(NOT_NULL_MESSAGE);
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameResultDto bridgeGameResultDto) {
        validateGameResult(bridgeGameResultDto);
        Bridge bridge = bridgeGameResultDto.getBridge();
        Visited visited = bridgeGameResultDto.getVisited();
        System.out.println("최종 게임 결과");
        this.printMap(visited);

        System.out.print("게임 성공 여부: ");
        System.out.println(bridge.result(visited).toResultMessage());
        System.out.printf("총 시도한 횟수: %d\n", bridgeGameResultDto.getTriedCount());
    }

    private void validateGameResult(BridgeGameResultDto bridgeGameResultDto) {
        if (bridgeGameResultDto == null) {
            throw new IllegalArgumentException(NOT_NULL_MESSAGE);
        }
    }

    public void printAskRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public void printMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInitialMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printAskBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }
}
