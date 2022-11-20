package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String REGEX = "[0-9]+";
    private final int minLength = 3;
    private final int maxLength = 20;
    private final String bridgeSize = "다리의 길이를 입력해주세요.";

    //region 다리길이
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(bridgeSize);
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
            System.out.println("[ERROR]" + ex.getMessage());
            readBridgeSize();
        }
    }

    private void checkSize(String input) {
        int size = Integer.valueOf(input);
        if(size < minLength)
            throw new IllegalArgumentException("다리의 길이는 3보다 작을 수 없습니다.");

        if(size > maxLength)
            throw new IllegalArgumentException("다리의 길이는 20보다 클 수 없습니다.");
    }

    private void checkOnlyNumber(String input) {
        if(!input.matches(REGEX))
            throw new IllegalArgumentException("다리의 길이는 숫자로 작성해주셔야 합니다.");
    }
    //endregion

    //region 이동
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        ValidateMove(input);
        return input;
    }

    private void ValidateMove(String input) {
        try {
            if (!input.equals("U") && !input.equals("D"))
                throw new IllegalArgumentException("이동 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력하셔야 합니다.");
        }
        catch (IllegalArgumentException ex){
            System.out.println("[ERROR]" + ex.getMessage());
            readMoving();
        }
    }
    //endregion

    //region 재시도 여부
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        ValidateGameCommand(input);
        return input;
    }

    private void ValidateGameCommand(String input) {
        try{
            if (!input.equals("R") && !input.equals("Q"))
                throw new IllegalArgumentException("게임 재시도는 R(재시도)와 Q(종료) 중 하나의 문자를 입력하셔야 합니다.");
        }
        catch (IllegalArgumentException ex){
            System.out.println("[ERROR]" + ex.getMessage());
            readGameCommand();
        }
    }
    //endregion
}
