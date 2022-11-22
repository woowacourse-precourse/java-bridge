package bridge;

import java.util.ArrayList;
import java.util.List;


public class BridgeGame {
    private List<String> choice = new ArrayList<String>();

    public List<String> move(String moving, List<String> bridge) {
        for(int i = 0; i < bridge.size(); i++) {
            if(moving.equals(bridge.get(i))) {
                this.choice.add("O");
            }
            if(!moving.equals(bridge.get(i))) {
                this.choice.add("X");
                retry(choice);
            }
        }
        return this.choice;
    }

    public void retry(List<String> choice) {
        for(int i = 0; i < this.choice.size(); i++) {
            if(this.choice.get(i).equals("X")) {
                break;
            }
        }
    }
}
