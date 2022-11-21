package bridge.businesslogic.bridgestatus;

public class BridgeCrossingStatus {
    private final StringBuilder upLine = new StringBuilder();
    private final StringBuilder downLine = new StringBuilder();

    public void updateStatus(String upOrDown){
        checkLineElementsExists();
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

    public String getBridgeStatus(String upOrDown, boolean isLastPickIsRight){
        if(upOrDown.equals("U")){
            StringBuilder getStatus = new StringBuilder(upLine);
            return checkLastAndPacking(getStatus,isLastPickIsRight);
        }
        StringBuilder getStatus = new StringBuilder(downLine);
        return checkLastAndPacking(getStatus,isLastPickIsRight);
    }

    private void checkLast(StringBuilder targetStatus,boolean isLastPickIsRight){
        if(!isLastPickIsRight && targetStatus.charAt(targetStatus.length() - 1) == 'O'){
            targetStatus.deleteCharAt(targetStatus.length() -1);
            targetStatus.append("X");
        }
    }

    private String checkLastAndPacking(StringBuilder status,boolean isLastPickIsRight){
        checkLast(status,isLastPickIsRight);
        status.insert(0,"[ ");
        status.append(" ]");
        return status.toString();
    }

    private void checkLineElementsExists(){
        if(upLine.length() != 0){
            upLine.append(" | ");
            downLine.append(" | ");
        }
    }
}