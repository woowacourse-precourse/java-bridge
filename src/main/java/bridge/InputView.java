package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        int size=0;
        try {
            size = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
//            throw new NumberFormatException();
        }
        return size;
    }
}
