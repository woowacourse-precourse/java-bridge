package bridge;

import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.");
        String s = Console.readLine();
        return validateBridgeSize(s);
    }

    public int validateBridgeSize(String l) {
        int bridgeLength = 0;

        try {
            bridgeLength = Integer.parseInt(l);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
        //    return readBridgeSize();
          //  throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
        if (bridgeLength < 3 || bridgeLength > 20){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            //   return readBridgeSize();
            // throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String nextCell = Console.readLine();
        validateReadMoving(nextCell);
        return nextCell;
    }

    public void validateReadMoving(String nextCell){
        if(!nextCell.equals("U") && !nextCell.equals("D"))
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해주세요.");
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retry = Console.readLine();
        return retry;
    }

    public void validateReadGameCommand(String retry){
        if(!retry.equals("U") && !retry.equals("Q"))
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요.");
    }
}
