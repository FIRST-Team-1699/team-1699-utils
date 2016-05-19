package frc.team1699.auto;

public class Utils {
	
	public static int parseInt(String s){
		try{
			return Integer.parseInt(s);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
}
