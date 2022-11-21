package bridge.model;

import bridge.util.BridgeGameInfo;

public class BridgeMap {

    private static final String MOVE_SUCCESS_PIXEL = "O";
    private static final String MOVE_FAIL_PIXEL = "X";
    private static final String EMPTY_PIXEL = " ";

    private final BridgeMapComponent upperBridge;
    private final BridgeMapComponent lowerBridge;

    public BridgeMap()
    {
        upperBridge = new BridgeMapComponent();
        lowerBridge = new BridgeMapComponent();
    }

    public void extendMap(String nextMove,boolean moveSuccess)
    {
        if(moveSuccess)
        {
            extendMap(nextMove,MOVE_SUCCESS_PIXEL);
            return;
        }

        extendMap(nextMove,MOVE_FAIL_PIXEL);
    }

    private void extendMap(String nextMove,String movePixel)
    {
        if(nextMove.equals(BridgeGameInfo.UPPER_MOVE))
        {
            addPixel(movePixel,EMPTY_PIXEL);
            return;
        }

        addPixel(EMPTY_PIXEL,movePixel);
    }

    public void restart()
    {
        removePixel();
    }

    private void addPixel(String upperPixel,String lowerPixel)
    {
        upperBridge.add(upperPixel);
        lowerBridge.add(lowerPixel);
    }

    private void removePixel()
    {
        upperBridge.removeLast();
        lowerBridge.removeLast();
    }

    @Override
    public String toString()
    {
        return upperBridge.toString() +
                lowerBridge.toString();
    }


}
