package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    boolean matchWithIndex(int idx, String candidate){
        return bridge.get(idx).equals(candidate);
    }

    public List<List<State>> toPrint(){
        List<State> up = new ArrayList<>();
        List<State> down = new ArrayList<>();
       for(String s: bridge){
           if(s.equals(Command.UP.getAbbreviation())) {
               up.add(State.CORRECT);
               down.add(State.NONE);
           }
           if(s.equals(Command.DOWN.getAbbreviation())){
               up.add(State.NONE);
               down.add(State.CORRECT);
           }
       }
       return List.of(up,down);
    }
}
