package bridge.businesslogic.bridgehistorystatus;

public class BridgeHistoryUtil {
    public void checkLast(StringBuilder targetStatus,boolean isLastPickIsRight){
        if(!isLastPickIsRight && targetStatus.charAt(targetStatus.length() - 1) == 'O'){
            targetStatus.deleteCharAt(targetStatus.length() -1);
            targetStatus.append("X");
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
