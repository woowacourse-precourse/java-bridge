package bridge.view;

import bridge.view.constants.CommandKeyword;
import bridge.view.constants.Keyword;
import bridge.view.constants.MovingKeyword;
import bridge.view.validator.ArgumentValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 클래스
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(int minimum, int maximum) throws IllegalArgumentException {
        return ConsoleReader.readLineAsIntegerInRange(minimum, maximum);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        return ConsoleReader.readLineAsKeyword(MovingKeyword.values());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() throws IllegalArgumentException {
        return ConsoleReader.readLineAsKeyword(CommandKeyword.values());
    }

    /**
     * 콘솔창의 입력값을 데이터 타입 및 형식에 맞게 읽는 내부 클래스
     */
    private static class ConsoleReader {

        static int readLineAsIntegerInRange(int minimum, int maximum) throws IllegalArgumentException {
            int readValue = readLineAsInteger();
            ArgumentValidator.validateIntegerInRange(readValue, minimum, maximum);
            return readValue;
        }

        static <T> T readLineAsKeyword(Keyword[] keywords) throws IllegalArgumentException {
            String line = readLine();
            Keyword matchedKeyword = ArgumentValidator.validateMatchedKeyword(line, keywords);
            return matchedKeyword.getValue();
        }

        static int readLineAsInteger() throws IllegalArgumentException {
            String line = readLine();
            ArgumentValidator.validateInteger(line);
            return Integer.parseInt(line);
        }

        static String readLine() {
            return Console.readLine();
        }
    }
}
