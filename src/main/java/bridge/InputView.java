package bridge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String BRIDGE_SIZE_FORMAT = "[1-9]\\d?";
    private static final Set<String> UP_DOWN = new HashSet<>(List.of("U", "D"));
    private static final Set<String> RESTART_QUIT = new HashSet<>(List.of("R", "Q"));

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public int readBridgeSize() {
        try {
            System.out.println("\n다리의 길이를 입력해주세요.");
            String input = readLine();
            validateBridgeSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = readLine();
            validateMoving(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = readLine();
            validateGameCommand(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private void validateBridgeSize(String input) {
        if (!input.matches(BRIDGE_SIZE_FORMAT)) {
            throw new IllegalArgumentException("[ERROR] 한 자리 또는 두 자리 숫자만 입력해주세요.");
        }
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < MIN_SIZE || bridgeSize > MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 3 ~ 20 사이의 수만 입력해주세요.");
        }
    }

    private void validateMoving(String input) {
        if (!UP_DOWN.contains(input)) {
            throw new IllegalArgumentException("[ERROR] U, D만 입력해주세요.");
        }
    }

    private void validateGameCommand(String input) {
        if (!RESTART_QUIT.contains(input)) {
            throw new IllegalArgumentException("[ERROR] R, Q만 입력해주세요.");
        }
    }
}
