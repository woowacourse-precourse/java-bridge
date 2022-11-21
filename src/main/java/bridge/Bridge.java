package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;
    private List<List<String>> outputBridge = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));


    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<List<String>> getOutputBridge() {
        return outputBridge;
    }

    public void setOutputBridge(List<List<String>> outputBridge){
        this.outputBridge = outputBridge;
    }



}
