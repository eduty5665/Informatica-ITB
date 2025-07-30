package aulaDia22;
import java.util.*;
import java.text.*;

public class Card {
	
	private static Random mRnd = new Random();
	
	private static List<Integer> mListColB = new ArrayList<Integer>();
	private static List<Integer> mListColI = new ArrayList<Integer>();
	private static List<Integer> mListColN = new ArrayList<Integer>();
	private static List<Integer> mListColG = new ArrayList<Integer>();
	private static List<Integer> mListColO = new ArrayList<Integer>();
	
	private static List<Integer> mListNumbers = new ArrayList<Integer>();
	
	private static int mTotalNumbers = 75;
	private static int mTotalColumns = 5;
	private static int mTotalRows = 5;
	
	private static NumberFormat nf = new DecimalFormat("00");
	
	public static void setListNumbers() {
		int i = 0;
		while(i < mTotalNumbers) {//isso está bugado
			mListNumbers.add(0);
			i++;
		}
		
	}

	public static void setColumns() {
		int i = 0;
		while(i < mTotalColumns) {
			mListColB.add(0);
			mListColI.add(0);
			mListColN.add(0);
			mListColG.add(0);
			mListColO.add(0);
			i++;
		}
	}
	
	public static boolean isMark(int number) {
		return mListNumbers.get(number).equals(1);
		//isso está bugado
	}
	
	public static void createCard() {
		int randomNumber = mRnd.nextInt(15) +1;
		int min = 1;
		int max = 15;
		//agora é o agrupamento dos alunos
		for(int row=0; row < 5; row++) {
			for(int col=0; col < 5; col++) {}
		}
	}
	
}
