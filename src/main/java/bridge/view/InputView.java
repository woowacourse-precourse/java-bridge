package bridge.view;

import bridge.exception.BridgeChoiceException;
import bridge.exception.BridgeLengthException;
import bridge.exception.GameCommandException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INQUIRE_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INQUIRE_BRIDGE_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INQUIRE_GAME_STOP = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        BridgeLengthException bridgeLengthException = new BridgeLengthException();
        try{
            return bridgeLengthException.validate(readInput(INQUIRE_BRIDGE_LENGTH));
        }catch (IllegalArgumentException exception){
            return readBridgeSize();
        }
    }

    public String readMoving() {
        BridgeChoiceException bridgeChoiceException = new BridgeChoiceException();
        try{
            return bridgeChoiceException.validate(readInput(INQUIRE_BRIDGE_MOVEMENT));
        }catch (IllegalArgumentException exception){
            return readMoving();
        }
    }

    public String readGameCommand() {
        GameCommandException gameCommandException = new GameCommandException();
        try{
            return gameCommandException.validate(readInput(INQUIRE_GAME_STOP));
        }catch (IllegalArgumentException exception){
            return readGameCommand();
        }
    }

    private String readInput(String comment){
        System.out.println(comment);
        return Console.readLine();
    }
}
