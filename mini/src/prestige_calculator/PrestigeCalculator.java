package prestige_calculator;

import java.util.ArrayList;


/**
 * Instructions:
 * 1: fill out the arrays with the relevant data and run.
 * 2: the final prestige and honor level will be printed to the console.
 * @author yawnjohn
 *
 */
public class PrestigeCalculator {
	
	private ArrayList<Character> characters = new ArrayList<Character>();
	
	public static void main(String[] args) {
		PrestigeCalculator pc = new PrestigeCalculator();
		
		
		// prestige per character
		int[] prestigeLevels = {
				6,
				1
		};
		
		// current honor level per character (must be in the same order as prestige level)
		int[] honorLevels = {
				39,
				23
				
		};
		
		// honor progress into the current level
		int[] leftovers = {
				243, 
				24
		};

		String[] names = {
			//"This isn't necessary, you can just leave it empty",
		};
		if (names.length == 0) {
			names = new String[prestigeLevels.length];
		}
		
		pc.setChars(names, prestigeLevels, honorLevels, leftovers);
		
		System.out.println(pc.toString());
	}
	
	public int totalHonor() {
		int result = 0;
		for (Character c : characters) {
			result += c.getHonor();
		}
		return result;
	}
	
	//@ requires honorLevels.length == prestigeLevels.length
	public void setChars(String[] names, int[] prestigeLevels, int[] honorLevels, int[] leftovers) {
		for (int i = 0; i < honorLevels.length; i++) {
			addChar(names[i], prestigeLevels[i], honorLevels[i], leftovers[i]);
		}
	}
	
	public void addChar(String name, int prestigeLevel, int honorLevel, int leftovers) {
		characters.add(new Character(name, Character.getHonorForLevel(prestigeLevel, honorLevel, leftovers)));
	}
	
	public ArrayList<Character> getChars() {
		return characters;
	}
	
	public String toString() {
		String result = "";
		Character c = new Character(null, totalHonor());
		result = String.format("Prestige %d Honor Level %d", c.getPrestige(), c.getLevel());
		return result;
	}
}
