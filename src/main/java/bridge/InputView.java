package bridge;

import bridge.utils.Validation;
import camp.nextstep.edu.missionutils.Console;

/** 패키지 변경가능. 메서드의 인자와 이름, 반환타입 변경가능. 메서드 추가가능.
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String bridgeSize = Console.readLine();
            return Validation.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = Console.readLine();
            return Validation.validateMoving(moving);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String restartAnswer = Console.readLine();
            return Validation.validateRestartInput(restartAnswer);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readGameCommand();
        }

    }
}
