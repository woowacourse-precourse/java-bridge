package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 패키지 변경 가능
 * 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 불가
 * 사용자 값 입력을 위해 필요한 메소드를 추가 가능
 */
public class InputView {

    public int readBridgeSize() {
        return Integer.parseInt(Console.readLine());
    }


    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}