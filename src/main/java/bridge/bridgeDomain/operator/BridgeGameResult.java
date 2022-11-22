package bridge.bridgeDomain.operator;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {

    private final List<String> bridgeGameResult = new ArrayList<>();
    private String topResult = "";
    private String bottomResult = "";

    public BridgeGameResult(List<String> bridge, List<String> playerInput) {
        checkTop(bridge, playerInput);
        checkBottom(bridge,playerInput);
        makeGameResult();
    }

    public void makeGameResult(){
        topResult="["+topResult+"]";
        bottomResult="["+bottomResult+"]";
        bridgeGameResult.add(topResult);
        bridgeGameResult.add(bottomResult);
    }

    public void checkTop(List<String> bridge, List<String> playerInput) {
        for (int i = 0; i < playerInput.size(); i++) {
            if (i != 0) {
                topResult += "|";
            }
            topResult += makeTopResult(bridge.get(i), playerInput.get(i));
        }
    }

    public void  checkBottom(List<String>list,List<String>playerInput){
        for(int i=0;i<playerInput.size();i++){
            if(i!=0){
                bottomResult+="|";
            }
            bottomResult+=makeBottomResult(list.get(i),playerInput.get(i));
        }
    }

    public String makeTopResult(String bridge, String playInput) {
        if (bridge.equals("U") && playInput.equals("U")) {
            return " O ";
        }
        if (bridge.equals("D") && playInput.equals("U")) {
            return " X ";
        }
        return "   ";
    }
    public String makeBottomResult(String list,String playInput){
        if(list.equals("D")&&playInput.equals("D")){
            return " O ";
        }
        if(list.equals("U")&&playInput.equals("D")){
            return " X ";
        }
        return "   ";
    }

    public List<String>getList(){
        return bridgeGameResult;
    }

}
