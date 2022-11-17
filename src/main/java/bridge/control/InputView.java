package bridge.control;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView { //사용자로부터 입력을 받는 역할을 한다.
    private String input_BridgeSize;
    private String input_Moving;
    private String input_GameCommand;
    public int readBridgeSize() { //다리의 길이를 입력받는다.
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        input_BridgeSize = readLine();
        System.out.println(input_BridgeSize + "\n");
        new inputCheck().bridge_size_check(input_BridgeSize);
        return Integer.parseInt(input_BridgeSize);
    }
    public String readMoving() { //사용자가 이동할 칸을 입력받는다.
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        input_Moving = readLine();
        System.out.println(input_Moving);
        new inputCheck().moving_check(input_Moving);
        return input_Moving;
    }
    public String readGameCommand() { //사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        input_GameCommand = readLine();
        System.out.println(input_GameCommand);
        new inputCheck().command_check(input_GameCommand );
        return input_GameCommand;
    }


}
