package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    // 다리의 길이를 입력
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int gameBridgeLength = Integer.parseInt(Console.readLine());
        System.out.println(gameBridgeLength);
        return gameBridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

// 추가된 요구 사항
// 1.제공된 InputView 클래스를 활용해 구현
// 2.InputView의 패키지는 변경 가능
// 3.InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 가능
// 4.사용자 값 입력을 위해 필요한 메서드 추가 가능