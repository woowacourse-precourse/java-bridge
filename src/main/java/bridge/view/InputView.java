package bridge.view;

// 여기서만 사용자의 입력을 받을 수 있음
// 패키지 변경 가능
// 메서드의 시그니처(인자, 이름)와 반환 타입 변경 가능
// 사용자의 값 입력을 위해 필요한 메서드 추가 가능

import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요");
        String bridgeSize = Console.readLine();
        try {
            new Validation().validateBridgeSize(bridgeSize);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        try {
            new Validation().validateMoving(moving);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        try {
            new Validation().validateGameCommand(gameCommand);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            this.readGameCommand();
        }
        return gameCommand;
    }
}
