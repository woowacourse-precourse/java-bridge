package bridge.data;

import java.util.ArrayList;
import java.util.List;

enum Choice {
    DOWN(0, "D"), UP(1, "U");

    private int value;
    private String input;


    Choice (int value, String input) {
        this.value = value;
        this.input = input;
    }

    public List<String> save(int rand) {
        List<String> temp = new ArrayList<>();
        if (rand == value) {
            temp.add(input);
            return temp;
        }
        return temp;
    }
}
