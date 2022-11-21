package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    public int readBridgeSize() {
        //다리의 길이를 입력받는다.
        int bridgeSize = Integer.parseInt(Console.readLine());
        //예외처리. 숫자여자하고, 3부터 20사이어야함. ex) [ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
        return bridgeSize;
    }


    public String readMoving() {
        //사용자가 이동할 칸을 입력받는다.
        String moving = Console.readLine();
        //예외처리. [ERROR] 이동할 칸(U, D)중 하나의 문자를 입력해주세요.
        return moving;
    }


    public String readGameCommand() {
        //사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
        String gameCommand = Console.readLine();
        //예외처리. [ERROR] 재시작/종료 여부(R, Q)중 하나의 문자를 입력해주세요.
        return gameCommand;
    }
}
