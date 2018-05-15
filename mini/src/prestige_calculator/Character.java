package prestige_calculator;

public class Character {
	private String name;
	private int honor;
	
	public Character(String name, int honor) {
		this.name = name;
		this.honor = honor;
	}
	
	/**
	 * Calculates the total honor on a character based on prestige
	 * and honor levels
	 * @param honorLevel
	 * @param prestigeLevel
	 * @return
	 */
	public static int getHonorForLevel(int prestigeLevel, int honorLevel, int leftovers) {
		int result = 0;
		int prestige = 0;
		int honor = 1;
		
		while (!(prestige >= prestigeLevel && honor >= honorLevel)) {
			result += 750;
			if (prestige == 0) {
				result -= 450;
			}
			result += ((int)Math.ceil(((double)honor)/10))*50;
			honor++;
			if (honor == 50) {
				prestige++;
				honor = 1;
			}
		}
		result += leftovers;
		return result;
	}
	
	public void add(int increase) {
		if (increase >= 0) {
			honor += increase;
		}
	}
	
	public int getHonor() {
		return honor;
	}
	
	/**
	 * returns the honor level after prestiging based on total honor
	 * @param honor
	 * @return
	 */
	public int getLevel() {
		int result = 0;
		int prestige = 0;
		int honorLevel = 1;
		
		while (result <= honor) {
			result += 750;
			if (prestige == 0) {
				result -= 450;
			}
			result += ((int)Math.ceil(((double)honorLevel)/10))*50;
			honorLevel++;
			if (honorLevel == 50) {
				prestige++;
				honorLevel = 1;
			}
		}
		
		return honorLevel;
	}
	
	/**
	 * returns the prestige level based on total honor
	 * @param honor
	 * @return
	 */
	public int getPrestige() {
		int result = 0;
		int prestige = 0;
		int honorLevel = 1;
		
		while (result <= honor) {
			result += 750;
			if (prestige == 0) {
				result -= 450;
			}
			result += ((int)Math.ceil(((double)honorLevel)/10))*50;
			honorLevel++;
			if (honorLevel == 50) {
				prestige++;
				honorLevel = 1;
			}
		}
		
		return prestige;
	}
}
