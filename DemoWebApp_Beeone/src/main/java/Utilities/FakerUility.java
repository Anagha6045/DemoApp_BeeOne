package Utilities;

import java.util.Random;

public class FakerUility {
	public int randomNumberCreation()
	{
		Random random= new Random();
		int random_Number = random.nextInt(10000);
		return random_Number;
	}

}
