package bridge.model;

import java.util.List;

public class Bridge {
    private List<String> bridgeList;
    private Integer bridgeSize;
    public Bridge(List<String> bridgeList){
        this.bridgeList = bridgeList;
        this.bridgeSize = bridgeList.size();
    }
    public List<String> getBridgeList(){return this.bridgeList;}
    public Integer getBridgeSize(){return this.bridgeSize;}
    public String getBridgeListIndex(Integer index){return this.bridgeList.get(index);}
}
