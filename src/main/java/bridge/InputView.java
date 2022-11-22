package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //다리의 길이를 입력받는다.
    public int readBridgeSize() {
        int bridgelength = 0;

        System.out.println("다리의 길이를 입력해주세요.");
        try {
            bridgelength = Integer.parseInt(Console.readLine());
            if(bridgelength < 3 || bridgelength > 20){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 문자열을 제외한 3 ~ 20 사이의 다리길이를 입력해 주세요");
            bridgelength = readBridgeSize();
        }
        System.out.println();

        return bridgelength;
    }

    //사용자가 이동할 칸을 입력받는다.
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = "";
        try {
            moving = Console.readLine();
            if(moving.equals("U") == false && moving.equals("D") == false) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U(위) D(아래)중에서 선택해주세요");
            moving = readMoving();
        }
        return moving;
    }

    //사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
    public String readExitCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String exittype = Console.readLine();
        return exittype;
    }
}
