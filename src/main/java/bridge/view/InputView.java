package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    OutputView outputView = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printInputSize();
        String input = Console.readLine();
        try{
            checkDigit(input);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    private void checkDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMove();
        String input;
        try{
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printRetry();
        String input;
        try{
            input = Console.readLine();
            checkAlphabet(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return input;
    }
    //수정 고려

    private void checkAlphabet(String input) {
        if (!input.chars().allMatch(Character::isAlphabetic)) {
            throw new IllegalArgumentException("[ERROR] 알파벳을 입력해 주세요.");
        }
    }
}
