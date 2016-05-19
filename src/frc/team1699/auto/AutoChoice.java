package frc.team1699.auto;

public class AutoChoice {
	
	private String[] choices = {"top", "bottom", "left", "right"};
	private String choice;
	
	public AutoChoice(String choice){
		//this.choice = choice;
	}
	
	public void setChoice(String s){
		this.choice = s;
	}
	
	public String getChoice(){
		return choice;
	}
}
