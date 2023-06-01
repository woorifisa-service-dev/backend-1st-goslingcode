package main.game;

import java.util.ArrayList;
import java.util.Scanner;

import main.block.Block;
import main.person.moderator.ActiveModerator;
import main.person.moderator.CalmModerator;
import main.person.moderator.Moderator;
import main.person.player.Player;

public class Game {
	private Player player1;
	private Player player2;
	private Moderator moderator;
	private Block block = new Block();
	
	public void startGame() {
		System.out.println("고슬링 게임에 오신 것을 환영합니다.");
		enterPlayer();
		selectModerator();
		moderator.enterance();
		playGame();
	}
	
	public void playGame() {
		ArrayList<Integer> blackHole = block.generateFirst();
		boolean isPlayer1Turn = true;
		
		moderator.guideFirstTurn();
		firstTurn(blackHole);
		moderator.guidePick(player1.getName());
		pickOne(blackHole);
		
		boolean gameFlag = true;
		int count = 0;
		while(gameFlag) {
			boolean conFlag = true;
			if (isPlayer1Turn) {
				while (conFlag) {
					if (guess(player1, player2)) {
						correct(player2.getName());
						conFlag = stopOrGoing();
						if(conFlag) break;
					} else {
						wrong(player1);
						conFlag = !conFlag;
					}
				}
			} else {
				while (conFlag) {
					if (guess(player2, player1)) {
						correct(player1.getName());
						conFlag = stopOrGoing();
					} else {
						wrong(player2);
						conFlag = !conFlag;
					}
				}
			}
			isPlayer1Turn = !isPlayer1Turn;
			count++;
			if (count == 6) {
				gameFlag = !gameFlag;
			}
		}
		endGame(player1);
		
	}
	
	public void endGame(Player winner) {
		moderator.guideEnd(winner.getName());
	}
	
	public void enterPlayer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("플레이어1의 이름을 입력해주세요 : ");
		String name1 = scanner.next();
		System.out.println("플레이어2의 이름을 입력해주세요 : ");
		String name2 = scanner.next();
		player1 = new Player(name1);
		player2 = new Player(name2);
	}
	
	public void selectModerator() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("취향에 맞는 사회자를 골라주세요");
		System.out.println("활기찬 사회자는를 원하시면 1을, 차분한 사회자를 원하시면 2를 눌러주세요");
		int modNum = scanner.nextInt();
		if (modNum == 1) {
			moderator = new ActiveModerator();
		} else {
			moderator = new CalmModerator();
		}
	}
	
	public void firstTurn(ArrayList<Integer> blackHole) {
		block = new Block();
		player1.pickFirst(blackHole);
		player2.pickFirst(blackHole);
	}
	
	public void pickOne(ArrayList<Integer> blackHole) {
		player1.pickOne(blackHole);
		player2.pickOne(blackHole);
	}
	
	public boolean guess(Player attacker, Player defender) {
		moderator.guideGuess(defender.getName());
		Scanner scanner = new Scanner(System.in);
		System.out.printf("몇번째 블록을 선택하시겠어요? >> ");
		int selectIndex = scanner.nextInt();
		
		System.out.printf(selectIndex + "번째 블록은 어떤 숫자일까요? >> ");
		int selectNum = scanner.nextInt();
		
		boolean result = moderator.judge(defender.getMyBlocks(), selectIndex, selectNum);
		System.out.println("결과 : " + result);
		return result;
	}
	
	public void correct(String defencer) {
		moderator.guideCorrect(defencer);
//		openOpponentBlock();
//		stopOrGoing();
	}
	public void openOpponentBlock() {
		
	}
	public boolean stopOrGoing() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("계속 공격하시려면 1을 멈추시려면 2를 눌러주세요");
		int flag = scanner.nextInt();
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}
	public void wrong(Player attacker) {
		moderator.guideWrong(attacker.getName());
		openMineBlock(attacker);
	}
	public void openMineBlock(Player attacker) {
		System.out.println("가져오신 블록은 " + attacker.getRandomNumber()+"입니다.");
		System.out.println("다음 차례!!");
	}
	public void checkNotOpen() {
		
	}
	public void askContinue( ) {
		
	}
}