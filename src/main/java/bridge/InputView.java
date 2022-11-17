package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 람다식을 true 값이 나올 때까지 반복시켜주는 메소드
     * @param thing true 가 나올 때까지 반복하고 싶은 람다식(Loopable 인터페이스를 받는)
     * @return true 값이 나온 입력
     */
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
    public static String readMoving() {
        Loopable checkMovementInput = (s) -> {
          try {
              return ValidateInput.isUorD(s);
          }catch (IllegalArgumentException e){
              System.out.println("[ERROR] " + e.getMessage());
              return false;
          }
        };
        return loop(checkMovementInput);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        Loopable checkGameCommandInput = (s) -> {
          try {
              return ValidateInput.isRorQ(s);
          }catch (IllegalArgumentException e){
              System.out.println("[ERROR] " + e.getMessage());
              return false;
          }
        };
        return loop(checkGameCommandInput);
    }
}
