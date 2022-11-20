package bridge;

import java.util.List;

import static bridge.DIRECTION.DOWN;
import static bridge.DIRECTION.UP;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<DIRECTION> bridge, int currentIdx, DIRECTION guess) {
        StringBuffer up = new StringBuffer("[");
        StringBuffer down = new StringBuffer("[");
        for (int i = 0; i < currentIdx; i++) {
            appendStatus(bridge.get(i), up, down);
        }
        List<String> last = appendLast(bridge.get(currentIdx).equals(guess), guess);
        up.append(last.get(0));
        down.append(last.get(1));
        System.out.println(up);
        System.out.println(down);
    }

    private static void appendStatus(DIRECTION bridge, StringBuffer up, StringBuffer down) {
        String success = " O |";
        String fail = "   |";
        if (bridge.equals(UP)) {
            up.append(success);
            down.append(fail);
        }
        if (bridge.equals(DOWN)) {
            up.append(fail);
            down.append(success);
        }
    }

    private static List<String> appendLast(boolean success, DIRECTION guess) {
        String guessResult = " X ]";
        String empty = "   ]";
        if (success) {
            guessResult = " O ]";
        }
        if (guess.equals(UP)) {
            return List.of(guessResult, empty);
        }
        return List.of(empty, guessResult);
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
