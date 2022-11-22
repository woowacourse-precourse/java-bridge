package bridge;

import camp.nextstep.edu.missionutils.Console;
import model.BridgeSize;
import model.Moving;
import model.Restart;

public class InputView {

    public BridgeSize readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            return new BridgeSize(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public Moving readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            return new Moving(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public Restart readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try {
            return new Restart(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
