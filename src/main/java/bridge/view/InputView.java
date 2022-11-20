package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INQUIRE_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INQUIRE_BRIDGE_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INQUIRE_GAME_STOP = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        return 0;
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }

    private String readInput(String comment){
        System.out.println(comment);
        return Console.readLine();
    }

    private int scanBridgeSize(){
        return 1;
    }

    private int scanBridgeMovement(){
        return 1;
    }

    private int scanGameCommand(){
        return 1;
    }
}
