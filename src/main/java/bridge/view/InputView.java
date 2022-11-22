package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.Validation.*;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 패키지 변경 가능
 * 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 불가
 * 사용자 값 입력을 위해 필요한 메소드를 추가 가능
 */
public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            isNumber(input);
            int tmp = Integer.parseInt(input);
            isInRange(3, tmp, 20);
            return tmp;
        } catch(NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving() {
        String input = Console.readLine();
        try {
            isContain("UD",input);
            return input;
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        String input = Console.readLine();
        try {
            isContain("RQ", input);
            return input;
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}