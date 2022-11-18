package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws NumberFormatException, IllegalArgumentException{
        System.out.println("다리의 길이를 입력해주세요.");
        int convertedSize = Integer.parseInt(readLine());
        if (convertedSize < 3 || convertedSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return convertedSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String location = readLine();
        validateMoveLocation(location);
        return location;
    }
    private void validateMoveLocation(String location) throws IllegalArgumentException{
        if (location.isEmpty() || location.length() > 1 || !(location.equals("U") || location.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U이거나 D이여야 합니다.");
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
