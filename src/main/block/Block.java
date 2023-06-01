package main.block;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Block {
	private final static int min = 0;
	private final static int max = 11;
	private ArrayList<Integer> blackhole = new ArrayList<Integer>();
	
	public ArrayList<Integer> generateFirst() {
		// (0~11까지)x2 들어가도록 블랙홀 Arraylist 초기화
		
		for(int i = min; i <= max; i++) {
			blackhole.add(i);
			blackhole.add(i);
		}	
		return blackhole;		
	}
	
}