package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n\n"
                + "다리의 길이를 입력해주세요.");
        return Console.readLine();
    }


    /** 다리의 길이를 입력받는다. (예외) **/

    private void exceptionCheckInt(String userInputSize) {
        try {
            if (!integerTrue(userInputSize)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 숫자를 입력해주세요. ");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }
    }

    private boolean integerTrue(String userInputSize) {
        try {
            Integer.parseInt(userInputSize);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void exceptionRangeCheck(int bridgeSize) {
        try {
            if (!(bridgeSize >= 3 && bridgeSize <= 20)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] bridge 사이즈를 3~20사이로 입력해주세요.");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();

        return moving;
    }

    /** 사용자가 이동할 칸을 입력받는다. (예외) **/

    private void exeptionWordCheck(String moving){
        try{
            if(!(moving.equals("D")||moving.equals("U"))){
                throw new IllegalArgumentException();
            }
        }catch(Exception IllegalArgumentException){
            System.out.println("[ERROR] U,D 둘 중 하나의 문자만 입력해주세요. (U :위, D : 아래)");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        return gameCommand;
    }
}
