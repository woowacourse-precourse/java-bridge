package bridge;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String ENTER_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String RESTART_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try{
            System.out.println(ENTER_BRIDGE_SIZE);
            int bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize < 3 | bridgeSize > 20){
                System.out.println("[ERROR] 다리 길이는 3이상 20이사의 숫자를 입력할 수 있습니다.");
                return readBridgeSize();
            }
            return bridgeSize;
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력가능합니다.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(ENTER_UP_OR_DOWN);
        String selectMove = Console.readLine();
        return selectMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(RESTART_GAME);
        try{
            return Console.readLine();
        } catch (NoSuchElementException e){
            System.out.println("[ERROR] 입력 값이 없어 종료합니다.");
            return "Q";
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] R(재시작)과 q(종료) 중 하나의 문자를 입력할 수 있습니다.");
            return readGameCommand();
        }
    }
}
