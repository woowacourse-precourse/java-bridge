package bridge;

public class HandleException {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    /**
     * 사용자가 입력한 다리 길이의 타입을 확인하는 함수
     * <p>
     * 성공 시 Integer로 바뀐 다리 길이를 반환
     */
    public int checkBridgeType(String readBridgeSize) {
        int changeBridgeSize;

        try {
            changeBridgeSize = Integer.parseInt(readBridgeSize);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }

        return changeBridgeSize;
    }

    /**
     * 사용자가 입력한 다리 길이의 범위를 확인하는 함수 
     * <p>
     * 성공 시 Integer로 바뀐 다리 길이 그대로 반환
     */
    public int checkBridgeRange(int readBridgeSize) {
        if (readBridgeSize < 3 || readBridgeSize > 20) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }

        return readBridgeSize;
    }

    /**
     * 사용자가 입력한 칸을 확인하는 함수
     * <p>
     * 성공 시 사용자가 입력한 칸 그대로 반환
     */
    public String checkMove(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            System.out.println(ERROR_MESSAGE + "이동할 칸은 U, D 중에 하나여야 합니다.");
            throw new IllegalArgumentException();
        }

        return move;
    }
}
