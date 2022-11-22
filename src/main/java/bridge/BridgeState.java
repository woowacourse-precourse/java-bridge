package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeState {

    private final List<String> state = new ArrayList<>();

    public void moveState(String input) {
        if (input == "X") {
            state.add("X");
        }

        state.add(input);
    }

    public int getNextIndex(){
        return state.size();
    }

    public void refreshState(){
        state.clear();
    }

    public boolean isCompleted(int size){
        return state.size() == size;
    }

    public boolean isSuccess(int size) {
        return state.size() == size && !state.get(size-1).contains("X");
    }

    public List<String> getState(){
        return List.copyOf(state);
    }
}
