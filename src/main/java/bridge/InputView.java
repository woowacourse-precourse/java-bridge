package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        int bridgeSize = Integer.parseInt(Console.readLine());
        validateBridgeSize(bridgeSize);

        return bridgeSize;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20)
            throw new   IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userMove = Console.readLine();
        return isCorrectInputCompareByTwoString(userMove, "U", "D");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userRestart = Console.readLine();
        return isCorrectInputCompareByTwoString(userRestart, "R", "Q");
    }

    /**
     * @param userInput            사용자 입력
     * @param possibleFirstString  가능한 첫번째 문자열
     * @param possibleSecondString 가능한 두번째 문자열
     * @return 입력받은 문자열을 반환한다.
     * @throws IllegalArgumentException possibleFirstString, possibleSecondString 아닌 문자열이 입력된 경우
     */
    private String isCorrectInputCompareByTwoString(String userInput, String possibleFirstString, String possibleSecondString) {
        if (userInput.length() == 1)
            if (userInput.equals(possibleFirstString) || userInput.equals(possibleSecondString))
                return userInput;

        throw new IllegalArgumentException(
                possibleFirstString + " 또는 " + possibleSecondString + "를 입력해주세요."
        );
    }
}
