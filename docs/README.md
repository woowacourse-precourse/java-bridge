# 기능 목록 - 다리 건너기

## 1. 기능 구현

### 1.1 다리 만들기

- 다리 길이 입력받기
- 건널 수 있는 다리 - 무작위 값 생성

### 1.2 다리 건너기 (반복)

- 이동할 칸 입력받기
- 이동 가능 시 이동, 불가능 시 재시작 여부 입력받기
- 결과 반환

## 2. 클래스 별 기능

Application 클래스에서 전체적인 흐름 관리.

### 2.1 InputView

- 다리 크기 입력받기 → BridgeMaker에 전달
- 이동할 칸 입력받기 → BridgeMaker에 전달 후 건널 수 있는 지 확인
- 재시작 여부 입력받기 → Application 클래스에서 다시 InputView로 넘기기

### 2.2 BridgeGame

- 이동 후 결과 출력하기
- 최종 결과 출력하기

### 2.3 BridgeMaker

- 다리 생성하기
- 건널 수 있는 지 가능 여부 반환하기 → 결과 BrdgeGame에 전달

### 2.4 BridgeRandomNumberGenerator