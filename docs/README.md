## < 클래스 관계도 >
<br/>

![ClassDiagram](https://user-images.githubusercontent.com/96610382/202952542-991e098f-fecc-4414-8a5a-3a9b55bc1d4a.jpg)

<br/>
<br/>

## < 기능 구현 사항 >
<br/>

- [x] 다리 생성 기능
  - [x] 다리 길이가 숫자가 아닐 경우 예외 처리
  - [x] 다리 길이가 3~20 사이의 숫자가 아닐 경우 예외 처리
  - [x] BridgeMaker 로 다리 생성 후 BridgeJudge 객체에 저장


- [x] 다리 이동 기능 
  - [x] U나 D가 아닌 다른 입력이 주어질 때 예외 처리
  - [x] 매 이동 마다 이동 방향을 Player 객체의 MoveHistory 에 기록
  - [x] 이동 후 BridgeJudge 객체를 통하여 이동에 성공했는지 실패했는지 여부 확인
  - [X] 이동에 실패했을 경우, R또는 Q 명령어 받기
  - [X] R 또는 Q 명령어가 입력되지 않을 경우 예외 처리
  - [X] 명령어가 R일 경우 tryCount 증가와 MoveHistory 초기화 작업 수행
  - [X] 명령어가 Q 이거나 이동을 완료했을 때 이동 중지


- [x] 게임 종료 시 결과 출력 기능