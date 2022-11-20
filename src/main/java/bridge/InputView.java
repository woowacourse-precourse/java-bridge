package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int readBridgeSize() {
        String size = Console.readLine();
        validateBridgeSize(size);

        return Integer.parseInt(size);
    }

    private void validateBridgeSize(String size) {
        int isize;
        for(int i = 0 ; i < size.length() ; i++) {
            if(!Character.isDigit(size.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        isize = Integer.parseInt(size);
        if(isize<3 || isize>20) {
            throw new IllegalArgumentException();
        }
    }

    public String readMoving() {
        String move = Console.readLine();
        validateMoving(move);
        return move;
    }

    private void validateMoving(String move) {
        if(!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException();
        }
    }

    public String readGameCommand() {
        String command = Console.readLine();
        validateCommand(command);
        return command;
    }

    private void validateCommand(String command) {
        if(!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException();
        }
    }
}
