package bridge;

public class BridgeUpDownNumber {

    public int upOrDown(String upDown){
        int upDownNumber=-1;
        if(upDown=="D") {
            upDownNumber = 1;
        }
        if(upDown=="U"){
            upDownNumber = 0;
        }
        return upDownNumber;
    }

}
