package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String WORD_UP = WordCollection.WORD_UP.getWord();
    private static final String WORD_DOWN = WordCollection.WORD_DOWN.getWord();
    private static final String WORD_RESTART = WordCollection.WORD_RESTART.getWord();
    private static final String WORD_QUIT = WordCollection.WORD_QUIT.getWord();
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECT_UP_OR_DOWN =
            String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", WORD_UP, WORD_DOWN);
    private static final String INPUT_RESTART_OR_QUIT =
            String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", WORD_RESTART, WORD_QUIT);

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            System.out.println(INPUT_BRIDGE_SIZE);
            String bridgeSize = Console.readLine();
            if (!validateReadBridgeSize(bridgeSize))
                continue;
            return Integer.parseInt(bridgeSize);
        }
    }

    private boolean validateReadBridgeSize(String bridgeSize) {
        try {
            Validation.isInputIncludeCharacter(bridgeSize);
            Validation.isInputBetweenMinAndMax(Integer.parseInt(bridgeSize));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println(INPUT_SELECT_UP_OR_DOWN);
            String moving = Console.readLine();
            if (!validateReadMoving(moving))
                continue;
            return moving;
        }
    }

    private boolean validateReadMoving(String moving) {
        try {
            Validation.isInputUpOrDown(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            System.out.println(INPUT_RESTART_OR_QUIT);
            String gameCommand = Console.readLine();
            if (!validateReadGameCommand(gameCommand))
                continue;
            return gameCommand;
        }
    }

    private boolean validateReadGameCommand(String gameCommand) {
        try {
            Validation.isInputRestartOrQuit(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
