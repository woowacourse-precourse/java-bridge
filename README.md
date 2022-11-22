# 미션 - 다리 건너기

## Logic Flow

- Main 함수에서 BridgeMaker, InputView, OutputView 생성 후 BridgeGame에 주입
- BridgeGame의 playGame 호출
- playGame
    - 매 playGame 호출마다 tryCount증가
    - 한번의 playGame 내에서 step(초기 다리 길이 입력값) 만큼 move 호출 반복
    - move 실패시 retry 호출 및 반복문 종료
    - retry 함수 내에서 재시작 선택시 playGame 호출, 종료 선택시 프로그램 종료

## 테스트

- BridgeGameTest
    - 성공, 실패-종료, 실패-재시작-성공 테스트
    - OutputView 를 포함한 이외의 객체들은 기능 테스트에서 같이 테스트 되었다고 판단
- InputViewTest
    - 유일한 예외 발생 지점이라 테스트 객체 생성 후 예외 테스트
    - 1. 다리 길이 입력 시 형식, 범위
    - 2. 이동 커맨드 입력 시 형식
    - 3. 재시작 커맨드 입력 시 형식


***runException 함수 내에서 NoSuchElementException으로 테스트 하므로 프로그램 내 모든 예외 NoSuchElementException으로 통일***
