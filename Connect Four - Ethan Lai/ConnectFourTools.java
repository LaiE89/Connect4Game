// Ethan Lai
// Connect Four Methods - ICS3U1
// June 17, 2020
// Version 1.0

import arc.*;
import java.awt.*;
import java.awt.image.*;

public class ConnectFourTools{

// This method checks whether a player is a returning or a new player for people playing as Player 1.
	public static void CheckingUsernamePlayer1(Console Username, String strPlayer1){

// Variables
// Brings up the scoreboard text file
		TextInputFile scoreboard = new TextInputFile("scoreboard.txt");

// This variable counts the number of players according to my text document
		int intNum;

// For Loop variables
		int intCount;
		int intCount2;

// String Variables to assign to my arrays
		String strUsername;
		String strWins;
		String strLine;

// Array to put my text file data into
		String strScoreboard[][];
		
// Boolean to check whether a player's username is a returning player or not
		boolean blnReturnPlayer;
		
// Initializing variables
		blnReturnPlayer = false;
		intCount = 0;
		intNum = 0;

// While loop that checks how many lines are in the document
		while(scoreboard.eof() == false){
			strLine = scoreboard.readLine();
			intCount = intCount + 1;
		}
		scoreboard.close();

// Since my text document is organized by a "Player","Wins","Player","Wins" format, this checks how many players are in the text document by dividing the number of lines by two
		intNum = intCount / 2;					
		strScoreboard = new String[intNum][2];
		scoreboard = new TextInputFile("scoreboard.txt");

// For loop to put all the text file lines into a 2 by infinite array
		for(intCount2 = 0; intCount2 < intNum; intCount2++){
			strUsername = scoreboard.readLine();
			strWins = scoreboard.readLine();
			strScoreboard[intCount2][0] = strUsername;
			strScoreboard[intCount2][1] = strWins;

// If the player's username input is identical to a username in the text document, the boolean will be true. Otherwise, it will be false.
			if (strPlayer1.equalsIgnoreCase(strUsername)){
				blnReturnPlayer = true;
			}
		}
		scoreboard.close();
		
// This allows me to put the user input into the text document.
		TextOutputFile Outputtingscoreboard = new TextOutputFile("scoreboard.txt",true);
		
// If the boolean is false, the user input and a score of zero will be written into the text document.
		if(blnReturnPlayer == false){
			Outputtingscoreboard.println(strPlayer1);
			Outputtingscoreboard.println("0");
			Outputtingscoreboard.close();

// If the boolean is true, a new console saying welcome back will appear. Nothing will be written into the text document.	
		}else{
			Console WelcomeBack = new Console("Welcome Back",200,100);
			WelcomeBack.println("\n  Welcome Back");
			WelcomeBack.sleep(1000);
			WelcomeBack.closeWindow();
		}
		Outputtingscoreboard.close();		
	}

// Same method as the method above. Checks if the player is a returning player, but for Player 2s.
	public static void CheckingUsernamePlayer2(Console Username, String strPlayer2){
		TextInputFile scoreboard = new TextInputFile("scoreboard.txt");
		int intNum;
		int intCount;
		int intCount2;
		String strUsername;
		String strWins;
		String strLine;
		String strScoreboard[][];
		boolean blnReturnPlayer = false;
		
		intCount = 0;
		intNum = 0;
		while(scoreboard.eof() == false){
			strLine = scoreboard.readLine();
			intCount = intCount + 1;
		}
		scoreboard.close();
		intNum = intCount / 2;					
		strScoreboard = new String[intNum][2];
		scoreboard = new TextInputFile("scoreboard.txt");
		
		for(intCount2 = 0; intCount2 < intNum; intCount2++){
			strUsername = scoreboard.readLine();
			strWins = scoreboard.readLine();
			strScoreboard[intCount2][0] = strUsername;
			strScoreboard[intCount2][1] = strWins;
			if (strPlayer2.equalsIgnoreCase(strUsername)){
				blnReturnPlayer = true;
			}
		}
		scoreboard.close();
		TextOutputFile Outputtingscoreboard = new TextOutputFile("scoreboard.txt",true);
		
		if(blnReturnPlayer == false){
			Outputtingscoreboard.println(strPlayer2);
			Outputtingscoreboard.println("0");
			Outputtingscoreboard.close();	
		}else{
			Console WelcomeBack = new Console("Welcome Back",200,100);
			WelcomeBack.println("\n  Welcome Back");
			WelcomeBack.sleep(1000);
			WelcomeBack.closeWindow();
		}
		Outputtingscoreboard.close();		
	}

// The purpose of this method is to increase the number of wins by 1 when a player 1 wins.
	public static void Player1Wins(Console Board, String strPlayer1){
		
// Allows the program to read from the scoreboard.txt text document
		TextInputFile scoreboard = new TextInputFile("scoreboard.txt");
		
// Variables
// Counts the number of players as according to the text document
		int intNum;

// For loop variables
		int intCount;
		int intCount2;
		int intCount3;
		
// Variables to assign to my array
		int intUsernamePlace;
		String strUsername;
		String strWins;
		String strLine;

// Array to put my text document data into
		String strScoreboard[][];

// Initializing Variables
		intCount = 0;
		intNum = 0;
		intUsernamePlace = 0;

// Counts number of lines in text document
		while(scoreboard.eof() == false){
			strLine = scoreboard.readLine();
			intCount = intCount + 1;
		}
		scoreboard.close();

// Counts number of players in text document
		intNum = intCount / 2;					
		strScoreboard = new String[intNum][2];
		scoreboard = new TextInputFile("scoreboard.txt");

// For loop to put all the data in my text document into a 2 by infinite array		
		for(intCount2 = 0; intCount2 < intNum; intCount2++){
			strUsername = scoreboard.readLine();
			strWins = scoreboard.readLine();
			strScoreboard[intCount2][0] = strUsername;
			strScoreboard[intCount2][1] = strWins;

// If statement to check if Player 1 has a username thats identical to a username in the text document.
			if(strPlayer1.equalsIgnoreCase(strUsername)){
// If it does, the program grabs the number of wins for that player and increases it by one. To do this, the program converts the number of wins into an integer, then converts it back to a string that says that increased integer.
				intUsernamePlace = Integer.parseInt(strWins);
				strScoreboard[intCount2][1] = String.valueOf(intUsernamePlace + 1);
			}
		}
		scoreboard.close();

// Allows the user to output data to the text document. It's false to allow the program to rewrite the whole text document.
		TextOutputFile Outputtingscoreboard = new TextOutputFile("scoreboard.txt",false);

// For loop to rewrite all the information into the text document. This prints stored information from the array from the previous for loop.
		for(intCount3 = 0; intCount3 < intNum; intCount3++){
			Outputtingscoreboard.println(strScoreboard[intCount3][0]);
			Outputtingscoreboard.println(strScoreboard[intCount3][1]);
		}
		Outputtingscoreboard.close();		
	}

// Same method as the method above. However, its for Player 2s. The purpose of this method is to increase the number of wins by 1 when a player 2 wins.
	public static void Player2Wins(Console Board, String strPlayer2){
		TextInputFile scoreboard = new TextInputFile("scoreboard.txt");
		int intNum;
		int intCount;
		int intCount2;
		int intCount3;
		int intUsernamePlace;
		String strUsername;
		String strWins;
		String strLine;
		String strScoreboard[][];
		
		intCount = 0;
		intNum = 0;
		intUsernamePlace = 0;
		while(scoreboard.eof() == false){
			strLine = scoreboard.readLine();
			intCount = intCount + 1;
		}
		scoreboard.close();
		intNum = intCount / 2;					
		strScoreboard = new String[intNum][2];
		scoreboard = new TextInputFile("scoreboard.txt");
		
		for(intCount2 = 0; intCount2 < intNum; intCount2++){
			strUsername = scoreboard.readLine();
			strWins = scoreboard.readLine();
			strScoreboard[intCount2][0] = strUsername;
			strScoreboard[intCount2][1] = strWins;
			if(strPlayer2.equalsIgnoreCase(strUsername)){
				intUsernamePlace = Integer.parseInt(strWins);
				strScoreboard[intCount2][1] = String.valueOf(intUsernamePlace + 1);
			}
		}
		scoreboard.close();
		TextOutputFile Outputtingscoreboard = new TextOutputFile("scoreboard.txt",false);
		for(intCount3 = 0; intCount3 < intNum; intCount3++){
			Outputtingscoreboard.println(strScoreboard[intCount3][0]);
			Outputtingscoreboard.println(strScoreboard[intCount3][1]);
		}
		Outputtingscoreboard.close();		
	}

// Method to check whether Player 1 has a connect four. Red pieces are basically resembled by the number, 2.
	public static int CheckingConnectFourPlayer1(Console Board, String strPlayer1, String strPlayer2, int intTurn, int intGrid[][], int intCurrentColumn, int intCurrentRow, int intBackToMenu){

// For Loop Variables
		int ConnectFourCount;

// Variables that are increased when a red piece is next to another red piece. For instance, if 3 pieces are right next to eachother, intDiagonal will be 3.
		int intConnectFour1;
		int intHorizontal;
		int intDiagonal;
		int intDiagonal2;
		int intVertical;

// Boolean variables that prevent the program from counting up if a red piece is next to a yellow piece.
		boolean blnStopleft;
		boolean blnStopright;
		boolean blnStopdiagonal;
		boolean blnStopdiagonal2;
		boolean blnStopdiagonal3;
		boolean blnStopdiagonal4;

// Arrays that contain the XY coordinates of the board.
		int[] col = {10,90,175,262,350,435,520};
		int[] row = {60,140,220,300,380,460};

// Initializing Variables
		intHorizontal = 1;
		intDiagonal = 1;
		intDiagonal2 = 1;
		blnStopleft = false;
		blnStopright = false;
		blnStopdiagonal = false;
		blnStopdiagonal2 = false;
		blnStopdiagonal3 = false;
		blnStopdiagonal4 = false;

// For loop that increases up to four to check if there is a connect four. Horizontal and diagonal checks are in this for loop.
		for(ConnectFourCount = 1; ConnectFourCount < 4; ConnectFourCount++){

// Checking for horizontal connect fours
// Prevents the for loop from counting out of the array. Therefore, there would not be an error.
			if(intCurrentColumn + ConnectFourCount <= 6){
// If a red piece is next to another red piece from the right, the boolean will be false. Therefore, intHorizontal will be keep on counting up depending on how many red pieces are consecutively next to eachother.
				if(intGrid[intCurrentColumn + ConnectFourCount][intCurrentRow] == 2 && blnStopleft == false){
					intHorizontal = intHorizontal + 1;
// Otherwise, the boolean will true and the program will stop counting up.
				}else{
					blnStopleft = true;
				}
			}
// Same as above, but for the left side.
			if(intCurrentColumn - ConnectFourCount >= 0){
				if(intGrid[intCurrentColumn - ConnectFourCount][intCurrentRow] == 2 && blnStopright == false){
					intHorizontal = intHorizontal + 1;
				}else{
					blnStopright = true;
				}
			}

// Checking for Diagonal connect fours
// Prevents from counting out of the array; vertically and horizontally.
			if((intCurrentColumn + ConnectFourCount <= 6) && (intCurrentRow + ConnectFourCount <= 5)){
// Boolean is false if the user placed a red piece that is diagonally to the bottom right from another red piece. If boolean is false, counts up. 
				if(intGrid[intCurrentColumn + ConnectFourCount][intCurrentRow + ConnectFourCount] == 2 && blnStopdiagonal == false){
					intDiagonal = intDiagonal + 1;
// Otherwise, boolean is true and does not count up.
				}else{
					blnStopdiagonal = true;
				}
			}
// Same as above, but for the upper left diagonal.
			if((intCurrentColumn - ConnectFourCount >=0) && (intCurrentRow - ConnectFourCount >= 0)){
				if(intGrid[intCurrentColumn - ConnectFourCount][intCurrentRow - ConnectFourCount] == 2 && blnStopdiagonal2 == false){
					intDiagonal = intDiagonal + 1;
				}else{
					blnStopdiagonal2 = true;
				}
			}
// Same as above, but for the upper right diagonal.
			if((intCurrentColumn + ConnectFourCount <= 6) && (intCurrentRow - ConnectFourCount >= 0)){
				if(intGrid[intCurrentColumn + ConnectFourCount][intCurrentRow - ConnectFourCount] == 2 && blnStopdiagonal3 == false){
					intDiagonal2 = intDiagonal2 + 1;
				}else{
					blnStopdiagonal3 = true;
				}
			}
// Same as above, but for the upper left diagonal.
			if((intCurrentColumn - ConnectFourCount >=0) && (intCurrentRow + ConnectFourCount <= 5)){
				if(intGrid[intCurrentColumn - ConnectFourCount][intCurrentRow + ConnectFourCount] == 2 && blnStopdiagonal4 == false){
					intDiagonal2 = intDiagonal2 + 1;
				}else{
					blnStopdiagonal4 = true;
				}
			}
		}

// Checking for vertical connect fours
		intVertical = 0;
// This is the simplest because vertical connect fours can only be created from the bottom up.
// Prevents from counting out of the array.
		if(intCurrentRow + 1 <= 5 && intCurrentRow + 2 <= 5 && intCurrentRow + 3 <= 5){
// Checks if the four pieces below the user's currently placed piece is a red piece.
			if(intGrid[intCurrentColumn][intCurrentRow+1] == 2 && intGrid[intCurrentColumn][intCurrentRow+2] == 2 && intGrid[intCurrentColumn][intCurrentRow+3] == 2){
// If the four pieces below is red, variable is equal is one.
				intVertical = 1;
			}
		}

// Checking if there are any connect fours
		intConnectFour1 = 0;
// If any of the checking variables are equal to or greater than a connect four.
		if(intVertical == 1 || intDiagonal >= 4 || intDiagonal2 >= 4 || intHorizontal >= 4){
// If there is, then the variables are reduced back to zero to prevent repetition.
			intVertical = 0;
			intHorizontal = 0;
			intDiagonal = 0;
			intDiagonal2 = 0;
// Variable that will be returned back to the main program if a player does win. If this variable is one, a win screen will appear.
			intConnectFour1 = 1;
		}
		return intConnectFour1;
	}

// Same method as the method above. Except this method is used to check whether Player 2 has a connect four. Yellow pieces are basically resembled by the number, 1.
	public static int CheckingConnectFourPlayer2(Console Board, String strPlayer1, String strPlayer2, int intTurn, int intGrid[][], int intCurrentColumn, int intCurrentRow, int intBackToMenu){
		int ConnectFourCount;
		int intConnectFour2;
		int intHorizontal;
		int intDiagonal;
		int intDiagonal2;
		boolean blnStopleft;
		boolean blnStopright;
		boolean blnStopdiagonal;
		boolean blnStopdiagonal2;
		boolean blnStopdiagonal3;
		boolean blnStopdiagonal4;
		int intVertical;
		int[] col = {10,90,175,262,350,435,520};
		int[] row = {60,140,220,300,380,460};

// Initializing
		intHorizontal = 1;
		intDiagonal = 1;
		intDiagonal2 = 1;
		blnStopleft = false;
		blnStopright = false;
		blnStopdiagonal = false;
		blnStopdiagonal2 = false;
		blnStopdiagonal3 = false;
		blnStopdiagonal4 = false;

// Horizontal
		for(ConnectFourCount = 1; ConnectFourCount < 4; ConnectFourCount++){
			if(intCurrentColumn + ConnectFourCount <= 6){
				if(intGrid[intCurrentColumn + ConnectFourCount][intCurrentRow] == 1 && blnStopleft == false){
					intHorizontal = intHorizontal + 1;
				}else{
					blnStopleft = true;
				}
			}
			if(intCurrentColumn - ConnectFourCount >= 0){
				if(intGrid[intCurrentColumn - ConnectFourCount][intCurrentRow] == 1 && blnStopright == false){
					intHorizontal = intHorizontal + 1;
				}else{
					blnStopright = true;
				}
			}
// Diagonals
			if((intCurrentColumn + ConnectFourCount <= 6) && (intCurrentRow + ConnectFourCount <= 5)){
				if(intGrid[intCurrentColumn + ConnectFourCount][intCurrentRow + ConnectFourCount] == 1 && blnStopdiagonal == false){
					intDiagonal = intDiagonal + 1;
				}else{
					blnStopdiagonal = true;
				}
			}
			if((intCurrentColumn - ConnectFourCount >=0) && (intCurrentRow - ConnectFourCount >= 0)){
				if(intGrid[intCurrentColumn - ConnectFourCount][intCurrentRow - ConnectFourCount] == 1 && blnStopdiagonal2 == false){
					intDiagonal = intDiagonal + 1;
				}else{
					blnStopdiagonal2 = true;
				}
			}
			if((intCurrentColumn + ConnectFourCount <= 6) && (intCurrentRow - ConnectFourCount >= 0)){
				if(intGrid[intCurrentColumn + ConnectFourCount][intCurrentRow - ConnectFourCount] == 1 && blnStopdiagonal3 == false){
					intDiagonal2 = intDiagonal2 + 1;
				}else{
					blnStopdiagonal3 = true;
				}
			}
			if((intCurrentColumn - ConnectFourCount >=0) && (intCurrentRow + ConnectFourCount <= 5)){
				if(intGrid[intCurrentColumn - ConnectFourCount][intCurrentRow + ConnectFourCount] == 1 && blnStopdiagonal4 == false){
					intDiagonal2 = intDiagonal2 + 1;
				}else{
					blnStopdiagonal4 = true;
				}
			}
		}

// Vertical
		intVertical = 0;
		if(intCurrentRow + 1 <= 5 && intCurrentRow + 2 <= 5 && intCurrentRow + 3 <= 5){
			if(intGrid[intCurrentColumn][intCurrentRow+1] == 1 && intGrid[intCurrentColumn][intCurrentRow+2] == 1 && intGrid[intCurrentColumn][intCurrentRow+3] == 1){
				intVertical = 1;
			}
		}

// Win Screen
		intConnectFour2 = 0;
		if(intVertical == 1 || intDiagonal >= 4 || intDiagonal2 >= 4 || intHorizontal >= 4){
			intVertical = 0;
			intHorizontal = 0;
			intDiagonal = 0;
			intDiagonal2 = 0;
			intConnectFour2 = 1;
		}
		return intConnectFour2;
	}
}
