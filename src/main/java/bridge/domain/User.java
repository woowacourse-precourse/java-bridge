package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int totalTry;
    private List<String> select;

    public User() {
        this.totalTry = 0;
        this.select = new ArrayList<>();
    }

    public void resetSelect() {
        select = new ArrayList<>();
    }

    public void addSelect(String word) {
        select.add(word);
    }

    public int getPosition() {
        return select.size();
    }

    public String getIndexSelect(int index) {
        return select.get(index);
    }
}
