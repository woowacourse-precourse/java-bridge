package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final int MIN_BRIDGE_SIZE =3;
    private static final int MAX_BRIDGE_SIZE =20;
    private static final int bridgePositionNumber =2;
    private int bridgeSize;
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> bridgeMap = new ArrayList<>();
    private List<String> crossAble = new ArrayList<>();
    public Bridge(String bridgeSize){
        this.bridgeSize = validate(bridgeSize);
        bridgeInit();
    }

    public List<String> getBridgeCanCross() {
        return bridgeCanCross;
    }
    private void bridgeInit(){
        crossAble = bridgeMaker.makeBridge(bridgeSize);
        setBridgeMap();
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
    public boolean ableToCross(int index,String userCommand){
        if(crossAble.get(index)==userCommand){
            return true;
        }
        return false;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public void setBridgeUnit(){
        bridgeMap = new LinkedHashMap<>();
        List<String> bridgeMapUnit = new ArrayList<>();
        for(int i=0;i<bridgeSize;i++){
            bridgeMapUnit.add(" ");
        }
    }
    public List<String> getBridgeMap(){
        return this.bridgeMap;
    }
    public void changeBridgeMap(int index,int userChoicePosition,char OorX){
        char[] bridgeUnit = bridgeMap.get(userChoicePosition).toCharArray();
        bridgeUnit[index] = OorX;
        bridgeMap.set(index,String.valueOf(bridgeUnit));
    }
}
