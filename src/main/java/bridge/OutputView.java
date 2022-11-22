package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String startText = "다리 건너기 게임을 시작합니다.";
    private final String bridgeSizeInputText = "\n다리의 길이를 입력해주세요.";
    private final String movingInputText = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String commandInputText =
            "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String resultText = "\n최종 게임 결과";
    private final String isClearText = "\n게임 성공 여부: ";
    private final String totalTryText = "총 시도한 횟수: ";
    private final String errorText = "[ERROR] ";
    /**
     * 게임 시작 문구를 출력한다.
     */
    public void printStart() {
        System.out.println(startText);
    }

    /**
     * 다리 길이를 입력받는 문구를 출력한다.
     */
    public void printBridgeSizeInput() {
        System.out.println(bridgeSizeInputText);
    }

    /**
     * 이동할 칸을 선택받는 문구를 출력한다.
     */
    public void printMoveInput() {
        System.out.println(movingInputText);
    }

    /**
     * 게임을 재시도할지 종료할지 입력받는 문구를 출력한다.
     */
    public void printCommandInput() {
        System.out.println(commandInputText);
    }

    /**
     * 에러 문구를 에러 메시지와 함께 출력한다.
     */
    public void printError(String errorMessage) {
        System.out.println(errorText + errorMessage);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MoveRecord moveRecord) {
        List<String> results = moveRecord.toResultString();
        System.out.println(results.get(0) + "\n" + results.get(1));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MoveRecord moveRecord, Integer totalTry, boolean isClear) {
        System.out.println(resultText);
        printMap(moveRecord);
        if (isClear) {
            System.out.println(isClearText + "성공");
            System.out.println(totalTryText + totalTry.toString());
        }
        if (!isClear) {
            System.out.println(isClearText + "실패");
            System.out.println(totalTryText + totalTry.toString());
        }
    }
}
