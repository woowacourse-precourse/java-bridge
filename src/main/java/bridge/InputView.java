package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String REGEX = "[0-9]+";
    private final int minLength = 3;
    private final int maxLength = 20;
    private final String msg_BridgeSize = "다리의 길이를 입력해주세요.";
    private final String msg_Moving = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String msg_GameCommand = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String errorMsg_SmallSize = "다리의 길이는 3보다 작을 수 없습니다.";
    private final String errorMsg_BigSize = "다리의 길이는 20보다 클 수 없습니다.";
    private final String errorMsg_NotNumber = "다리의 길이는 숫자로 작성해주셔야 합니다.";
    private final String errorMsg_UpAndDown = "이동 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력하셔야 합니다.";
    private final String errorMsg_RetryAndQuit = "게임 재시도는 R(재시도)와 Q(종료) 중 하나의 문자를 입력하셔야 합니다.";

    //region 다리길이
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(msg_BridgeSize);
        String input = Console.readLine();
        validateSize(input);
        return Integer.valueOf(input);
    }

    private void validateSize(String input) {
        try {
            checkOnlyNumber(input);
            checkSize(input);
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            readBridgeSize();
        }
    }

    private void checkSize(String input) {
        int size = Integer.valueOf(input);
        if(size < minLength)
            throw new IllegalArgumentException(errorMsg_SmallSize);

        if(size > maxLength)
            throw new IllegalArgumentException(errorMsg_BigSize);
    }

    private void checkOnlyNumber(String input) {
        if(!input.matches(REGEX))
            throw new IllegalArgumentException(errorMsg_NotNumber);
    }
    //endregion

    //region 이동
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(msg_Moving);
        String input = Console.readLine();
        ValidateMove(input);
        return input;
    }

    private void ValidateMove(String input) {
        try {
            checkUpOrDown(input);
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            readMoving();
        }
    }

    private void checkUpOrDown(String input) {
        if (!input.equals("U") && !input.equals("D"))
            throw new IllegalArgumentException(errorMsg_UpAndDown);
    }
    //endregion

    //region 재시도 여부
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(msg_GameCommand);
        String input = Console.readLine();
        ValidateGameCommand(input);
        return input;
    }

    private void ValidateGameCommand(String input) {
        try{
            checkRetryAndQuit(input);
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            readGameCommand();
        }
    }

    private void checkRetryAndQuit(String input) {
        if (!input.equals("R") && !input.equals("Q"))
            throw new IllegalArgumentException(errorMsg_RetryAndQuit);
    }
    //endregion
}
