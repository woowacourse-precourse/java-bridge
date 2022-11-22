package bridge.presentation;

import bridge.exception.SizeOverException;
import bridge.exception.DesignatedTypeException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        try {
            String size = Console.readLine();
            DesignatedTypeException.allNumberCheck(size);
            int bridgeSize = Integer.parseInt(size);
            SizeOverException.bridgeSizeCheck(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }//try-catch
    }//readBridgeSize

    public String readMoving() {
        try {
            String movement = Console.readLine();
            SizeOverException.oneWordCheck(movement);
            DesignatedTypeException.UDcheck(movement);
            return movement;
        } catch (IllegalArgumentException e) {
            return readMoving();
        }//try-catch
    }//readMoving

    public String readGameCommand() {
        try {
            String command = Console.readLine();
            SizeOverException.oneWordCheck(command);
            DesignatedTypeException.RQcheck(command);
            return command;
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }//try-catch
    }//readGameCommand
}// end class
