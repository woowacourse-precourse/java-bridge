package bridge.domain.view;

import bridge.global.BridgeMessage;
import bridge.dto.CorrectInfo;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<CorrectInfo> correctInfos) {
        StringBuffer sb = upperBridge(correctInfos, BridgeMessage.UP);
        sb = endBridge(sb);
        sb.append("\n").append(upperBridge(correctInfos,BridgeMessage.DOWN));
        sb = endBridge(sb);

        return sb.toString();
    }

    private StringBuffer upperBridge(List<CorrectInfo> correctInfos, BridgeMessage bridgeStatus){
        StringBuffer sb = createBridge();
        for (CorrectInfo correctInfo : correctInfos) {
            sb.append(checkConstructBridge(correctInfo, bridgeStatus));
            if(!correctInfo.isPass()){
                break;
            }
        }
        return sb;
    }

    private String checkConstructBridge(CorrectInfo correctInfo, BridgeMessage bridgeStatus){
        if(correctInfo.getBridgeBlock() != bridgeStatus){
            return "   |";
        }
        if(!correctInfo.isPass()){
            return " X |";
        }
        return " O |";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printResult(List<CorrectInfo> correctInfos, boolean success, int count) {
        StringBuffer sb = new StringBuffer(printMap(correctInfos));
        sb.append("\n");
        sb.append(ResultMessage.SUCCESS_OR_FAIL);
        sb.append(appendJudgeMessage(success)).append("\n");

        sb.append(ResultMessage.TOTAL_TRY);
        sb.append(count);
        return sb.toString();
    }

    private String appendJudgeMessage(boolean success) {
        if(success == true){
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.FAIL;
    }

    private StringBuffer createBridge(){
        return new StringBuffer("[");
    }
    private StringBuffer endBridge(StringBuffer sb){
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb;
    }
}
