// Ethan Lai
// Connect Four - ICS3U1
// June 17, 2020
// Version 1.0

import arc.*;
import java.awt.*;
import java.awt.image.*;

public class MainConnectFourEthanLai{
	public static void main(String[] args){

// Connect Four "Checking Winner" variables
		int intConnectFour1;
		int intConnectFour2;

// Scoreboard Variables
		int intNum;
		int intCount;
		int intCount2;
		int intCount3;
		int intCount4;
		int intTop;
		int intBottom;
		String strTemp;
		String strScoreboard[][];
		String strUsername;
		String strWins;
		String strLine;
		
// Mouse Variables
		int intMouseX;
		int intMouseY;
		int intMouseClick;
		int intPage;
		int intBackToMenu;
		boolean blnClickReleased;
		
// Other Variables
		String strPlayer1;
		String strPlayer2;
		int intTurn;
		int intFullBoard;
		String strGetOutOfHOP;
		String strGetOutOfScores;
		
// Array Variables
		int intGrid[][];
		intGrid = new int[7][6];
		int col[] = {10,90,175,262,350,435,520};
		int row[] = {60,140,220,300,380,460};
		int intCurrentColumn;
		int intCurrentRow;
		
// Logo Screen. Does nothing, goes away after a few seconds.
		Console Opening = new Console("Connect Four - Ethan Lai",600,600);
		BufferedImage Logo = Opening.loadImage("Logo.png");
		Opening.drawImage(Logo,130,80);
		Opening.repaint();
		Opening.setDrawColor(Color.WHITE);
		Opening.drawString("PRESENTS",250,380);
		Opening.repaint();
		Opening.sleep(2000);
		Opening.closeWindow();

// While loop that always runs no matter what. Whole game runs on this loop. Allows the game to restart once gameplay is over.		
		while(true){
			intBackToMenu = 1;
			intPage = 0;
// Console screen that dispays the menu
			Console Menu = new Console("Menu",600,600);
			BufferedImage menubackground = Menu.loadImage("menubackground.jpg");
			Menu.drawImage(menubackground,0,0);	
			Menu.setDrawColor(Color.WHITE);
			Menu.drawString("===== ===== ==  = ==  = ===== ===== =====    /|  ", 15, 20);
			Menu.drawString("|     |   | |=  | |=  | |     |       |     / |  ", 15, 40);
			Menu.drawString("|     |   | | = | | = | ===== |       |    /  |  ", 15, 60);
			Menu.drawString("|     |   | |  =| |  =| |     |       |   ====|= ", 15, 80);
			Menu.drawString("===== ===== =  == =  == ===== =====   =       |  ", 15, 100);
			Menu.setDrawColor(Color.WHITE);
			Menu.drawString("Play", 50, 150);
			Menu.drawString("View High Scores", 50, 200);			
			Menu.drawString("How to Play", 50, 250);			
			Menu.drawString("Quit", 50, 300);		
			Menu.repaint();

// Main menu buttons
			while(intPage == 0){
// These variables are used to detect the mouse's current coordinates and whether the use left clicked or not.
				intMouseClick = Menu.currentMouseButton();
				intMouseX = Menu.currentMouseX();
				intMouseY = Menu.currentMouseY();

// Quit Button
// if the mouse is at these coordinates, the word will be redrawn and it's color will change.
				if(intMouseX < 50 || intMouseX > 100 || intMouseY < 300 || intMouseY > 325){
					Menu.setDrawColor(Color.WHITE);
					Menu.drawString("Quit", 50, 300);
					Menu.repaint();
				}if(intMouseX > 50 && intMouseX < 100 && intMouseY > 300 && intMouseY < 325){
					Menu.setDrawColor(new Color(150,150,150));
					Menu.drawString("Quit", 50, 300);
					Menu.repaint();
// If the user clicks while it is at these coordinates, the console will be closed to prevent any loop from happening.
				}if(intMouseClick == 1 && intMouseX > 50 && intMouseX < 100 && intMouseY > 300 && intMouseY < 325){
					Menu.closeConsole();
					
// How to Play Button
// If the mouse is at these coordinates, the word will be redrawn and it's color will change.
				}if(intMouseX < 50 || intMouseX > 180 || intMouseY < 250 || intMouseY > 275){
					Menu.setDrawColor(Color.WHITE);
					Menu.drawString("How to Play", 50, 250);	
					Menu.repaint();
				}if(intMouseX > 50 && intMouseX < 180 && intMouseY > 250 && intMouseY < 275){
					Menu.setDrawColor(new Color(150,150,150));
					Menu.drawString("How to Play", 50, 250);	
					Menu.repaint();
// If the mouse is at these coordinates and the user clicked, the intPage will change to prevent the menu loop from reoccurring. Also, a new console will be created.
				}if(intMouseClick == 1 && intMouseX > 50 && intMouseX < 180 && intMouseY > 250 && intMouseY < 275){
					intPage = 1;
					Menu.closeWindow();
					Console Help = new Console("How to Play",600,600);
// Shows the instructions on how to play the game.
					BufferedImage helpbackground = Help.loadImage("helpbackground.jpg");
					Help.drawImage(helpbackground,260,0);
					Help.repaint();
					Help.println("");
					Help.println(" 1. Click on a mode. Either play against a"); 
					Help.println("    computer or another player. Two players");
					Help.println("    would need to play using the same computer.");
					Help.println("");
					Help.println(" 2. Enter your username. Your username will be");
					Help.println("    recorded. Player 1s would be using red");
					Help.println("    pieces. Player 2s would be using yellow");
					Help.println("    pieces.");
					Help.println("");
					Help.println(" 3. Click on the column you want to place your");
					Help.println("    piece in. Keep on doing so in a turn");
					Help.println("    based style until your pieces line up four");
					Help.println("    in a row.");
					Help.println("");
					Help.println(" 4. Wins will be recorded. Go back to the main");
					Help.println("    menu and click on 'View High Scores' to see");
					Help.println("    how many wins you have.");
					Help.println("");
					Help.println("");
					Help.println("    Press enter to go back to menu");
					Help.println("    PS. Don't type joke pls...");
// If the user types anything, the help menu will be closed. However if joke is typed, the user will be brought to a new console that displays a meme. This console will be closed after a few seconds.
					strGetOutOfHOP = Help.readLine();
					if(strGetOutOfHOP.equalsIgnoreCase("joke")){
						Help.closeWindow();
						Console Joke = new Console("Joke",600,600);
						BufferedImage Meme = Joke.loadImage("Meme.jpg");
						Joke.drawImage(Meme,125,50);
						Joke.repaint();
						Joke.sleep(6000);
						Joke.closeWindow();
					}
					Help.closeWindow();
					
// Scores Button
// If the user's mouse is at these coordinates, the text will be redrawn and recolored.
				}if(intMouseX < 50 || intMouseX > 250 || intMouseY < 200 || intMouseY > 225){
					Menu.setDrawColor(Color.WHITE);
					Menu.drawString("View High Scores", 50, 200);
					Menu.repaint();
				}if(intMouseX > 50 && intMouseX < 250 && intMouseY > 200 && intMouseY < 225){
					Menu.setDrawColor(new Color(150,150,150));
					Menu.drawString("View High Scores", 50, 200);
					Menu.repaint();
// If the user's mouse is at these coordinates and the user clicked, the user will be brought to a new page. Also, intPage will be different to prevent a reloop of the menu.
				}if(intMouseClick == 1 && intMouseX > 50 && intMouseX < 250 && intMouseY > 200 && intMouseY < 225){
					intPage = 1;
					Menu.closeWindow();
					Console Scores = new Console("High Scores",600,600);
					BufferedImage scoresbackground = Scores.loadImage("scoreboardbackground.jpg");
					Scores.drawImage(scoresbackground,0,0);
// Allows the program to read from the scoreboard.txt text document.
					TextInputFile scoreboard = new TextInputFile("scoreboard.txt");
// Initializing Variables
					intCount = 0;
					intNum = 0;
					Scores.setDrawColor(Color.WHITE);
					Font ScoreFont = Scores.loadFont("SeasideResort.ttf", 20);
					Scores.setDrawFont(ScoreFont);
					Scores.drawString("Top 10 Players",210,10);
					Scores.println("");
					Scores.println("");
					Scores.println("");
					Scores.println("");
					Scores.drawString("Players",12,50);
					Scores.drawString("Wins",525,50);
					Scores.repaint();

// Counts number of lines in the text document
					while(scoreboard.eof() == false){
						strLine = scoreboard.readLine();
						intCount = intCount + 1;
					}
					scoreboard.close();
// Counts number of players in the text document. Since the text document is arranged in "players", "wins", "players", "wins", dividing the number of lines by two will get the total number of players.
					intNum = intCount / 2;			
// Creating an array to place the text document data into. Also, reopening the text file since it was previously closed.	
					strScoreboard = new String[intNum][2];
					scoreboard = new TextInputFile("scoreboard.txt");

// For loop to place all the data from the text document into the array.
					for(intCount2 = 0; intCount2 < intNum; intCount2++){
						strUsername = scoreboard.readLine();
						strWins = scoreboard.readLine();
						strScoreboard[intCount2][0] = strUsername;
						strScoreboard[intCount2][1] = strWins;
					}
					scoreboard.close();

// Bubble sorting to sort the number of wins from most to least from the array.
// For loops. Subtracted by one to prevent the loop from counting out of the array. Repeats every command underneath until it reaches the end of the array.
					for(intCount4 = 0; intCount4 < intNum - 1; intCount4++){
						for(intCount3 = 0; intCount3 < intNum - 1; intCount3++){
// Assigns the variables, intTop and intBottom, to every pair of wins in the array
							intTop = Integer.parseInt(strScoreboard[intCount3][1]);
							intBottom = Integer.parseInt(strScoreboard[intCount3+1][1]);
// If one number is bigger than the other, moves the bigger number on top. Since it is in a for loop, this will keep on repeating until the numbers are sorted from greatest to least.
							if(intTop < intBottom){
								strTemp = strScoreboard[intCount3][1];
								strScoreboard[intCount3][1] = strScoreboard[intCount3+1][1];
								strScoreboard[intCount3+1][1] = strTemp;

// Reorders the usernames as according to the arrangement of wins
								strTemp = strScoreboard[intCount3][0];
								strScoreboard[intCount3][0] = strScoreboard[intCount3+1][0];
								strScoreboard[intCount3+1][0] = strTemp;
							}
						}
					}
// For loop that caps at 10 to display the top ten players by wins. Prints data from the sorted array.
					for(intCount2 = 0; intCount2 < 10; intCount2++){
						Scores.print("\n "+(strScoreboard[intCount2][0]+"                                              ").substring(0,43));
						Scores.println(strScoreboard[intCount2][1]);
					}

// Allows the user to press enter to return back to menu.
					Scores.println("\n\t Press enter to go back to menu");
					strGetOutOfScores = Scores.readLine();
					Scores.closeWindow();
					
// Play Button
// If mouse is hovering above these coordinates, the text will change color.
				}if(intMouseX < 50 || intMouseX > 100 || intMouseY < 150 || intMouseY > 175){
					Menu.setDrawColor(Color.WHITE);
					Menu.drawString("Play", 50, 150);
					Menu.repaint();
				}if(intMouseX > 50 && intMouseX < 100 && intMouseY > 150 && intMouseY < 175){
					Menu.setDrawColor(new Color(150,150,150));
					Menu.drawString("Play", 50, 150);
					Menu.repaint();
// If mouse clicks while it is in these coordinates, intPage will turn to one, preventing the menu from looping again. Then a new console will appear.
				}if(intMouseClick == 1 && intMouseX > 50 && intMouseX < 100 && intMouseY > 150 && intMouseY < 175){
					intPage = 1;
					Menu.closeWindow();
					Console Gamemode = new Console("Connect Four",600,600);
					BufferedImage Gamemodebackground = Gamemode.loadImage("Gamemodebackground.jpg");
					Gamemode.drawImage(Gamemodebackground,0,-300);
// While intBackToMenu equals to 1, the program will grab the user's mouse buttons and coordinates.
					while(intBackToMenu == 1){
						intMouseClick = Gamemode.currentMouseButton();
						intMouseX = Gamemode.currentMouseX();
						intMouseY = Gamemode.currentMouseY();

// If user clicks, "Against Computer"
// This code is use to grab the user's mouse input to check if they did click on "Against Computer".
						if(intMouseX < 210 || intMouseX > 410 || intMouseY < 150 || intMouseY > 175){
							Gamemode.setDrawColor(Color.WHITE);
							Gamemode.drawString("Against Computer", 210, 150);
							Gamemode.repaint();
						}if(intMouseX > 210 && intMouseX < 410 && intMouseY > 150 && intMouseY < 175){
							Gamemode.setDrawColor(new Color(150,150,150));
							Gamemode.drawString("Against Computer", 210, 150);
							Gamemode.repaint();
						}if(intMouseClick == 1 && intMouseX > 210 && intMouseX < 410 && intMouseY > 150 && intMouseY < 175){
							Gamemode.closeWindow();
							Console Username = new Console("Username",600,600);
							BufferedImage Usernamebackground = Username.loadImage("Usernamebackground.jpg");
							Username.drawImage(Usernamebackground,0,0);
							Username.println("\n\n\n\n\t      What is your username?");
							strPlayer1 = Username.readLine();
// Runs a method that checks whether the string input was already taken or not. Check ConnectFourTools.java for comments about the method.
							ConnectFourTools.CheckingUsernamePlayer1(Username, strPlayer1);					
							Username.closeWindow();
// Initializing strPlayer2 since the Connect Four Check method requires this string. However, this gamemode does not require this string.
							strPlayer2 = "";
							Console Board = new Console("Connect Four Board",600,600);
// Initializing the turn number.
							intTurn = -1;

// Filling array intGrid				
							Board.setDrawColor(new Color(0,150,200));
							Board.fillRect(5,50,590,500);
							Board.setDrawColor(Color.BLACK);
// Fills the intGrid array with 0s. 0s represent an empty slot.
							for(int intRow = 0; intRow < 6; intRow++){
								for(int intColumn = 0; intColumn < 7; intColumn++){
									Board.fillOval(col[intColumn],row[intRow],70,70);
									if(intGrid[intColumn][intRow] != 1 || intGrid[intColumn][intRow] != 2){
										intGrid[intColumn][intRow] = 0;
									}
								}
							}
							Board.setDrawColor(Color.RED);
							Board.drawString(strPlayer1 + "'s Turn",10,10);	
// Initializing variables	
							intCurrentColumn = 0;
							blnClickReleased = false;
// Grabbing mouse input and coordinates
							while(intBackToMenu == 1){
								intMouseClick = Board.currentMouseButton();
								intMouseX = Board.currentMouseX();

// The purpose of this code is to update the board based on the location of the mouse cursor. The column will change color depending on where the cursor is.
								for(int intUncoloredColumn = 0; intUncoloredColumn < 7; intUncoloredColumn++){
									if(intMouseX > (col[intUncoloredColumn]-9) && intMouseX < (col[intUncoloredColumn]+70)){
										if(intUncoloredColumn != intCurrentColumn){
											for(int intColoringRow = 0; intColoringRow < 6; intColoringRow++){
												if(intGrid[intCurrentColumn][intColoringRow] == 1){
													Board.setDrawColor(Color.YELLOW);
												}else if(intGrid[intCurrentColumn][intColoringRow] == 2){
													Board.setDrawColor(Color.RED);
												}else{
													Board.setDrawColor(Color.BLACK);
												}
												Board.fillOval(col[intCurrentColumn],row[intColoringRow],70,70);
												
												if(intGrid[intUncoloredColumn][intColoringRow] == 1){
													Board.setDrawColor(Color.YELLOW);
												}else if(intGrid[intUncoloredColumn][intColoringRow] == 2){
													Board.setDrawColor(Color.RED);
												}else{
													Board.setDrawColor(Color.WHITE);
												}											
												Board.fillOval(col[intUncoloredColumn],row[intColoringRow],70,70);
											}
											intCurrentColumn = intUncoloredColumn;
										}
									}
								}
								
								if(intMouseClick == 1 && blnClickReleased == true && intTurn%2 != 0){
									blnClickReleased = false;
									intTurn++;
									System.out.println("Turn: "+intTurn);
// Player1
									intCurrentRow = 5;
									if(intGrid[intCurrentColumn][0] != 0){
										intTurn = intTurn - 1;
										Console FullColumn = new Console(200,100);
										FullColumn.println("\n Column is full");
										FullColumn.sleep(500);
										FullColumn.closeWindow();

// Making the pieces fall to the lowest row of the array
									}else if(intGrid[intCurrentColumn][0] == 0){
										while(intGrid[intCurrentColumn][intCurrentRow] != 0 && intCurrentRow < 6){
											intCurrentRow--;
										}
										intGrid[intCurrentColumn][intCurrentRow] = 2;
										intConnectFour1 = ConnectFourTools.CheckingConnectFourPlayer1(Board, strPlayer1, strPlayer2, intTurn, intGrid, intCurrentColumn, intCurrentRow, intBackToMenu);
										if(intConnectFour1 == 1){
											intConnectFour1 = 0;
											Console Results = new Console("Results",600,150);
											Results.setDrawColor(Color.RED);
											Font ResultsFont = Results.loadFont("SeasideResort.ttf", 20);	
											Results.setDrawFont(ResultsFont);
											Results.drawString(strPlayer1 +" Wins",220,50);
											ConnectFourTools.Player1Wins(Board, strPlayer1);
											Results.repaint();	
											Results.sleep(1500);
											Board.closeWindow();
											Results.closeWindow();
											intBackToMenu = 0;
										}
										Board.setDrawColor(Color.RED);
										Board.fillOval(col[intCurrentColumn],row[intCurrentRow],70,70);
										Board.setDrawColor(Color.BLACK);
										Board.drawString(strPlayer1 + "'s Turn",10,10);
										Board.setDrawColor(Color.YELLOW);
										Board.drawString("Computer's Turn",10,10);
										}
// Computer's Turn
								}else if(intTurn%2 == 0){
									for(int intGridColumn = 0; intGridColumn < intGrid.length; intGridColumn++){
										for(int intGridRow = 0; intGridRow < intGrid[intGridColumn].length; intGridRow++){
											if(intGrid[intGridColumn][intGridRow] == 0){
												Board.setDrawColor(Color.BLACK);
												Board.fillOval(col[intGridColumn],row[intGridRow],70,70);
											}
										}
									}		
									Board.sleep(200);
									intTurn++;
									System.out.println("Turn: "+intTurn);
									intCurrentColumn = (int)(Math.random()*7+0);
									intCurrentRow = 5;
									while(intGrid[intCurrentColumn][0] != 0){
										intCurrentColumn = (int)(Math.random()*7+0);

// Making Pieces Fall
									}if(intGrid[intCurrentColumn][0] == 0){
										while(intGrid[intCurrentColumn][intCurrentRow] != 0 && intCurrentRow < 6){
											intCurrentRow--;
										}
										intGrid[intCurrentColumn][intCurrentRow] = 1;
										intConnectFour2 = ConnectFourTools.CheckingConnectFourPlayer2(Board, strPlayer1, strPlayer2, intTurn, intGrid, intCurrentColumn, intCurrentRow, intBackToMenu);
										if(intConnectFour2 == 1){
											intConnectFour2 = 0;
											Console Results = new Console("Results",600,150);
											Results.setDrawColor(Color.YELLOW);
											Font ResultsFont = Results.loadFont("SeasideResort.ttf", 20);	
											Results.setDrawFont(ResultsFont);
											Results.drawString("Computer Wins",220,50);
											Results.repaint();	
											Results.sleep(1500);
											Board.closeWindow();
											Results.closeWindow();
											intBackToMenu = 0;
										}
										Board.setDrawColor(Color.YELLOW);
										Board.fillOval(col[intCurrentColumn],row[intCurrentRow],70,70);
										Board.setDrawColor(Color.BLACK);
										Board.drawString("Computer's Turn",10,10);									
										Board.setDrawColor(Color.RED);
										Board.drawString(strPlayer1 + "'s Turn",10,10);
									}
								}
								if (intMouseClick == 0){
									blnClickReleased = true;
								}
// Check Full Board
								intFullBoard = 0;
								for(int intTopFullColumn = 0; intTopFullColumn < 7; intTopFullColumn++){
									if(intGrid[intTopFullColumn][0] != 0){
										intFullBoard++;
										if(intFullBoard >= 7){
											Console Results = new Console("Results",600,600);
											Results.setDrawColor(Color.WHITE);
											Font ResultsFont = Results.loadFont("SeasideResort.ttf", 20);	
											Results.setDrawFont(ResultsFont);
											Results.drawString("It's a tie",230,200);
											Results.repaint();	
											Results.sleep(1500);
											Board.closeWindow();
											Results.closeWindow();
											intBackToMenu = 0;
										}
									}
								}		
								Board.repaint();
							}
							
// Two Players
						}if(intMouseX < 240 || intMouseX > 370 || intMouseY < 300 || intMouseY > 325){
							Gamemode.setDrawColor(Color.WHITE);
							Gamemode.drawString("Two Players", 240, 300);
							Gamemode.repaint();
						}if(intMouseX > 240 && intMouseX < 370 && intMouseY > 300 && intMouseY < 325){
							Gamemode.setDrawColor(new Color(150,150,150));
							Gamemode.drawString("Two Players", 240, 300);
							Gamemode.repaint();
						}if(intMouseClick == 1 && intMouseX > 240 && intMouseX < 370 && intMouseY > 300 && intMouseY < 325){
							Gamemode.closeWindow();
							Console Username = new Console("Username",600,600);
							BufferedImage Usernamebackground = Username.loadImage("Usernamebackground.jpg");
							Username.drawImage(Usernamebackground,0,0);
							Username.println("\n\n\tPlayer 1, what is your username?");
							strPlayer1 = Username.readLine();
							ConnectFourTools.CheckingUsernamePlayer1(Username, strPlayer1);
							Username.println("      You will be using red colored pieces.");
							Username.println("\n\n--------------------------------------------------");
							Username.println("\n\n\tPlayer 2, what is your username?");
							strPlayer2 = Username.readLine();
							while(strPlayer2.equalsIgnoreCase(strPlayer1)){
								Console UsernameTaken = new Console("Sorry",200,100);
								UsernameTaken.println("\n Username Taken");
								UsernameTaken.sleep(500);
								UsernameTaken.closeWindow();
								strPlayer2 = Username.readLine();
							}if(!strPlayer2.equalsIgnoreCase(strPlayer1)){
								ConnectFourTools.CheckingUsernamePlayer2(Username, strPlayer2);	
								Username.println("    You will be using yellow colored pieces.");
								Username.sleep(1000);			
								Username.closeWindow();
							}
// Creating Board screen 							
							Console Board = new Console("Connect Four Board",600,600);
							intTurn = 0;

// Filling array intGrid				
							Board.setDrawColor(new Color(0,150,200));
							Board.fillRect(5,50,590,500);
							Board.setDrawColor(Color.BLACK);
							for(int intRow = 0; intRow < 6; intRow++){
								for(int intColumn = 0; intColumn < 7; intColumn++){
									Board.fillOval(col[intColumn],row[intRow],70,70);
									if(intGrid[intColumn][intRow] != 1 || intGrid[intColumn][intRow] != 2){
										intGrid[intColumn][intRow] = 0;
									}
								}
							}

// Drawing board
							Board.setDrawColor(Color.RED);
							Board.drawString(strPlayer1 + "'s Turn",10,10);

// Get Mouse input			
							intCurrentColumn = 0;
							blnClickReleased = false;
							while(intBackToMenu == 1){
								intMouseClick = Board.currentMouseButton();
								intMouseX = Board.currentMouseX();

//Update board based on location of cursor
								for(int intUncoloredColumn = 0; intUncoloredColumn < 7; intUncoloredColumn++){
									if(intMouseX > (col[intUncoloredColumn]-9) && intMouseX < (col[intUncoloredColumn]+70)){
										if(intUncoloredColumn != intCurrentColumn){
											for(int intColoringRow = 0; intColoringRow < 6; intColoringRow++){
										
												if(intGrid[intCurrentColumn][intColoringRow] == 1){
													Board.setDrawColor(Color.YELLOW);
												}else if(intGrid[intCurrentColumn][intColoringRow] == 2){
													Board.setDrawColor(Color.RED);
												}else{
													Board.setDrawColor(Color.BLACK);
												}
											
												Board.fillOval(col[intCurrentColumn],row[intColoringRow],70,70);
												
												if(intGrid[intUncoloredColumn][intColoringRow] == 1){
													Board.setDrawColor(Color.YELLOW);
												}else if(intGrid[intUncoloredColumn][intColoringRow] == 2){
													Board.setDrawColor(Color.RED);
												}else{
													Board.setDrawColor(Color.WHITE);
												}											
												Board.fillOval(col[intUncoloredColumn],row[intColoringRow],70,70);
											}
										intCurrentColumn = intUncoloredColumn;
										}
									}
								}
								
								if(intMouseClick == 1 && blnClickReleased == true){
									blnClickReleased = false;
									intTurn++;
									System.out.println("Turn: "+intTurn);

// Player2
									if(intTurn%2 == 0){
										intCurrentRow = 5;
										if(intGrid[intCurrentColumn][0] != 0){
											intTurn = intTurn - 1;
											Console FullColumn = new Console(200,100);
											FullColumn.println("\n Column is full");
											FullColumn.sleep(500);
											FullColumn.closeWindow();

// Making Pieces Fall
										}else if(intGrid[intCurrentColumn][0] == 0){
											while(intGrid[intCurrentColumn][intCurrentRow] != 0 && intCurrentRow < 6){
												intCurrentRow--;
											}
											intGrid[intCurrentColumn][intCurrentRow] = 1;
											intConnectFour2 = ConnectFourTools.CheckingConnectFourPlayer2(Board, strPlayer1, strPlayer2, intTurn, intGrid, intCurrentColumn, intCurrentRow, intBackToMenu);
											if(intConnectFour2 == 1){
												intConnectFour2 = 0;
												Console Results = new Console("Results",600,150);
												Results.setDrawColor(Color.YELLOW);
												Font ResultsFont = Results.loadFont("SeasideResort.ttf", 20);	
												Results.setDrawFont(ResultsFont);
												Results.drawString(strPlayer2 +" Wins",220,50);
												ConnectFourTools.Player2Wins(Board, strPlayer2);
												Results.repaint();	
												Results.sleep(1500);
												Board.closeWindow();
												Results.closeWindow();
												intBackToMenu = 0;
											}
											Board.setDrawColor(Color.YELLOW);
											Board.fillOval(col[intCurrentColumn],row[intCurrentRow],70,70);
											Board.setDrawColor(Color.BLACK);
											Board.drawString(strPlayer2 + "'s Turn",10,10);									
											Board.setDrawColor(Color.RED);
											Board.drawString(strPlayer1 + "'s Turn",10,10);
										}
										
// Player1
									}else if(intTurn%2 != 0){
										intCurrentRow = 5;
										if(intGrid[intCurrentColumn][0] != 0){
											intTurn = intTurn - 1;
											Console FullColumn = new Console(200,100);
											FullColumn.println("\n Column is full");
											FullColumn.sleep(500);
											FullColumn.closeWindow();

// Making the pieces fall to the lowest row of the array
										}else if(intGrid[intCurrentColumn][0] == 0){
											while(intGrid[intCurrentColumn][intCurrentRow] != 0 && intCurrentRow < 6){
												intCurrentRow--;
											}
											intGrid[intCurrentColumn][intCurrentRow] = 2;
											intConnectFour1 = ConnectFourTools.CheckingConnectFourPlayer1(Board, strPlayer1, strPlayer2, intTurn, intGrid, intCurrentColumn, intCurrentRow, intBackToMenu);
											if(intConnectFour1 == 1){
												intConnectFour1 = 0;
												Console Results = new Console("Results",600,150);
												Results.setDrawColor(Color.RED);
												Font ResultsFont = Results.loadFont("SeasideResort.ttf", 20);	
												Results.setDrawFont(ResultsFont);
												Results.drawString(strPlayer1 +" Wins",220,50);
												ConnectFourTools.Player1Wins(Board, strPlayer1);
												Results.repaint();	
												Results.sleep(1500);
												Board.closeWindow();
												Results.closeWindow();
												intBackToMenu = 0;
											}
											Board.setDrawColor(Color.RED);
											Board.fillOval(col[intCurrentColumn],row[intCurrentRow],70,70);
											Board.setDrawColor(Color.BLACK);
											Board.drawString(strPlayer1 + "'s Turn",10,10);
											Board.setDrawColor(Color.YELLOW);
											Board.drawString(strPlayer2 + "'s Turn",10,10);
										}
									}
								}
								if (intMouseClick == 0){
									blnClickReleased = true;
								}
// Check Full Board
								intFullBoard = 0;
								for(int intTopFullColumn = 0; intTopFullColumn < 7; intTopFullColumn++){
									if(intGrid[intTopFullColumn][0] != 0){
										intFullBoard++;
										if(intFullBoard >= 7){
											Console Results = new Console("Results",600,150);
											Results.setDrawColor(Color.WHITE);
											Font ResultsFont = Results.loadFont("SeasideResort.ttf", 20);	
											Results.setDrawFont(ResultsFont);
											Results.drawString("It's a tie",230,50);
											Results.repaint();	
											Results.sleep(1500);
											Board.closeWindow();
											Results.closeWindow();
											intBackToMenu = 0;
										}
									}
								}		
								Board.repaint();
							}
						}
					}
				}
			}
		}
	}
}
		


