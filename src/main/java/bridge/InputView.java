package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.Objects;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IOException {

        try {
            int BridgeSize = Integer.parseInt(Console.readLine());
            if (BridgeSize < 3 || BridgeSize > 20)
                throw new IllegalArgumentException("[ERROR]");
            return BridgeSize;
        }catch (NumberFormatException e){
            System.out.println("[ERROR]");
        }

        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String pInput = Console.readLine();

        if(!Objects.equals(pInput, "U") && !Objects.equals(pInput, "D")){
            throw new IllegalArgumentException("[ERROR] 똑바로 입력해라 인간");
        }

        return pInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retry = Console.readLine();

        if(!Objects.equals(retry, "R") && !Objects.equals(retry, "Q")){
            throw new IllegalArgumentException("[ERROR] 똑바로 입력해라 인간");
        }

        return retry;
    }
}
