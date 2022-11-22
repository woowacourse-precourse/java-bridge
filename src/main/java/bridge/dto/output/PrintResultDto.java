package bridge.dto.output;

import bridge.domain.player.Player;
import bridge.dto.controller.ExitDto;

public class PrintResultDto {

    private final PrintMapDto printMapDto;
    private final PrintGameInfoDto printGameInfoDto;

    public PrintResultDto(final ExitDto exitDto) {
        Player player = exitDto.getPlayer();

        this.printMapDto = new PrintMapDto(player);
        this.printGameInfoDto = new PrintGameInfoDto(exitDto);
    }

    public PrintMapDto getPrintMapDto() {
        return printMapDto;
    }

    public PrintGameInfoDto getPrintGameInfoDto() {
        return printGameInfoDto;
    }
}
