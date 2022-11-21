package bridge.view.dto;

import java.util.List;

public class PrintMapDto {
    public Integer current;
    public String input;
    public List<String> bridge;

    public String result;

    public PrintMapDto(Integer current, String input, List<String> bridge) {
        this.current = current;
        this.input = input;
        this.bridge = bridge;
    }

    public PrintMapDto(String result) {
        this.result = result;
    }
}
