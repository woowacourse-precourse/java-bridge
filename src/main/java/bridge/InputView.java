package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int readBridgeSize() {
        int num = 0;
        try {
            num = read();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : Please input valid argument!");
            return readBridgeSize();
        }
        return num;
    }

    private int read() {
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
        String cmd;
        try {
            cmd = moving();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : Please input valid argument!");
            return readMoving();
        }
        return cmd;
    }

    private String moving() {
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
        boolean value;
        try {
            value = gameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : Please input valid argument!");
            return readGameCommand();
        }
        return value;
    }

    private boolean gameCommand() {
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
