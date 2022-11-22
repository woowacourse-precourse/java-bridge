package bridge.view;

import bridge.domain.GameResult;
import bridge.domain.GameSession;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String MSG_START = "다리 건너기 게임을 시작합니다.\n";
    private final String MSG_INPUT_LENGTH = "다리의 길이를 입력해주세요.";
    private final String MSG_CHOOSE_CELL = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String MSG_CHOOSE_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String MSG_FINAL_RESULT = "최종 게임 결과";
    private final String MSG_GAME_SUCCEED = "게임 성공 여부: ";
    private final String MSG_TRIAL = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(MSG_START);
    }

    public void printInputLength() {
        System.out.println(MSG_INPUT_LENGTH);
    }

    public void printInputChooseCell() {
        System.out.println(MSG_CHOOSE_CELL);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map, List<String> step) {
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();
        openCasing(up, down);
        markFootStep(map, step, up, down);
        closeCasing(up, down);
        printMoveResult(up, down);

    }

    private void printMoveResult(StringBuilder up, StringBuilder down) {
        System.out.println(up);
        System.out.println(down);
    }

    private void markFootStep(List<String> map, List<String> step, StringBuilder up, StringBuilder down) {
        for (int i = 0; i < step.size(); i++) {
            String mark = "";
            mark = markSuccessOrFail(map, step, i, mark);
            printMarkOnTrail(step, up, down, i, mark);
            printSpacer(step, up, down, i);
        }
    }

    private void printSpacer(List<String> step, StringBuilder up, StringBuilder down, int i) {
        if (i != step.size() - 1) {
            up.append("| ");
            down.append("| ");
        }
    }

    private void printMarkOnTrail(List<String> step, StringBuilder up, StringBuilder down, int i, String mark) {
        if (step.get(i).equals("U")) {
            up.append(mark);
            down.append("  ");
        }

        if (step.get(i).equals("D")) {
            up.append("  ");
            down.append(mark);
        }
    }

    private String markSuccessOrFail(List<String> map, List<String> step, int i, String mark) {
        if (step.get(i).equals(map.get(i))) {
            mark = "O ";
        }
        if (!step.get(i).equals(map.get(i))) {
            mark = "X ";
        }
        return mark;
    }

    private void closeCasing(StringBuilder up, StringBuilder down) {
        up.append("]");
        down.append("]");
    }

    private void openCasing(StringBuilder up, StringBuilder down) {
        up.append("[ ");
        down.append("[ ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> map, GameSession gameSession, GameResult result) {

        System.out.println(MSG_FINAL_RESULT);
        printMap(map, gameSession.getStep());
        System.out.print(MSG_GAME_SUCCEED);
        printGameResult(result);
        System.out.println(MSG_TRIAL + gameSession.getTrial());
    }

    private void printGameResult(GameResult result) {
        String successOrFail = "";
        if (result == GameResult.succeed) {
            successOrFail = "성공";
        }
        if (result == GameResult.fail) {
            successOrFail = "실패";
        }
        System.out.println(successOrFail);
    }

    public void printChooseRetry() {
        System.out.println(MSG_CHOOSE_RETRY);
    }
}
