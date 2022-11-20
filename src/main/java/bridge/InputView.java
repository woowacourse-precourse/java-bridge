package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int readBridgeSize() {
        int isize = 0;
        String size = Console.readLine();

        validateBridgeSize(size);
        isize = Integer.parseInt(size);
        validateNumArea(isize);

        return Integer.parseInt(size);
    }

    private void validateNumArea(int data) {
        if(data<3 || data>20) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBridgeSize(String size) {
        for(int i = 0 ; i < size.length() ; i++) {
            if(!Character.isDigit(size.charAt(i))) {
                throw new IllegalArgumentException();
            }
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

    public boolean readGameCommand() {
        String command = Console.readLine();
        validateCommand(command);
        if(command.equals("R")) {
            return true;
        }
        return false;
    }

    private void validateCommand(String command) {
        if(!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException();
        }
    }
}
