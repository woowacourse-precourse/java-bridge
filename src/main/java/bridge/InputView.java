package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    int bridgeSize_in = 0;
    String upAndDown_in = "";
    String retryAndQuit_in = "";

    public void readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSizeLetter_in = Console.readLine();
        bridgeSizeNotLetterValidation(bridgeSizeLetter_in);
        bridgeSizeRangeValidation(bridgeSize_in);
    }

    public void readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        upAndDown_in = Console.readLine();
    }

    public void readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        retryAndQuit_in = Console.readLine();
    }

    private void bridgeSizeRangeValidation(int bridgeSize_in) {
        if (20 < bridgeSize_in || bridgeSize_in < 3)
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 가능한 범위를 벗어났습니다.");
                readBridgeSize();
            }
    }

    private void bridgeSizeNotLetterValidation(String bridgeSizeLetter_in) {
        String filter = "^[0-9]+";
        try {
            if (String.valueOf(bridgeSizeLetter_in).matches(filter)) {
                bridgeSize_in = Integer.parseInt(String.valueOf(bridgeSizeLetter_in));
                return;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 문자가 감지되었습니다.");
            readBridgeSize();
        }
    }

}
