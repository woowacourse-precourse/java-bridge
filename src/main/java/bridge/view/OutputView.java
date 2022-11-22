package bridge.view;

import bridge.provider.BridgeGame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private BridgeGame bridgeGame;

    public void printMap(List<List<String>> makeMap) {
        makeMap.forEach(this::printLine);
        System.out.println();
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(makeMap());
        printSuccessOrFail(this.bridgeGame.finalResult());
        printTryCount(this.bridgeGame.getTryCount());
    }

    public void printStartingGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetryOrQuit() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public List<List<String>> makeMap() {
        return List.of(addLine("U"), addLine("D"));
    }

    private List<String> addLine(String position) {
        return IntStream.range(0, bridgeGame.getDirection().size())
                .mapToObj(index -> addResult(index, position))
                .collect(Collectors.toList());
    }

    private String addResult(final int index, String position) {
        if (bridgeGame.getDirection().get(index).equals(position)) {
            if (bridgeGame.isEqualsTo(index)) {
                return "성공";
            }
            return "실패";
        }
        return " ";
    }

    private void printLine(List<String> line) {
        System.out.println("[ " + String.join(" | ", line) + " ]");
    }

    private void printSuccessOrFail(String result) {
        System.out.println("게임 성공 여부: " + result);
    }

    private void printTryCount(int tryCount) {
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
