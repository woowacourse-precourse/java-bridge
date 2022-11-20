package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GREETING_GAME = "다리 건너기 게임을 시작합니다.\n";
    private static final String CHOOSE_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String CHOOSE_SQUARE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GREETING_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void greetingGame(){
        System.out.println(GREETING_GAME);
    }

    public int readBridgeSize() {
        System.out.println(CHOOSE_BRIDGE_SIZE);
        return Integer.parseInt(Console.readLine());
    }

    public String readMoving() {
        System.out.println(CHOOSE_SQUARE);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(GREETING_GAME_COMMAND);
        return Console.readLine();
    }
}
