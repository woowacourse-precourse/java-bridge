package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        int size = validateBridgeSize(input);
        return size;
    }

    public int validateBridgeSize(String input){
        if(!input.matches(InputRegex.BridgeSize.getRegex()))
            throw new IllegalArgumentException();
        int size = Integer.parseInt(input);
        if(GameSetting.MIN_BIRDGE_SIZE>size || size>GameSetting.MAX_BIRDGE_SIZE)
            throw new IllegalArgumentException();

        return size;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        validateMoving(input);
        return input;
    }

    public void validateMoving(String input){
        if(!input.matches(InputRegex.Moving.getRegex()))
            throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        validateGameCommand(input);
        return input;
    }
    public void validateGameCommand(String input){
        if(!input.matches(InputRegex.GameCommand.getRegex()))
            throw new IllegalArgumentException();
    }
}
