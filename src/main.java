import java.util.Arrays;
import java.util.Scanner;

public class main {
	static Scanner in = new Scanner(System.in);
	static player player1;
	static player player2;
	static player turn;
	public static boolean checkName(String name) {
		return name.indexOf(" ") == -1 && name.indexOf("-")==-1;
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	
	public static String input(String str) {
		print(str);
		String intake = in.nextLine();
		return intake;
	}
	
	public static void executeCommand(String command, String Arguments) {
		if(command.equals("Orlog")) {
			TakeNames(Arguments);
		}else if(command.equals("roll")) {
			TakeRolls(Arguments);
		}else if(command.equals("godfavor")) {
			TakeGodFavor(Arguments);
		}
			else {
			println("Kindly enter correct command...");
		}
	}
	public static void executeCommand(String command) {
		if(command.equals("print")) {
			printPlayers();
		}else if(command.equals("turn")) {
			if(turn.equals(player1)) {
				println(player2.getName());
				turn = player2;
			}else {
				println(player1.getName());
				turn = player1;
			}
		}else {
			println("Kindly enter correct command...");
		}
	}
	
	public static boolean TakeNames(String Arguments) {
		String[] ArgumentList = Arguments.split(";");
		String name1 = null;
		String name2 = null;
		try {			
			if(checkName(ArgumentList[0])&&checkName(ArgumentList[1])) {
				name1 = ArgumentList[0];
				name2 = ArgumentList[1];
			}else {
				return false;
			}
			Long LifePoints = Long.parseLong(ArgumentList[2]);
			if(LifePoints<=5) {
				LifePoints = 5l;
			}
			Short GodPower = Short.parseShort(ArgumentList[3]);
			player1 = new player(name1, LifePoints, GodPower);
			player2 = new player(name2, LifePoints, GodPower);
			turn = player1;
			return true;
		}catch(Exception e){
			print(e.getStackTrace());
			return false;
		}
	}
	public static boolean TakeRolls(String Arguments) {
		String[] ArgumentList = Arguments.split(";");
		int len = ArgumentList.length;
		String[] RollList = {"","","","","",""};
		Short GodPowerRoll = 0;
		if(len!=6) {
			println("Please enter all the rolls...");
			return false;
		}
		for(int i=0;i<len;i++) {
			String roll = ArgumentList[i];
			if(!Arrays.stream(dice.getRolls()).anyMatch(roll::equals)) {
				println("There is no "+roll+" roll. Please enter correctly...");
				return false;
			}
			if(roll.contains("G")) {
				if(!(++GodPowerRoll<5)) {
					println("GodPower roll may not exceed 4. Please enter correctly...");
					return false;
				}roll = roll.split("G")[1];
			}RollList[i] = roll;
		}
		turn.setRolls(RollList);
		printL(RollList);
		turn.setGodPower(GodPowerRoll);
		return true;
	}
	
	public static void TakeGodFavor(String Arguments) {
		String[] ArgumentList = Arguments.split(";");
		String Favor = ArgumentList[0];
		byte level = Byte.parseByte(ArgumentList[1]);
		if(!Arrays.stream(godFavor.getFavors()).anyMatch(Favor::equals)) {
			println("God Favor doesn't exist...");
		}else if(level>3||level<1) {
			println("God Favor level is not valid...");
		}else {
			turn.setGodFavorSelected(Favor);
			turn.setGodFavorLevel(level);
		}
	}
	
	public static void printL(String[] list) {
		for(String str: list) {
			println(str);
		}
	}
	
	public static void printPlayers() {
		println(player1.show());
		println(player2.show());
	}
	
	
	public static void end() {
		in.close();
		print("----------------------------\nProgram Ended\n----------------------------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String UserInput1;
		String command;
		String Arguments;
		while(true) {
			UserInput1 = input("> ").strip();
			if(UserInput1.equals("quit")) {
				break;
			}
			if(UserInput1.contains(" ")) {
				String[] InputSplit = UserInput1.split(" ");
				int len = InputSplit.length;
				command = InputSplit[len-2];
				Arguments = InputSplit[len-1];
				executeCommand(command, Arguments);
			}else {
				command = UserInput1;
				executeCommand(command);
			}
		}
		// Ending the script
		end();
	}
}
