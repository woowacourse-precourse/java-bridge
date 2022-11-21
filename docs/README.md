# 기능 목록

## View

### InputView
1. 다리 길이 입력 받기
    - 예외:
        - 중간에 문자열이 껴있는 경우(정수가 아닌 경우)
        - 3이상 20이하의 숫자가 아닌 경우
2. 이동할 칸 입력 받기
    - 예외:
        - U 혹은 D가 아닌 경우
3. 재시작 입력 받기
    - 예외:
        - R 혹은 Q가 아닌 경우

### OutputView
1. 게임 시작 문구 출력
2. 게임 종료 문구 출력
3. 이동할 때마다 다리 건너기 결과 출력
4. 예외 처리 메세지 출력

## Controller

### Application
- InputView에서 입력값을 받아 Game으로 전달
- OutputView를 통해 Game 결과 출력
- 예외 발생시 catch 및 OutputView를 통해 출력

### BridgeGame
- 사용자 입력에 따라 BridgeMaker로 다리 생성
- 사용자 입력에 따라 이동
- 사용자 입력에 따라 게임 재시작

### BridgeMaker
- 사용자 입력에 따라 Bridge 생성
- BridgeRandomNumberGenerator 클래스를 사용해 랜던한 다리 생성

## Model
### Bridge
- U와 D로 구성되어있는 List<String>를 필드로 가지고 있음
- 위치와 이동방향을 입력으로 받아 필드의 브릿지와 비교

### Result
- 이동 실행 결과를 저장
- 결과를 Map으로 생성