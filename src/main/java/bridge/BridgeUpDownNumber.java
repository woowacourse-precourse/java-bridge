package bridge;

public class BridgeUpDownNumber {

    public int upOrDown(String upDown){
        int upDownNumber=-1;
        if(upDown=="D") {
            upDownNumber = 0;
        }
        if(upDown=="U"){
            upDownNumber = 1;
        }
        return upDownNumber;
    }
    
}
