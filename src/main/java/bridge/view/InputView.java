package bridge.view;

import bridge.util.Validation;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GAME_START_SENTENCE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESET_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final Validation validation;

    public InputView() {
        this.validation = new Validation();
    }

    public void printStartMessage() {
        System.out.println(GAME_START_SENTENCE);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println(INPUT_LENGTH_MESSAGE);
        String inputLength = readLine();
        try{
            validation.isValidateSize(inputLength);
            return Integer.parseInt(inputLength);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return readBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_MESSAGE);
        String inputMove = readLine();
        try{
            validation.isValidateMove(inputMove);
            return inputMove;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RESET_COMMAND_MESSAGE);
        String inputCommand = readLine();
        try{
            validation.isValidateCommand(inputCommand);
            return inputCommand;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return readGameCommand();
    }
}
