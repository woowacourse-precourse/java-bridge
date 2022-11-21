package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.constant.BridgeGameInfo;

public class InputView {

    private static String input() {
        return Console.readLine();
    }

    public static int readBridgeSize() throws IllegalArgumentException {
        System.out.println(BridgeGameInfo.INPUT_BRIDGE_SIZE.message);
        // 다리 길이 입력받기
        String input = input();

        // 숫자 형태가 아니면 예외
        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) < 48 || (int) input.charAt(i) > 57) {
                throw new IllegalArgumentException();
            }
        }

        int size = Integer.parseInt(input);

        // 범위 벗어나면 예외
        if (size < 3 || 19 < size) {
            throw new IllegalArgumentException();
        }

        return size;
    }

    public static String readMoving() throws IllegalArgumentException {
        System.out.println(BridgeGameInfo.SELECT_UP_DOWN.message);
        // 이동할 칸 입력받기
        String input = input();

        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public static String readGameCommand() throws IllegalArgumentException {
        System.out.println(BridgeGameInfo.RESTART.message);
        // 다시 시도지 종료할지 입력받는다.
        String input = input();

        if (!(input.equals("Q") || input.equals("R"))) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
