package bridge.service.dto.request;

public class SelectBlockRequestDto {
    private final String block;

    public SelectBlockRequestDto(String block) {
        this.block = block;
    }

    public String getBlock() {
        return block;
    }
}
