package bridge.control;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.Application;

public class InputView { //사용자로부터 입력을 받는 역할을 한다.
    public static String input_GameCommand;
    public static int input_bridge_length;
    public static String input_Moving;
    public static boolean input_error;
    public void readBridgeSize() { //다리의 길이를 입력받는다.
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        String input_BridgeSize = readLine();
        System.out.println(input_BridgeSize + "\n");
        inputCheck check = new inputCheck();
        input_error = check.bridge_word_check(input_BridgeSize);
        if(InputView.input_error) {
            check.bridge_size_check(input_BridgeSize);
            input_bridge_length = Integer.parseInt(input_BridgeSize);
        }
    }
    public void readMoving() { //사용자가 이동할 칸을 입력받는다.
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        input_Moving = readLine();
        System.out.println(input_Moving);
        new inputCheck().moving_check(input_Moving);
    }
    public void readGameCommand() { //사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        input_GameCommand = readLine();
        System.out.println(input_GameCommand);
        new inputCheck().command_check(input_GameCommand);
    }


}
