package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR = "[ERROR] ";
    private static final String BRIDGE_SIZE_ERROR = "3에서 20 사이의 정수 형태로 입력해주세요.";
    private static final String BRIDGE_SPACE_ERROR = "U,D 형태로만 입력받을 수 있습니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            String bridgeSize = readLine();
            try{
                int size=checkInteger(bridgeSize);
                if(checkSize(size)) return size;
            }catch (IllegalArgumentException e){
                    printErrorMessage(BRIDGE_SIZE_ERROR);
            }
        }
    }

    private int checkInteger(String str) {
        try{
            int convertedInteger = Integer.parseInt(str);
            return convertedInteger;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private void printErrorMessage(String errorMsg){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ERROR).append(errorMsg);
        System.out.println(stringBuilder.toString());
    }



    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            String nxtSpace = readLine();
            try{
                checkAvailableSpace(nxtSpace);
                return nxtSpace;
            }catch (IllegalArgumentException e){
                printErrorMessage(BRIDGE_SIZE_ERROR);
            }
        }
    }

    private static void checkAvailableSpace(String nxtSpace) {
        if(!nxtSpace.equals("U") || !nxtSpace.equals("D")){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
