package bridge;

public class MapViewDto {

    private String selectedBridge;
    private boolean result;

    public MapViewDto(MoveResponseDto dto) {
        this.selectedBridge = dto.getSelectedBridge();
        this.result = dto.getResultBooleanType();
    }

    //getter -> 메시지를 보내자.
    public String getSelectedBridge() {
        return selectedBridge;
    }

    public boolean getResult() {
        return result;
    }
}
