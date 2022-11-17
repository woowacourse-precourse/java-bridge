package bridge.UI.Input;


import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자가 아닌 숫자를 입력해주세요.");
        }
        if((bridgeSize < 3) || (20 < bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 3과 20 사이의 숫자를 입력해주세요");
        }
        return bridgeSize;
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     *
     * 메서드의 인자와 이름 그리고 반환 타입을 변경할 수 있다.
     */
    public String readMoving() {
        String userInput = Console.readLine();
        if(!(userInput.equals("U") || userInput.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 혹은 D를 입력해주세요");
        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     *
     * 메서드의 인자와 이름 그리고 반환 타입을 변경할 수 있다.
     */
    public String readGameCommand() {
        //TODO : R,Q가 아니면 예외
        return null;
    }
}

//필요한 메서드 추가할 수 있다.