package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Validator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_PLACE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize;

        do {
            System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
            bridgeSize = Console.readLine();
        } while (!Validator.isValidBridgeSize(bridgeSize));

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingPlace;

        do {
            System.out.println(MOVING_PLACE_INPUT_MESSAGE);
            movingPlace = Console.readLine();
        } while (!Validator.isValidMovingPlace(movingPlace));

        return movingPlace;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand;

        do {
            System.out.println(GAME_COMMAND_INPUT_MESSAGE);
            gameCommand = Console.readLine();
        } while (!Validator.isValidGameCommand(gameCommand));

        return gameCommand;
    }
}
