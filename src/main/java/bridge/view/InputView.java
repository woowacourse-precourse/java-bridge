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
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        return convertInt(readLine());
    }
    private int convertInt(String read) {
        if (!isDigit(read)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        int size = Integer.parseInt(read);
        if (!validateBridgeSize(size)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }
    private boolean isDigit(String read) {
        if (read.matches("[^0-9]*$")) {
            return false;
        }
        return true;
    }
    private boolean validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            return false;
        }
        return true;
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
        String command = readLine();
        validateGameCommand(command);
        return command;
    }
    private void validateGameCommand(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R이나 Q이여야 합니다.");
        }
    }
}
