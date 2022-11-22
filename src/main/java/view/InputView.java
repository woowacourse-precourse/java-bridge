package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Validator;

public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_PLACE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        String bridgeSize;

        do {
            System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
            bridgeSize = Console.readLine();
            System.out.println();
        } while (!Validator.isValidBridgeSize(bridgeSize));

        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String movingPlace;

        do {
            System.out.println(MOVING_PLACE_INPUT_MESSAGE);
            movingPlace = Console.readLine();
        } while (!Validator.isValidMovingPlace(movingPlace));

        return movingPlace;
    }

    public String readGameCommand() {
        String gameCommand;

        do {
            System.out.println(GAME_COMMAND_INPUT_MESSAGE);
            gameCommand = Console.readLine();
        } while (!Validator.isValidGameCommand(gameCommand));

        return gameCommand;
    }
}
