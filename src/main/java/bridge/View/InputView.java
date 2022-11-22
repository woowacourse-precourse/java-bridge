package bridge.View;

import bridge.Controller.Validation;
import bridge.Domain.BridgeRow;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. ";
    private static final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + Validation.GAME_RETRY + ", 종료: " + Validation.GAME_QUIT + ")";

    public InputView(){
        INPUT_MOVING_MESSAGE += "(";
        for(int index = BridgeRow.getBridgeRowSize() - 1; index > 0; index--){
            INPUT_MOVING_MESSAGE += BridgeRow.getRowNameExplainUsingRowNumber(index) + ": " + BridgeRow.getRowNameUsingRowNumber(index) + ", ";
        }
        INPUT_MOVING_MESSAGE += BridgeRow.getRowNameExplainUsingRowNumber(0) + ": " + BridgeRow.getRowNameUsingRowNumber(0) +")";
    }
    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        String bridgeSize = readLine();
        System.out.println();
        return bridgeSize;
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING_MESSAGE);
        String moving = readLine();
        return moving;
    }

    public String readGameCommand() {
        System.out.println(INPUT_RETRY_MESSAGE);
        String gameCommand = readLine();
        return gameCommand;
    }
}
