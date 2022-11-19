package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() throws IllegalArgumentException{
        /*
        * 숫자가 아닌 경우
        * 3이상 20 이하
        * 아무입력 없는 경우
        * */
        try {
            String s = Console.readLine();

            int length = Integer.parseInt(s);

            if (length > 20 || length < 3) {
                throw new IllegalArgumentException("[ERROR] 3이상 20이하의 정수를 입력해주세요.");
            }
            return length;
        } catch (NumberFormatException | NoSuchElementException ne) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 정수를 입력해주세요.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() throws IllegalArgumentException{
        /*
        U,D아닌 다른 문자
        아무입력 없는 경우
         */
        try {
            String s = Console.readLine();

            throwError(List.of("U","u","D","d"), s, "[ERROR] 위칸을 원하시면 U또는 u, 아래칸을 원하시면 D또는 d를 입력해주세요.");

            return s.toUpperCase();
        } catch (NoSuchElementException ne) {
            throw new IllegalArgumentException("[ERROR] 위칸을 원하시면 U또는 u, 아래칸을 원하시면 D또는 d를 입력해주세요. 현재 입력값이 없습니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() throws IllegalArgumentException{
        /*
        R,Q 아닌 다른문자
        아무입력 없는 경우
         */
        try {
            String s = Console.readLine();

            throwError(List.of("R","r","Q","q"), s, "[ERROR] 재시도를 원하시면 R또는 r, 종료를 원하시면 Q또는 q를 입력해주세요.");

            return s.toUpperCase();
        } catch (NoSuchElementException ne) {
            throw new IllegalArgumentException("[ERROR] 재시도를 원하시면 R또는 r, 종료를 원하시면 Q또는 q를 입력해주세요. 현재 입력값이 없습니다.");
        }

    }

    public static void throwError(List<String> properElements, String input, String errorMessage) throws IllegalArgumentException {
        if (!properElements.contains(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
