package bridge.view;

import static bridge.Controller.GAME_FAIL;
import static bridge.Controller.GAME_FINISH;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder up;
    private StringBuilder down;

    public OutputView() {
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    private void initMap() {
        up = new StringBuilder();
        down = new StringBuilder();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String pos, int bridgeIndex, int moveState) {
        setMap(bridgeIndex);
        saveMap(pos, moveState);
        printSaveAll();
    }

    private void setMap(int bridgeIndex) {
        if (bridgeIndex == 0) {
            initMap();
            return;
        }
        up.append(" | ");
        down.append(" | ");
    }

    private void saveMap(String pos, int moveState) {
        if (moveState == GAME_FAIL) {
            saveFail(pos);
            return;
        }
        saveSuccess(pos);
    }

    private void saveFail(String pos) {
        if (pos.equals("U")) {
            up.append("X");
            down.append(" ");
            return;
        }
        up.append(" ");
        down.append("X");
    }

    private void saveSuccess(String pos) {
        if (pos.equals("U")) {
            up.append("O");
            down.append(" ");
            return;
        }
        up.append(" ");
        down.append("O");
    }

    private void printSaveAll() {
        System.out.println("[ " + up + " ]");
        System.out.println("[ " + down + " ]\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int moveState, int cnt) {
        System.out.println("최종 게임 결과");
        printSaveAll();
        System.out.println("게임 성공 여부: " + isSuccess(moveState));
        System.out.println("총 시도한 횟수: " + cnt);
    }

    private String isSuccess(int moveState) {
        if (moveState == GAME_FINISH) {
            return "성공";
        }
        return "실패";
    }
}
