package bridge.View;


import bridge.Instances.InputType;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String ENTER_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String ENTER_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public String read(InputType type){
        if (type.equals(InputType.BRIDGE_SIZE)){
            return readBridgeSize();
        } else if(type.equals(InputType.MOVING)){
            return readMoving();
        }
        return readGameCommand();
    }

    public String readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
        return readLine();
    }

    public String readMoving() {
        System.out.println(ENTER_MOVING);
        return readLine();
    }

    public String readGameCommand() {
        System.out.println(ENTER_GAME_COMMAND);
        return readLine();
    }


}
