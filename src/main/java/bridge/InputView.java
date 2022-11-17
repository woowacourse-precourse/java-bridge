package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static String loop(Loopable thing){
        String s;
        boolean a;
        do {
            s = readInput();
            a = thing.check(s);
        }while (!a);
        return s;
    }

    private static String readInput(){
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
//    public int readBridgeSize() {
//        String rawInput = readInput();
//
//        ValidateInput.isAllDigit(rawInput);
//        ValidateInput.isInRange(rawInput);
//
//        return Integer.parseInt(rawInput);
//    }

    public static int readBridgeSize() {
        Loopable checkBridgeSizeInput = (s) -> {
            try {
                return ValidateInput.isAllDigit(s) && ValidateInput.isInRange(s);
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
                return false;
            }
        };
        String input = loop(checkBridgeSizeInput);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String rawInput = readInput();

        ValidateInput.isUorD(rawInput);

        return rawInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String rawInput = readInput();

        ValidateInput.isRorQ(rawInput);

        return rawInput;
    }
}
