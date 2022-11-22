package bridge.view;

import bridge.system.SystemValue;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");

        String input = Console.readLine();
        System.out.println();
        validateOfBridgeSize(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        validateForUpAndDown(input);
        return input;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        validateForRetryOrQuit(input);
        return input;
    }

    private void validateOfBridgeSize(String input) {
        validateForConsistOfNumber(input);
        validateForRangeOfNumber(input);
    }

    private void validateForConsistOfNumber(String text) {
        Pattern pattern = Pattern.compile(SystemValue.REGEX_CONSIST_NUMBER);
        if (!pattern.matcher(text).matches()) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력 값이 숫자가 아닙니다.");
        }
    }

    private void validateForRangeOfNumber(String text) {
        int num = Integer.parseInt(text);
        if (num < SystemValue.MIN_RANGE_BRIDGE_SIZE || num > SystemValue.MAX_RANGE_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력 값이 3이상 20이하의 숫자가 아닙니다.");
        }
    }

    private void validateForUpAndDown(String text) {
        Pattern pattern = Pattern.compile(SystemValue.REGEX_CONSIST_UD);
        if (!pattern.matcher(text).matches()) {
            throw new IllegalArgumentException("[ERROR] 다리 선택 입력 값이 정해진 U, D 값이 아닙니다.");
        }
    }

    private void validateForRetryOrQuit(String text) {
        Pattern pattern = Pattern.compile(SystemValue.REGEX_CONSIST_RQ);
        if (!pattern.matcher(text).matches()) {
            throw new IllegalArgumentException("[ERROR] 재시도 입력 값이 정해진 R, Q 값이 아닙니다.");
        }
    }
}
