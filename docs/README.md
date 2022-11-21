# 4주차 다리건너기
## 기능 구현 목록

---
## BridgeController (Controller)
### 게임의 전체적 흐름을 관리하는 컨트롤러

---
## BridgeGame (input, outview X)
### - 사용자가 칸을 이동하는 역할(move)
### - 게임을 재시도하는 역할(retry)

## BridgeMaker
### - 입력받은 다리의 길이를 인자로 받아 다리를 생성하는 역할(makeBridge)

## BridgeNumberGenerator, RandomNumberGenerator
### - 0, 1 두개의 수 중 하나를 생성하여 건널 다리를 결정하는 역할

## Bridge
### - 다리의 상태를 리스트 형식으로 표현하는 역할

## Player
### - 사용자가 이동할 칸을 리스트 형식으로 표현하는 역할

---

## InputView
### - 다리의 길이를 입력받는 역할 (readBridgeSize)
### - 사용자가 이동할 칸을 입력받는 역할 (readMoving)
### - 게임 재시도 여부를 입력받는 역할 (readGameCommand)

## OutputView
### - 다리의 상태를 출력하는 역할 (printMap)
### - 게임 최종 결과를 출력하는 역할 (prntResult)

---
## Exception
### 다리 길이 입력이 3부터 20사이의 숫자가 아니라면 예외 발생
### 이동할 칸 입력 시 U, D이외의 문자가 입력되면 예외 발생

---

## 필요 상수
### 1. 이동할 칸을 나타내는 U, D
### 2. 재시도 여부를 나타내는 R, Q
### 3. 이동 가능 여부를 나타내는 O, X
### 4. 게임시작 메시지, 길이 입력요청 메시지, 이동할 칸 선택 메시지, 재시도 여부 메시지, 최종 게임 결과
### 5. 게임 성공 여부(성공, 실패), 총 시도 횟수

---
## 추가 요구사항
### BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.


## 피드백
### 메서드의 길이가 10라인을 넘어가지 않도록 구현
### 발생할 수 있는 예외 상황을 고민
### 비즈니스, UI로직 분리
### 연관성 있는 상수는 static final 대신 enum을 활용
### final을 사용해 값의 변경을 막는다
### 객체의 상태 접근을 제한
### 예외 케이스에 대한 케이스도 테스트
### private 메서드 테스트시 클래스 분리를 고려
