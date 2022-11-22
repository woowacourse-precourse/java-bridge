package bridge.businesslogic.bridgehistorystatus;

public class BridgeCrossingHistory {
    private final StringBuilder upLine;
    private final StringBuilder downLine;
    private final BridgeHistoryUtil statusUtil = new BridgeHistoryUtil();

    public BridgeCrossingHistory(StringBuilder upLine, StringBuilder downLine) {
        this.upLine = upLine;
        this.downLine = downLine;
    }

    public void updateHistory(String upOrDown){
        statusUtil.checkLineElementsExists(upLine,downLine);
        if(upOrDown.equals("U")){
            upLine.append("O");
            downLine.append(" ");
            return;
        }
        upLine.append(" ");
        downLine.append("O");
    }

    public void clearAll(){
        upLine.delete(0,upLine.length());
        downLine.delete(0,downLine.length());
    }

    public String getBridgeHistory(String upOrDown, boolean isLastPickIsRight){
        if(upOrDown.equals("U")){
            StringBuilder getStatus = new StringBuilder(upLine);
            return statusUtil.checkLastAndPacking(getStatus,isLastPickIsRight);
        }
        StringBuilder getStatus = new StringBuilder(downLine);
        return statusUtil.checkLastAndPacking(getStatus,isLastPickIsRight);
    }
}