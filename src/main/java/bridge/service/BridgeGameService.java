package bridge.service;

import bridge.data.dto.requestDto.FailMenuRequestDto;
import bridge.data.dto.requestDto.FinalResultRequestDto;
import bridge.data.dto.requestDto.GameInitRequestDto;
import bridge.data.dto.requestDto.InGameCommandRequestDto;
import bridge.data.dto.responseDto.FailMenuResponseDto;
import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.GameInitResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;

public interface BridgeGameService {

    // 만일 저장된 게임을 세션ID로 불러오고 싶다면, findGame 메서드를 추가할 수도 있겠다.

    GameInitResponseDto initGame(GameInitRequestDto requestDto);

    InGameCommandResponseDto playGame(InGameCommandRequestDto requestDto);

    FailMenuResponseDto askRestart(FailMenuRequestDto requestDto);

    FinalResultResponseDto getResult(FinalResultRequestDto requestDto);
}
