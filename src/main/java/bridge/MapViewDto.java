package bridge;

public class MapViewDto {

    private String selectedBridge;
    private boolean result;

    public MapViewDto(String selectedBridge, boolean result) {
        this.selectedBridge = selectedBridge;
        this.result = result;
    }

    //getter -> 메시지를 보내자.
    public String getSelectedBridge() {
        return selectedBridge;
    }

    public boolean isResult() {
        return result;
    }
}
