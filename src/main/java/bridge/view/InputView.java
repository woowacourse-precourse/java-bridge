package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = 0;
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        try{
            validateNumberFormat(input);
            bridgeSize = Integer.parseInt(input);
            validateBridgeSizeRange(bridgeSize);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            bridgeSize = readBridgeSize();
        }
        return bridgeSize;
    }

    private void validateBridgeSizeRange(int bridgeSize){
        if(bridgeSize < 3 || bridgeSize > 21){
            throw new IllegalArgumentException("[ERROR]  다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateNumberFormat(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 외 문자가 입력되었습니다.");
        }
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
