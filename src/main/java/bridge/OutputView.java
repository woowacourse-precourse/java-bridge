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
        if (currentIdx < bridge.size()) {
            appendLast(List.of(bridge.get(currentIdx), guess), up, down);
        }
        System.out.println(up);
        System.out.println(down);
    }

    private static void appendStatus(DIRECTION bridge, StringBuffer up, StringBuffer down) {
        String yes = " O |";
        String no = "   |";
        if (bridge.equals(UP)) {
            up.append(yes);
            down.append(no);
        }
        if (bridge.equals(DOWN)) {
            up.append(no);
            down.append(yes);
        }
    }

    private static void appendLast(List<DIRECTION> bridgeGuess, StringBuffer up, StringBuffer down) {
        String guessResult = " X ]";
        if (bridgeGuess.get(0).equals(bridgeGuess.get(1))) {
            guessResult = " O ]";
        }
        if (bridgeGuess.get(1).equals(UP)) {
            upSelect(up, down, guessResult);
            return;
        }
        downSelect(up, down, guessResult);
    }

    private static void downSelect(StringBuffer up, StringBuffer down, String guessResult) {
        up.append("   ]");
        down.append(guessResult);
    }

    private static void upSelect(StringBuffer up, StringBuffer down, String guessResult) {
        up.append(guessResult);
        down.append("   ]");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * 최종 게임 결과, 성공 여부, 총 시도 횟수 출력
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        System.out.println("\n최종 게임 결과");
        printMap(game.getBridge(), game.getCurrentIdx(), game.getGuess());

        System.out.print("\n게임 성공 여부: " + success(game));

        System.out.println("총 시도한 횟수: " + game.getTryCount());
    }

    private static String success(BridgeGame game) {
        if (game.isComplete()) {
            return "성공";
        }
        return "실패";
    }
}
