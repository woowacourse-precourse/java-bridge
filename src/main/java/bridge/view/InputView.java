package bridge.view;

import bridge.util.Validation;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESET_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final Validation validation;

    public InputView() {
        this.validation = new Validation();
    }

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public int readBridgeSize() {
        System.out.println(INPUT_LENGTH_MESSAGE);
        String inputSize = readLine();
        try{
            validation.isValidateSize(inputSize);
            return Integer.parseInt(inputSize);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        return readBridgeSize();
    }

    public String readMoving() {
        System.out.println(INPUT_MOVE_MESSAGE);
        String inputMove = readLine();
        try{
            validation.isValidateMove(inputMove);
            return inputMove;
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        return readMoving();
    }

    public String readGameCommand() {
        System.out.println(INPUT_RESET_COMMAND_MESSAGE);
        String inputCommand = readLine();
        try{
            validation.isValidateCommand(inputCommand);
            return inputCommand;
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        return readGameCommand();
    }
}
