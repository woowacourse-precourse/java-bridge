package bridge;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<String> upper;
    private List<String> lower;

    Map(){
        this.upper = new ArrayList<>();
        this.lower = new ArrayList<>();
    }

    public void update(String direction, boolean isRight){
        if (direction.equals("U")){
            this.upperUpdate(isRight);
            return;
        }
        this.lowerUpdate(isRight);
    }

    private void upperUpdate(boolean isRight){
        this.lower.add("   ");
        if (isRight){
            this.upper.add(" O ");
            return;
        }
        this.upper.add(" X ");
    }

    private void lowerUpdate(boolean isRight){
        this.upper.add("   ");
        if (isRight){
            this.lower.add(" O ");
            return;
        }
        this.lower.add(" X ");
    }

    private void clear(){
        this.upper.clear();
        this.lower.clear();
    }
}
