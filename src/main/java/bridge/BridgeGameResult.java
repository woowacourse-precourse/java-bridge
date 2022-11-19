package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {

    private final List<String> bridgeGameResult = new ArrayList<>();
    private String List1 = "";
    private String List2 = "";

    public BridgeGameResult(List<String> bridge, List<String> playerInput) {
        checkTop(bridge, playerInput);
        checkBottom(bridge,playerInput);
        makeGameResult();
    }

    public void makeGameResult(){
        List1="["+List1+"]";
        List2="["+List2+"]";
        bridgeGameResult.add(List1);
        bridgeGameResult.add(List2);
    }

    public void checkTop(List<String> bridge, List<String> playerInput) {
        for (int i = 0; i < playerInput.size(); i++) {
            if (i != 0) {
                List1 += "|";
            }
            List1 += makeTopResult(bridge.get(i), playerInput.get(i));
        }
    }

    public void  checkBottom(List<String>list,List<String>playerInput){
        for(int i=0;i<playerInput.size();i++){
            if(i!=0){
                List2+="|";
            }
            List2+=makeBottomResult(list.get(i),playerInput.get(i));
        }
    }

    public String makeTopResult(String bridge, String playInput) {
        if (bridge.equals("U") && playInput.equals("U")) {
            return " O ";
        }
        if (bridge.equals("U") && playInput.equals("D")) {
            return " X ";
        }
        return "   ";
    }
    public String makeBottomResult(String list,String playInput){
        if(list.equals("D")&&playInput.equals("D")){
            return " O ";
        }
        if(list.equals("D")&&playInput.equals("U")){
            return " X ";
        }
        return "   ";
    }

    public List<String>getList(){
        return bridgeGameResult;
    }

}
