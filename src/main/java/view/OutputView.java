package view;

import dto.MapResponseDto;
import dto.MoveResultResponseDto;
import dto.PlayCountResponseDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 */
	public void printMap(MapResponseDto mapResponseDto) {
		System.out.println(mapResponseDto.getMap());
		printEmptyLine();
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 */
	public void printResult(MapResponseDto mapResponseDto, MoveResultResponseDto moveResultResponseDto,
		PlayCountResponseDto playCountResponseDto) {
		printFinalResultMap(mapResponseDto);
		printSuccessOrFail(moveResultResponseDto);
		printTotalPlayCount(playCountResponseDto);
	}

	private void printFinalResultMap(MapResponseDto mapResponseDto) {
		System.out.println(ViewConstant.FINAL_RESULT_MESSAGE);
		System.out.println(mapResponseDto.getMap());
		printEmptyLine();
	}

	private void printSuccessOrFail(MoveResultResponseDto moveResultResponseDto) {
		System.out.print(ViewConstant.SUCCESS_OR_FAIL_MESSAGE);
		if (moveResultResponseDto.isSuccess()) {
			System.out.println(ViewConstant.SUCCESS);
		}
		if (!moveResultResponseDto.isSuccess()) {
			System.out.println(ViewConstant.FAIL);
		}
	}

	private void printTotalPlayCount(PlayCountResponseDto playCountResponseDto) {
		System.out.printf(ViewConstant.TOTAL_PLAY_COUNT_MESSAGE);
		System.out.println(playCountResponseDto.getPlayCount());
	}

	public void printStartMessage() {
		System.out.println(ViewConstant.GAME_START_MESSAGE);
		printEmptyLine();
	}

	private void printEmptyLine() {
		System.out.println();
	}

	public void printErrorLog(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}
}
