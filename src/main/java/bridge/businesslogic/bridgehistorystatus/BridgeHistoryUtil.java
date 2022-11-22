package bridge.businesslogic.bridgehistorystatus;

public class BridgeHistoryUtil {
    public void checkLast(StringBuilder targetHistory,boolean isLastPickIsRight){
        if(!isLastPickIsRight && targetHistory.charAt(targetHistory.length() - 1) == 'O'){
            targetHistory.deleteCharAt(targetHistory.length() -1);
            targetHistory.append("X");
        }
    }

    public String checkLastAndPacking(StringBuilder status,boolean isLastPickIsRight){
        checkLast(status,isLastPickIsRight);
        status.insert(0,"[ ");
        status.append(" ]");
        return status.toString();
    }

    public void checkLineElementsExists(StringBuilder upLine, StringBuilder downLine){
        if(upLine.length() != 0){
            upLine.append(" | ");
            downLine.append(" | ");
        }
    }
}
