package bridge.outputView;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String DEFAULT_VALUE = " ";

    public static void println(String letter) {
        System.out.println(letter);
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> logs) {
        final int maxSize = getMaxSize(logs);
        StringBuffer message = new StringBuffer();
        for (int i = 0; i < logs.size(); i++) {
            message.append("[");
            getValue(logs.get(i), maxSize, message);
            message.append("]");
            message.append("\n");
        }
        System.out.println(message);
    }

    private void getValue(List<String> log, int maxSize, StringBuffer message) {
        message.append(" ");
        for (int j = 0; j < maxSize; j++) {
            message.append(log.get(j));
            if (j != maxSize - 1) {
                message.append(" | ");
            }
            if (j == maxSize - 1) {
                message.append(" ");
            }
        }
    }

    private int getMaxSize(List<List<String>> logs) {
        int maxSize = 0;
        for (int i = 0; i < logs.size(); i++) {
            maxSize = Math.max(maxSize, logs.get(i).size());
        }
        return maxSize;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isEnd, long count) {
        System.out.println("최종 게임 결과");
        System.out.printf("게임 성공 여부: %s\n 총 시도한 횟수: %d\n", isSuccess(isEnd), count);
    }

    private String isSuccess(boolean isEnd) {
        if (isEnd) {
            return "성공";
        }
        return "실패";
    }
}
