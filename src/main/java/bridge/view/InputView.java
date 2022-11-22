package bridge.view;

import bridge.message.ExceptionMessage;
import bridge.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        out(InputMessage.START_GAME);
        blank();
        out(InputMessage.INPUT_BRIDGE_SIZE);
        int inputNum = validate();
        numberRange(inputNum);
        blank();
        return inputNum;
    }

    private int validate() {
        int inputNum = 0;
        while (true) {
            String input = Console.readLine();
            try {
                inputNum = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                out(ExceptionMessage.NOT_INTEGER);
            }
        }
        return inputNum;
    }
    private void numberRange(int inputNum) {
        if (!(3<=inputNum && inputNum<=20)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE);
        }
    }
    public String readMoving() {
        out(InputMessage.INPUT_MOVING);
        String input = Console.readLine();
        rightMove(input);
        return input;
    }
    private void rightMove(String input) {
        if(!(input.equals("U")||input.equals("D"))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_RIGHT_MOVE);
        }
    }
    public String readGameCommand() {
        out(InputMessage.INPUT_GAME_COMMAND);
        String input = Console.readLine();
        rightCommand(input);
        return input;
    }
    private void rightCommand(String input) {
        if(!(input.equals("R")||input.equals("Q"))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_RIGHT_COMMAND);
        }
    }
    private void out(String text) {
        System.out.println(text);
    }

    private void blank() {
        System.out.println();
    }
}
