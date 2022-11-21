### 구현 기능 목록
1. 기본 사용자 입출력 - InputView, OutputView 구현
   - bridge는 List라 가정하고 구현
2. 다리 생성 구현
3. 게임 상태 관리하는 BridgeGame 기능 구현 - 게임 상태 관련 필드, 메서드 구현
   - 사용자 입력에 따른 이동, 재시도 기능
   - 게임 상태 관리 위한 필드
4. 게임 전체 흐름 - Application 구현
5. 각종 입력 등에 대한 Validation 적용
   - 입력에 대한 Exception
     - 다리 길이
       - 숫자인지
       - 3에서 20 사이의 숫자인지
     - 칸 이동
       - U 또는 D인지
     - 재시도 여부
       - R 또는 Q인지
6. 구조 변경 및 Refactoring
   