package bridge;

import java.util.List;

public class Bridge {

    private static final int MIN_BRIDGE_SIZE =3;
    private static final int MAX_BRIDGE_SIZE =20;
    private int bridgeSize;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private List<Integer> crossAble;
    public void bridge(String bridgeSize){
        this.bridgeSize = validate(bridgeSize);
        bridgeInit();
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
}
