# 🚀 기능 목록 (체크리스트)

## 입력

- [X] 다리 사이즈를 입력받아서 반환 - InputView.readBridgeSize()
- [X] 위 아래 중 건널 다리를 입력받아서 반환 - InputView.readMoving()
- [X] 재시작 여부를 입력받아서 반환 - InputView.readGameCommand()

## 출력

- [X] 플레이어가 건널 다리를 입력하면 교통 가능 여부를 O,X로 표시한 다리를 출력 - OutputView.printMap()
- [X] 게임 성공 여부와 시도 횟수를 출력 - OutputView.printResult()

## 게임 기능

- [X] 입력받은 다리 길이만큼 생성 - BridgeMaker.makeBridge()
- [X] 생성된 다리의 위 아래 중 교통 가능한 다리를 랜덤으로 지정 - BridgeRandomNumberGenerator.generate()
- [X] 입력받은 건너갈 다리 위치가 교통 가능 여부 반환 - BridgeGame.move()
- [X] 다리 건너기를 실패한 경우 재시작 여부 반환 - BridgeGame.retry()
- [X] 다리를 다 건넌 경우와 재시작을 하지 않은 경우를 판별해 성공 여부 반환
- [X] 재시작을 몇 번 했는지를 판별해 시도 횟수 반환

## 예외

### 다리 길이 입력
- [X] 글자를 입력한 경우
- [X] 3 이상 20 이하의 숫자가 아닌 경우
- [X] 앞 숫자가 0인 경우

### 이동할 칸 입력
- [X] U, D 가 아닌 경우 - BridgeLocation.createLocation()

### 게임 재시작 여부 입력
- [X] R,Q 가 아닌 경우

## 기타 및 추가사항
- [X] 빈칸 입력시
- [X] 예외상황인 경우 예외 출력 후 다시 입력

## 참고사항

### FLOW CHART

![image](https://user-images.githubusercontent.com/92911823/202137219-9823a274-e54e-4986-b2b6-01b94463b92b.png)

### CLASS DIAGRAM

![image](https://user-images.githubusercontent.com/92911823/202137247-b5b262bf-ea1b-44a9-961a-22b7ceba9c1e.png)
