package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int readBridgeSize() throws IllegalArgumentException {
        String size = Console.readLine();
        validateBridgeSize(size);

        return Integer.parseInt(size);
    }

    private void validateBridgeSize(String size) throws IllegalArgumentException {
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

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String move = Console.readLine();
        validateMoving(move);
        return move;
    }

    private void validateMoving(String move) throws IllegalArgumentException {
        if(!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
