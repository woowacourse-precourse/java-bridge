package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final int MIN_BRIDGE_SIZE =3;
    private static final int MAX_BRIDGE_SIZE =20;
    private int bridgeSize;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private List<Integer> crossAble = new ArrayList<>();
    public Bridge(String bridgeSize){
        this.bridgeSize = validate(bridgeSize);
        bridgeInit();
    }
    public List<Integer> getCrossAble(){
        return crossAble;
    }
    private void bridgeInit(){
        for(int i=0;i<this.bridgeSize;i++){
            crossAble.add(bridgeRandomNumberGenerator.generate());
        }
    }
    private int validate(String bridgeSize){
        int bridgeSizeNumber = stringToNumber(bridgeSize);
        validateBridgeSize(bridgeSizeNumber);
        return bridgeSizeNumber;
    }
    private void validateBridgeSize(int bridgeSize){
        if(bridgeSize>MAX_BRIDGE_SIZE||bridgeSize<MIN_BRIDGE_SIZE){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ ErrorResource.BRIDGE_SIZE_FRONT+
                    MIN_BRIDGE_SIZE+ErrorResource.TO+MAX_BRIDGE_SIZE+ErrorResource.INPUT_SHOULD_BACK);
        }
    }
    private int stringToNumber(String bridgeSize){
        try{
            return Integer.parseInt(bridgeSize);
        }
        catch(Exception e){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.BRIDGE_SIZE_FRONT+
                    ErrorResource.NOT_NUMBER);
        }
    }
    public boolean ableToCross(int index,int userChoice){
        if(crossAble.get(index)==userChoice){
            return true;
        }
        return false;
    }
}
