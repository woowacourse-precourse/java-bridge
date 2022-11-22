package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = readLine();
        int size;
        try {
            size = Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식 오류");
        }
        if (size < 3) throw new IllegalArgumentException("[ERROR] 숫자가 범위를 초과함");
        if (size > 20) throw new IllegalArgumentException("[ERROR] 숫자가 범위를 초과함");

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = readLine();
        if(direction.length() != 1) throw new IllegalArgumentException("[ERROR] 방향 입력 길이 오류");
        if(direction.equals("U")) return direction;
        if(direction.equals("D")) return  direction;
        throw new IllegalArgumentException("[ERROR] 방향 키 입력 오류 ");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = readLine();
        if(command.length() != 1) throw new IllegalArgumentException("[ERROR] 커맨드 입력 길이 오류");
        if(command.equals("R")) return command;
        if(command.equals("Q")) return command;
        throw new IllegalArgumentException("[ERROR] 커맨드 키 입력 오류");
    }
}
