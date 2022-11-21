package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String SELECT_BRIDGE_BLOCK = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String SELECT_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static Integer readBridgeLength() {
        System.out.println(GAME_START);
        System.out.println();
        System.out.println(INPUT_BRIDGE_LENGTH);
        return Integer.valueOf(Console.readLine());
    }

    public static String readSelectedBridgeBlock() {
        System.out.println();
        System.out.println(SELECT_BRIDGE_BLOCK);
        return Console.readLine();
    }

    public static String readGameCommand() {
        System.out.println(SELECT_RETRY_OR_QUIT);
        return Console.readLine();
    }
}
