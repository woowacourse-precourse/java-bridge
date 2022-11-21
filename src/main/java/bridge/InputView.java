package bridge;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String EMPTY_STRING = "";
    private static final String TEXT_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String PROMPT_FOR_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    public void printGameStart() {
        System.out.println(TEXT_GAME_START);
    }

    public void printPromptForBridgeSize() {
        System.out.println(PROMPT_FOR_BRIDGE_SIZE);
    }

    public String readBridgeSize() {
        String bridgeSizeInput;

        try {
            bridgeSizeInput = readLine();
        } catch (NoSuchElementException exception) {
            bridgeSizeInput = EMPTY_STRING;
        }

        return bridgeSizeInput;
    }

    public String readMoving() {
        String moving;

        try {
            moving = readLine();
        } catch (NoSuchElementException exception) {
            moving = EMPTY_STRING;
        }

        return moving;
    }

    public String readGameCommand() {
        return null;
    }
}
