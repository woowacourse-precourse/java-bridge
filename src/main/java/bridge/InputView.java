package bridge;

public class InputView {
    public static int readBridgeSize() {
        String bridgeSize;
        while (true) {
            System.out.println("다리의 길이를 입력해주세요.");
            bridgeSize = camp.nextstep.edu.missionutils.Console.readLine();
            if (!bridgeSizeErrorHandling(bridgeSize)) {
                return Integer.parseInt(bridgeSize);
            }
        }
    }

    public static String readMoving() {
        String moving;
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            moving = camp.nextstep.edu.missionutils.Console.readLine();
            if (!movingErrorHandling(moving)) {
                return moving;
            }
        }
    }

    public static String readGameCommand() {
        String gameCommand;
        while (true) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            gameCommand = camp.nextstep.edu.missionutils.Console.readLine();
            if (!gameCommandErrorHandling(gameCommand)) {
                return gameCommand;
            }
        }
    }

    public static void checkNotDigit(String str) throws IllegalArgumentException {
        for (int i = 0; i < str.length(); i++) {
            char charUnit = str.charAt(i);
            if ((int) charUnit < 48 || (int) charUnit > 58) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다");
            }
        }
    }

    public static void checkOutOfBound(int bridgeSize) throws IllegalArgumentException {
        if ((bridgeSize < 3) || (bridgeSize > 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static Boolean bridgeSizeErrorHandling(String str) {
        try {
            checkNotDigit(str);
            checkOutOfBound(Integer.parseInt(str));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static void checkMovingInput(String str) {
        if (!(str.equals("U") || str.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸 입력은 U 또는 D 입니다");
        }
    }

    public static Boolean movingErrorHandling(String str) {
        try {
            checkMovingInput(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static void checkGameCommandInput(String str) {
        if (!(str.equals("R") || str.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 다시 시도 여부 입력은 R 또는 Q 입니다");
        }
    }

    public static Boolean gameCommandErrorHandling(String str) {
        try {
            checkGameCommandInput(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
