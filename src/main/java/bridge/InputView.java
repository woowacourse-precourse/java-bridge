package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int bridgeSize = 0;
        System.out.println("다리의 길이를 입력해 주세요.");
        bridgeSize = Integer.parseInt(repeatUntilRightInput());
        return bridgeSize;
    }

    //  10줄 초과! 리팩토링 필요  //
    private static String repeatUntilRightInput(){
        String input = "";
        while(true){
            input = Console.readLine();
            try{
                errorBridgeSizeOverRange(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 3~20 사이의 값을 입력해야 합니다.");
            }
        }
        return input;
    }

    public static void errorBridgeSizeOverRange(String input){
        int bridgeSize = Integer.parseInt(input);
        if(bridgeSize < 3 || 20 < bridgeSize){
            throw new IllegalArgumentException();
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