package bridge;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자를 입력할 수 없습니다.");
        }
        checkNumberOutOfBounds(bridgeSize);
        return bridgeSize;
    }

    private void checkNumberOutOfBounds(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자만 입력할 수 있습니다.");
        }
    }


    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String playerMove = Console.readLine();
        checkNotAllowedStringInput(playerMove, "U", "D");
        return playerMove;
    }

    public String readGameCommand() {

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String restart = Console.readLine();
        checkNotAllowedStringInput(restart, "Q", "R");
        return restart;
    }

    public void checkNotAllowedStringInput(String playerMove, String one, String another) {
        if (!(playerMove.equals(one) || playerMove.equals(another))) {
            throw new IllegalArgumentException("[ERROR] 허용되지 않은 문자를 입력할 수 없습니다.");
        }
    }
}
