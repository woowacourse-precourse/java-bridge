package exception;


import java.util.NoSuchElementException;

public class BridgeException {

    public int validateBridgeSize(String bridgeSize) {
        try {
            int bridgeLen = Integer.parseInt(bridgeSize);
            if (bridgeLen < 3 || bridgeLen > 20) {
                throw new NoSuchElementException(ErrorMessage.INPUT_WRONG_BRIDGE_SIZE.get());
            }
            return bridgeLen;
        } catch (Exception e) {
            System.out.println(ErrorMessage.INPUT_WRONG_BRIDGE_SIZE.get());
            throw new NoSuchElementException(ErrorMessage.INPUT_WRONG_BRIDGE_SIZE.get());
        }
//        return 0;
    }

}
