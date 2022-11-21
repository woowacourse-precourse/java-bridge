package view;

import domain.Result;
import enums.ResultMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final String divider = "|";
    static final String start = "[";

    static final String end = "]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> up, List<String> down) {
        StringBuilder upStringBuilder = new StringBuilder().append(start);
        StringBuilder downStringBuilder = new StringBuilder().append(start);

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        String resultString = new StringBuilder()
                .append(ResultMessage.GAME_SUCCESS_OR_FAIL.getText()).append(result.getIsSuccess()).append("\n")
                .append(ResultMessage.TOTAL_TRIAL_COUNT.getText()).append(result.getTrial()).append("\n")
                .toString();

        System.out.println(resultString);
    }
}
