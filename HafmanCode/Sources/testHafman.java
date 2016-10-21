
import hafmanTree.HafmanTree;

import java.io.IOException;


public class testHafman {

	public static void main(String[] args) {
		englishRating();
		System.out.println("\n\n");		
		frenchRating();
		System.out.println("\n\n");
		actualRating();
	}
	

	
	private static void englishRating() {
		double[] rates = null;

		try {
			rates= StatisticsReader.readRatingFromFile("D:\\Java\\HafmanCode\\rating_files\\ENG_DIST.TXT");			
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		printResult("English Rating:",rates);
		
	}
	
	
	private static void frenchRating() {
		double[] rates = null;

		try {
			rates= StatisticsReader.readRatingFromFile("D:\\Java\\HafmanCode\\rating_files\\FRE_DIST.TXT");			
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		printResult("French Rating:",rates);
		
	}	

	private static void actualRating() {
		double[] rates = null;

		try {
			rates= StatisticsReader.countRatingInFile("D:\\Java\\HafmanCode\\rating_files\\ENGLISH.TXT");			
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		
		printResult("Actual Rating:", rates);
	}


	private static void printResult(String capion, double[] rates) {
		
		String line = "";
		for (int i=0;i<capion.length();i++)
			line += "=";
		
		System.out.println(capion);
		System.out.println(line);
		HafmanTree dictionary = new HafmanTree(rates);		
		dictionary.printCodesArray();		
		System.out.println("=====================");
		
		double hafmanCodingLength = dictionary.getAvgCodingLength();
		double naiveCodingLength = dictionary.getNaiveCodingLength();
		System.out.println("Hafman code avg length  = " + hafmanCodingLength);
		System.out.println("Naive  code avg length  = " + naiveCodingLength);
		System.out.println("Compression Rate        = " + naiveCodingLength/hafmanCodingLength);		
	}
}
