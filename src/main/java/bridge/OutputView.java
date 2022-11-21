package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userPath, GameStatus gameStatus) {
        List<String> map = formatMap(userPath, gameStatus);
        System.out.println("[ " + String.join(" | ", map.get(0).split("")) + " ]");
        System.out.println("[ " + String.join(" | ", map.get(1).split("")) + " ]");
    }

    private List<String> formatMap(List<String> userPath, GameStatus gameStatus) {
        String matches = parseMatches(userPath, gameStatus);
        return formatUpDown(userPath, matches);
    }

    private List<String> formatUpDown(List<String> userPath, String matches) {
        StringBuilder upSide = new StringBuilder(matches);
        StringBuilder downSide = new StringBuilder(matches);
        for (int i = 0; i < userPath.size(); i++) {
            if (userPath.get(i).equals("U")) {
                downSide.setCharAt(i, ' ');
                continue;
            }
            upSide.setCharAt(i, ' ');
        }
        return List.of(upSide.toString(), downSide.toString());
    }

    private String parseMatches(List<String> userPath, GameStatus gameStatus) {
        if (gameStatus.equals(GameStatus.LOSE)) {
            return "O".repeat(userPath.size() - 1) + "X";
        }
        return "O".repeat(userPath.size());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getUserPath(), bridgeGame.getGameStatus());
        printSuccess(bridgeGame.getGameStatus());
        printTryCount(bridgeGame.getTryCount());
    }

    private void printSuccess(GameStatus gameStatus) {
        StringBuilder base = new StringBuilder("게임 성공 여부: ");
        if (gameStatus.equals(GameStatus.LOSE)) {
            System.out.println(base.append("실패"));
        }
        if (gameStatus.equals(GameStatus.WIN)) {
            System.out.println(base.append("성공"));
        }
    }

    private void printTryCount(int tryCount) {
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printGreeting() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInputMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoveInputMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetryInputMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
