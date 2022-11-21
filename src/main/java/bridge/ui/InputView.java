package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private Integer bridgeLength;
    private static final List<String> CORRECT_MOVING_CASE = new ArrayList(Arrays.asList("D", "U"));
    private boolean invalidMoving = true;
    private String nextMoving;
    private static final List<String> CORRECT_GAME_COMMAND = new ArrayList<>(Arrays.asList("R", "Q"));
    private boolean invalidGameCommand = true;
    private String nextGameCommand;
    private static final String INITIATION_NOTIFICATION = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.";
    private static final String MOVING_NOTIFICATION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_NOTIFICATION = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INITIATION_NOTIFICATION);
        while (bridgeLength == null) {
            receiveLength();
        }

        return bridgeLength;
    }

    private void receiveLength() {
        try {
            String bridgeSize = Console.readLine();
            int sizeNumber = makeSureNumber(bridgeSize);
            checkLengthRange(sizeNumber);
            bridgeLength = sizeNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private int makeSureNumber(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void checkLengthRange(int input) throws IllegalArgumentException{
        if (!(input >= 3 && input <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_NOTIFICATION);
        invalidMoving = true;
        while (invalidMoving) {
            receiveMovingChoice();
        }

        return nextMoving;
    }

    private void receiveMovingChoice() {
        try {
            String movingInput = Console.readLine();
            checkMove(movingInput);
            nextMoving = movingInput;
            invalidMoving = false;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private void checkMove(String input) throws IllegalArgumentException {
        boolean correctCase = CORRECT_MOVING_CASE.contains(input);
        if (!correctCase) {
            throw new IllegalArgumentException("[ERROR] 대문자 'D' 혹은 'U' 만 입력 가능합니다");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_COMMAND_NOTIFICATION);
        invalidGameCommand = true;
        while (invalidGameCommand) {
            receiveGameCommand();
        }

        return nextGameCommand;
    }

    private void receiveGameCommand() {
        try {
            String commandInput = Console.readLine();
            checkGameCommand(commandInput);
            nextGameCommand = commandInput;
            invalidGameCommand = false;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private void checkGameCommand(String command) throws IllegalArgumentException {
        boolean correctCommand = CORRECT_GAME_COMMAND.contains(command);
        if (!correctCommand) {
            throw new IllegalArgumentException("[ERROR] 대문자 'R' 혹은 'Q' 만 입력 가능합니다");
        }
    }
}
