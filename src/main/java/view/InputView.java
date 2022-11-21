package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static final String GET_BRIDE_LENGTH = "다리 길이를 입력해주세요.";
    static final String GET_MOVE_POSITION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String GET_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */ //이후 유효성 검사 컨트롤러로 옮겨야함
    public static int readBridgeSize() {
        System.out.println(GET_BRIDE_LENGTH);
        String brideLength = Console.readLine();
        try {
            return Integer.parseInt(brideLength);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("다리의 개수는 숫자만 입력해야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(GET_MOVE_POSITION);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(GET_GAME_COMMAND);
        return Console.readLine();
    }
}
