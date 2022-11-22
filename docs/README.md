# 기능 구현 목록
### 1. 다리 길이 입력받기
* 예외처리 : 3 이상 20 이하의 숫자가 아닌 경우
### 2. 다리 생성
* 건널 수 있는 칸 0과 1 중 무작위 값으로 설정
  * 0 : 아래 칸(D), 1 : 위 칸(U)
* 정답지(?) 따로 list로 구현해둬야 함 -> BridgeMaker
### 3. 사용자로부터 이동할 칸(D 또는 U) 입력받기
* 이동할 칸을 건널 수 있으면 다리에 O, 없으면 X를 표시
* 예외처리 : U와 D 이외의 값을 입력한 경우
### 4. 건너려는 다리에 건널 수 있는지의 여부 표현하여 다리의 랜덤값 위치에 출력
* 무작위 값으로 설정한 값과 입력값 비교
  * 같으면 O, 다르면 X
### 5 -1. O일 경우 다리 길이만큼 3-5 과정 반복
* 다리 길이 = '0'의 개수일 경우 성공 -> 종료
  * 종료 출력 사항 : 최종 게임 결과, 게임 성공 여부 출력, 총 시도 횟수 출력
      * cf. 총 시도 횟수 : 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수
### 5-2. 실패 (3번에서 X 나오면) 시 재시작/종료 여부 입력
* 입력 받기
  * R - 재시작 시 2에서 만든 다리 재사용, 3-5 과정 반복
  * Q - 종료 출력 사항 : 최종 게임 결과, 게임 성공 여부, 총 시도한 횟수 출력
* 예외처리 : R, Q 외의 값 입력할 경우
---
## 1) InputView
* 다리 길이, U와 D 중 어디로 갈 건지, 종료/재시작
## 2) OutputView
* Map(그때그때의 다리 상태), 최종 게임 결과
## 3) BridgeGame
* move, retry(R 누른 경우)
## 4) BridgeMaker
* 다리 만들기
* 랜덤값으로 각 다리에 건널 수 있는 곳 표시해둠 (정답지)
## 5) BridgeRandomNumberGenerator
* 건널 수 있는 칸 무작위 설정
---
### 작동 방법
1. InputView 객체 생성 후 메서드를 통해 다리길이 입력 받기
* InputView inputView = new InputView();
* int size = inputView.readBridgeSize();
2. BridgeMaker 객체(BridgeNumberGenerator 객체를 매개변수로 함) 생성 후 다리길이를 매개변수로 넣어주어 정답지 리스트 만들기
* BridgeNumberGenerator bridgeNumberGenerator = new BridgeNumberGenerator();
* BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
* bridgeMaker.