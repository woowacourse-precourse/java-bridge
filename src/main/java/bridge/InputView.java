package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String INPUT_BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String INPUT_BRIDGE_SIZE_TYPE_ERROR = "[ERROR] 숫자로 입력해야 합니다.";
    private final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_MOVING_ERROR = "[ERROR] 입력은 U 또는 D여야 합니다.";
    private final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String INPUT_GAME_COMMAND_ERROR = "[ERROR] 입력은 R 또는 Q여야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String input = Console.readLine();
        inputCheckNumberException(input);
        int bridgeSize = Integer.parseInt(input);
        if(bridgeSize < 3 || 20 < bridgeSize)
            inputIllegalArgumentException(this.INPUT_BRIDGE_SIZE_ERROR);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveInput = inputComment(this.INPUT_MOVING);
        if(!moveInput.equals("U") && !moveInput.equals("D"))
            inputIllegalArgumentException(this.INPUT_MOVING_ERROR);
        return moveInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String retryInput = inputComment(this.INPUT_GAME_COMMAND);
        if(!retryInput.equals("R") && !retryInput.equals("Q"))
            inputIllegalArgumentException(this.INPUT_GAME_COMMAND_ERROR);
        if(retryInput.equals("R"))
            return true;
        return false;
    }

    public String inputComment(String inputSentence) {
        System.out.println(inputSentence);
        String input = Console.readLine();
        return input;
    }

    public void inputIllegalArgumentException(String exceptionSentence) {
        System.out.println(exceptionSentence);
        throw new IllegalArgumentException();
    }

    public void inputCheckNumberException(String input){
        boolean check = checkNumber(input);
        if(!check) {
            System.out.println(INPUT_BRIDGE_SIZE_TYPE_ERROR);
            throw new NoSuchElementException();
        }
    }

    public boolean checkNumber(String input) {
        if(input.equals(""))
            return false;
        for(int i = 0; i < input.length(); i++) {
            char checkNumber = input.charAt(i);
            if(checkNumber < 48 || checkNumber > 58)
                return  false;
        }
        return true;
    }
}
