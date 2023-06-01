// ActiveModerator.
package main.person.moderator;

import java.util.ArrayList;

public class ActiveModerator extends Moderator {

	@Override
	public boolean enterance() {
		// 환영 인사 및 규칙 설명
		System.out.println(" .・。.・゜✭・.・✫・゜・。..・。.・゜✭・.・✫・゜・。..・。.・゜✭・.・✫・゜・。.\r\n" + 
				"안녕하세요~!! “고슬링 코드”의 진행을 맡은 사회자입니다!\r\n" + 
				"즐겁게 게임 하실 수 있도록 최선을 다 해보겠습니닷><\r\n"+
				"먼저 규칙에 대해 알아볼까요오?\r\n" + 
				"̩̩ .・。.・゜✭・.・✫・゜・。..・。.・゜✭・.・✫・゜・。..・。.・゜✭・.・✫・゜・。.\r\n" + 
				"저희 게임은 흰색 12개와 검은색 12개의 블록이 준비되어 있습니당!\r\n" +
				"\n"+
				"      게임이 시작되면 각자 4개의 블록을 뽑겠슴당\r\n"+
				" (뽑은 블록들은 자동으로 정렬되니 걱정은 넣어둬~~!)\r\n" + 
				"    우선 자신의 차례가 되면 블록을 한 개 뽑아주세요!\r\n" + 
				"      그 후에 가~장 중요한 단계입니다 집!중\r\n" + 
				"상대방의 몇 번째 블록이 어떤 숫자일지 초능력을 발휘해 추측해 보기~\r\n"+
				"\n"+
				"만약 정답을 맞출 경우 게임을 계속 할 수 있습니다! 당연히 원하는 경우에 멈출수도 있답니다 ㅎ 승리자의 권한이죠~~!\r\n" + 
				"하지만 틀릴 경우! 현재 턴 시작할 때 뽑은 자신의 블록을 공개해야 한다는 점 잊지 마세요 후후\r\n" +
				"\n"+
				"블록이 모두 공개가 되면 경기가 끝나니 다들 신중히 하지만 즐겁게! 게임을 진행해주세요~~\r\n" + 
				"그럼 행운을 빌게요~~GoodLuck!✿\r\n" + 
				" .・。.・゜✭・.・✫・゜・。..・。.・゜✭・.・✫・゜・。..・。.・゜✭・.・✫・゜・。.\r\n");
		return true;
	}

	@Override
	public void guideFirstTurn() {
		// 게임시작 멘트 및 초기 블럭 선택하라는 설명
		System.out.println(". ｡ ﾟ + . . ｡ 우선~! 게임에 필요한 블록을 각자 4개씩 뽑아주세요!! ｡+ . . ｡ *ﾟ +.\r\n");
	}

	@Override
	public void guidePick(String playerName) {
		// 턴 플레이어 블럭 추가 뽑기 안내
		System.out.println(".・。.・゜✭・"+playerName+"님의 턴입니다! 행운의 블록을 하나 뽑아주세요~~・✫・゜・。.\r\n");
	}

	@Override
	public void guideGuess(String playerName) {
		// 상대 플레이어의 블럭을 추측 안내
		System.out.println("ₓ˚. ୭ ˚○◦˚"+playerName+"님의 블록 하나를 추측해 주세요~!˚◦○˚ ୧ .˚ₓ\r\n");
	}

	@Override
	public void guideCorrect(String playerName) {
		// 추측이 맞을 경우, 상대방 블럭 공개 안내 
		System.out.println("♬♩♪♩정답입니다~! 대단한걸요!♩♪♩♬\r\n"+playerName+"님은 해당 블록을 제거해주세요!\r\n");
	}

	@Override
	public void guideKeepGoing() {
		// 계속 게임 할지 질문
		System.out.println("ﾟ+:ꔫ:﹤행운이 함께하는 당신께 특권을 드리겠습니다~! 한 번 더 상대의 블록을 맞춰보시겠어요??﹥:ꔫ:+ﾟ\r\n");
		
	}
	@Override
	public void guideWrong(String playerName) {
		// 추측이 틀릴 경우, 본인 블럭 공개 안내
		System.out.println("∘◦ ✂ —오웁! 아깝게도..틀렸습니다ㅠㅠ 아쉽지만"+playerName+"님이 가져오신 블록을 공개하겠습니다–✂ ◦∘\r\n");
	}

	@Override
	public void guideEnd(String playerName) {
		// 게임 종료 멘트
		System.out.println("【☆】★【☆】★【☆】★【☆】★【☆】【☆】★【☆】★【☆】★【☆】★【☆】\r\n"+
				"              승자는 두구두구두구~!! ♛"+playerName+"♛님 입니다~~!\r\n"+
				"【☆】★【☆】★【☆】★【☆】★【☆】【☆】★【☆】★【☆】★【☆】★【☆】\r\n");
	}


}