package bridge.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        String bridgeSize = readLine();
        System.out.println();
        //validation
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING_MESSAGE);
        String moving = readLine();
        //validation
        return moving;
    }

    public String readGameCommand() {
        System.out.println(INPUT_RETRY_MESSAGE);
        String gameCommand = readLine();
        //validation
        return gameCommand;
    }
}
