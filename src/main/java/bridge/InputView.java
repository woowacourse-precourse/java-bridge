package bridge;

import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalAccessException {
        String size = scanner.nextLine();
        validate(size);

        return Integer.parseInt(size);
    }

    private void validate(String size) throws IllegalAccessException {
        int isize;
        for(int i = 0 ; i < size.length() ; i++) {
            if(!Character.isDigit(size.charAt(i))) {
                throw new IllegalAccessException();
            }
        }
        isize = Integer.parseInt(size);
        if(isize<3 || isize>20) {
            throw new IllegalAccessException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
