package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public InputView() {
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        int size = validateSize(input);

        return size;
    }

    private int validateSize(String input) {
        try{
            int size = Integer.parseInt(input);
            validateRange(3,20,size);

            return size;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] Only numbers allowed");
        }
    }

    private void validateRange(int start, int end, int value){
        if (value < start || value > end){
            System.err.println(new IllegalArgumentException("[ERROR] Numbers should be in the range of"+start+"~"+end));
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        validateReadMoving(input);
        return input;
    }

    private void validateReadMoving(String input){
        if (input.length() != 1){
            System.err.println(new IllegalArgumentException("[ERROR] Input should either be U or D"));
        }
        if (!input.equals("U") && !input.equals("D")){
            System.err.println(new IllegalArgumentException("[ERROR] Input should either be U or D"));
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }

    private void validateGameCommand(String input){
        if (input.length() != 1){
            System.err.println(new IllegalArgumentException("[ERROR] Input should either be R or Q"));
        }
        if (!input.equals("R") && !input.equals("Q")){
            System.err.println(new IllegalArgumentException("[ERROR] Input should either be U or D"));
        }
    }
}
