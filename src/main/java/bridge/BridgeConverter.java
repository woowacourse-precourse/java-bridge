package bridge;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BridgeConverter {

    private BridgeConverter(){
    }

    public static String covertToBridgeNumber(int bridgeNumber) {
        try {
            return Arrays.stream(KeyBoardEvent.values())
                         .filter(i -> i.getCode() == bridgeNumber)
                         .findAny()
                         .orElseThrow(ClassNotFoundException::new)
                         .getFirstLetter();
        } catch (ClassNotFoundException e) {
            throw new NoSuchElementException("[ERROR] 해당 코드를 찾을 수 없습니다.");
        }
    }

}
