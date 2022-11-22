package bridge.View;

import bridge.Controller.Validation;
import bridge.Domain.BridgeRow;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    public static String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. ";
    public static final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + Validation.GAME_RETRY + ", 종료: " + Validation.GAME_QUIT + ")";

    public InputView(){
        INPUT_MOVING_MESSAGE += "(";
        for(int index = BridgeRow.getBridgeRowNumber()-1; index > 0; index--){
            INPUT_MOVING_MESSAGE += BridgeRow.getExplainUsingNumber(index) + ": " + BridgeRow.getRowUsingNumber(index) + ", ";
        }
        INPUT_MOVING_MESSAGE += BridgeRow.getExplainUsingNumber(0) + ": " + BridgeRow.getRowUsingNumber(0) +")";
    }
    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        String bridgeSize = readLine();
        Validation.validateReadBridgeSize(bridgeSize);
        System.out.println();
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING_MESSAGE);
        String moving = readLine();
        Validation.validateReadMoving(moving);
        return moving;
    }

    public String readGameCommand() {
        System.out.println(INPUT_RETRY_MESSAGE);
        String gameCommand = readLine();
        Validation.validateReadGameCommand(gameCommand);
        return gameCommand;
    }
}
