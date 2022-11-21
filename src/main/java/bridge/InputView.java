package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String errorMsg = "[ERROR]";

    private OutputView outputView;
    private BridgeGame bridgeGame;
    private String changeToNum = "";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        int result;
        try {
            result = Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMsg + " 숫자만 입력 가능");
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다. U, D
     */
    public String readMoving(int bridgeSize) {

        String result = "";

        // 리스트 List<String> 같은 형태로 필요
        // U 또는 D를 읽을 때마다 한번씩 출력해준다.
        for (int i = 0; i < bridgeSize; ++i) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String position = Console.readLine();

            // U, D인 경우
            if (position.charAt(0) == 'U' && position.length() == 1) {
                result += "U";
                changeToNum += "1";
                //outputView].printMap();

            } else if (position.charAt(0) == 'D' && position.length() == 1) {
                result += "D";
                changeToNum += "0";
                // outputView.printMap();

            } else {
                throw new IllegalArgumentException(errorMsg + " 위: U, 아래: D 만 입력 가능");

            }
        }

        return result;
    }


    // U와 D를 1 또는 0으로 바꾼다.
    public String changeToNum(String str) {

        String result = "";
        for (char c : str.toCharArray()) {

            if (c == 'U') {
                result += "1";
                continue;
            }
            result += "0";
        }
        return result;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     * 게임 실패한 경우에 호출한다.
     */
    public String readGameCommand() {

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String restartOrExit = Console.readLine();

        if (restartOrExit.length() == 1 && restartOrExit.charAt(0) == 'R') {
            System.out.println("Restart ");
            // BridgeGame 클래스의 retry()로 넘어간다.
            bridgeGame.retry();

        } else if (restartOrExit.length() == 1 && restartOrExit.charAt(0) == 'Q') {
            System.out.println("Exit ");
            outputView.printResult(null);       // 현재까지의 다리 정보를 넣고 출력한다.

        } else {

            throw new IllegalArgumentException(errorMsg + " R 또는 Q만 입력 가능");
        }

        return null;
    }
}
