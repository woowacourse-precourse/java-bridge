package bridge.outputView;

import bridge.bridgeGame.BridgeGame;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String SPACE_VALUE = " ";
    private static final String WALL_VALUE = " | ";
    private static final String OPEN_VALUE = "[";
    private static final String CLOSE_VALUE = "]";

    public static void println(String letter) {
        System.out.println(letter);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame game) {
        printMap(game.getGameLog().getBridges());
    }

    public void printMap(List<List<String>> logs) {
        StringBuffer message = new StringBuffer();
        for (int i = 0; i < logs.size(); i++) {
            message.append(OPEN_VALUE);
            getValue(logs.get(i), message);
            message.append(CLOSE_VALUE);
            message.append("\n");
        }
        System.out.println(message);
    }

    private void getValue(List<String> log, StringBuffer message) {
        message.append(SPACE_VALUE);
        for (int j = 0; j < log.size(); j++) {
            message.append(log.get(j));
            addMessage(j != log.size() - 1, message, WALL_VALUE);
            addMessage(j == log.size() - 1, message, SPACE_VALUE);
        }
    }

    private void addMessage(boolean isAdd, StringBuffer message, String addLetter) {
        if (isAdd) {
            message.append(addLetter);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        printResult(game.getBridges().isEmpty(), game.getGameLog().getCount());
    }

    public void printResult(boolean isEnd, long count) {
        System.out.println("최종 게임 결과");
        System.out.printf("게임 성공 여부: %s\n총 시도한 횟수: %d\n", isSuccess(isEnd), count);
    }

    private String isSuccess(boolean isEnd) {
        if (isEnd) {
            return "성공";
        }
        return "실패";
    }
}
