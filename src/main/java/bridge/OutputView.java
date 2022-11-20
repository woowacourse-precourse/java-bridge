package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printRequestInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printRequestInputMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D).");
    }

    public void printRequestInputRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map, List<String> userSelect) {
        printMapUpDown(map, userSelect, true);
        printMapUpDown(map, userSelect, false);
        System.out.println("");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        System.out.println("최종 게임 결과");
        this.printMap(game.getMap(), game.getUserSelect());
        System.out.println("게임 성공 여부: " + this.getGameResult(game.isFailed()));
        System.out.println("총 시도한 횟수: " + game.getTryCount());
    }

    public String getGameResult(boolean failed) {
        if (failed)
            return "실패";
        return "성공";
    }

    private void printMapUpDown(List<String> map, List<String> userSelect, boolean up) {
        System.out.print("[ ");
        this.printMapInner(map, userSelect, up);
        System.out.println(" ]");
    }

    private void printMapInner(List<String> map, List<String> userSelect, boolean up) {
        for (int i = 0; i < userSelect.size(); i++) {
            System.out.print(this.getMapItemString(map.get(i), userSelect.get(i), up));
            if (i != userSelect.size() - 1)
                System.out.print(" | ");
        }
    }

    private String getMapItemString(String map, String userSelect, boolean up) {
        if ((up && userSelect.equals("D")) || (!up && userSelect.equals("U")))
            return " ";
        else if ((up && userSelect.equals("U") && map.equals("U")) || (!up && userSelect.equals("D") && map.equals("D")))
            return "O";
        return "X";
    }
}
