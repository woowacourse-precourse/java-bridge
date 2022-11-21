package bridge;

public class Bridge {

    private static final int MIN_BRIDGE_SIZE =3;
    private static final int MAX_BRIDGE_SIZE =20;
    private int bridgeSize;

    public void bridge(String bridgeSize){

    }
    private void validate(String bridgeSize){

    }
    private void validateBridgeSize(int bridgeSize){
        if(bridgeSize>MAX_BRIDGE_SIZE||bridgeSize<MIN_BRIDGE_SIZE){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ ErrorResource.BRIDGE_SIZE_FRONT+
                    MIN_BRIDGE_SIZE+ErrorResource.TO+MAX_BRIDGE_SIZE+ErrorResource.INPUT_SHOULD_BACK);
        }
    }
}
