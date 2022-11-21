package view;

import bridge.BridgeGameMark;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        validateisDigit(bridgeSize);
        validateOverSize(Integer.parseInt(bridgeSize));
        validateisEmpty(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();

        validateUpOrDown(moving);
        validateisEmpty(moving);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String doRestart = Console.readLine();

        validateRestartOrQuit(doRestart);
        validateisEmpty(doRestart);

        return doRestart;
    }

    public void validateOverSize(int bridgeSize){
        if(bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void validateisDigit(String bridgeSize){
        for(int i = 0; i< bridgeSize.length(); i++) {
            if (!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
            }
        }
    }

    public void validateisEmpty(String input){
        if(input.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
            }
        }

    public void validateUpOrDown(String moving){
        if(!moving.equals(BridgeGameMark.UP_MARK.getMark()) && !moving.equals(BridgeGameMark.DOWN_MARK.getMark())){
            throw new IllegalArgumentException("[ERROR] 이동하는 칸은 U 혹은 D 으로만 선택 가능합니다.");
        }
    }

    public void validateRestartOrQuit(String doRestart){
        if(!doRestart.equals(BridgeGameMark.RETRY_MARK.getMark()) && !doRestart.equals(BridgeGameMark.QUIT_MARK.getMark())){
            throw new IllegalArgumentException("[ERROR] 게임 종료 후에는 R 또는 Q만 입력 가능합니다.");
        }
    }
}
