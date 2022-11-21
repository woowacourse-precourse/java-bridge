package bridge.view;

import bridge.utils.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 게임 시작을 알리는 문구를 출력한다.
     */
    public void printHello(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println("다리의 길이를 입력해주세요.");
        String userInput = readLine();

        Validator.isNumber(userInput);

        System.out.println();
        return Integer.valueOf(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userInput = readLine();

        Validator.isMoveAlpha(userInput);

        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userInput = readLine();

        Validator.isRestart(userInput);

        return userInput;
    }
}
