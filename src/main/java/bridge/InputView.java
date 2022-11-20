package bridge;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(List<Integer> bridgesize) {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeLength = bridgesize.size();
        if (bridgesize.size() < 3 || bridgesize.size() > 20 ) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String InputNumber = Console.readLine();
        if (InputNumber != "U" || InputNumber != "D") {
            throw new IllegalArgumentException("[ERROR] 위와 아래 중에서 선택해주세요!");
        }
        return InputNumber;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String RestartQuit = Console.readLine();
        if (RestartQuit != "R" || RestartQuit != "U") {
            throw new IllegalArgumentException("[ERROR] 재시도와 종료 중에서 선택해주세요!");
        }
        return RestartQuit;
    }
}
