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
### MapGenerator
- Result로부터 Map형태로 String Sequence를 만들어줌
- 데이터 타입으로 ResultType 사용

## Controller

### Application
- GameController 실행
- bridge game 반복
- game 끝나면 결과 출력

### BridgeGameController
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

### BridgeSize
- input 예외 검사
- size값 저장
### Result
- 이동 실행 결과를 저장
- 윗칸, 아랫칸의 정보를 ResultType으로 저장

### ResultType
- Success:O, Fail:X의 쌍으로 갖고 있음
- 성공, 혹은 실패로 변환

### Direction
- UP:U, DOWN:D의 쌍을 갖고 있음
- U와 D를 입력으로 Direction Type 반환

### GameCommand
- RETRY:R, QUIT:Q의 쌍을 갖고 있음
- R과 Q를 입력으로 GammeCommandType 반환