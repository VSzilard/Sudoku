package sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
	 static Scanner console = new Scanner(System.in);
	    
	 public static void main(String[] args) {
		 String selection;
		 
		 gameBoard gb = new gameBoard();
		 gb.generateBoard();   
	    
		 do {
	        displayBoard(gb.getGameBoard(),gb.getAnswerBoard());
	        System.out.println("Scrieti <enter> pentru a adauga la bord.");
	        System.out.println("Scrieti <check> pentru a verifica raspunsul. " + gb.getChecks() + " verificari ramase.");
	        System.out.println("Scrieti <save> pentru a-ti salva progresul.");
	        System.out.println("Scrieti <load> pentru a incarca un joc salvat.");
	        System.out.println("Scrieti <end> pentru a incheia jocul.");
	        selection = console.next();
	
	        switch (selection) {
            	case "enter":
	                int row;
	                int column;
	                int ans;	
	
	                System.out.println("Introduceti Randul:");
	                row = console.nextInt();
	                row--;
	                System.out.println("Introduceti Coloana: ");
	                column = console.nextInt();
	                column--;
	                System.out.println("Introduceti raspunsul: ");
	                ans = console.next().charAt(0);
	                gb.answer(row, column, ans);
	                break;
	            case "check":
	                if(!gb.checkNumbers()){
	                     System.out.println("Joc finalizat!");
	                    break;
	                }
	            case "end":
	                break;
	            case "save":
	                serializeBoard save = new serializeBoard();
	                if(save.save(gb)){
	                    System.out.println("Joc salvat!");
	                }
	                break;
	            case "load":
	                serializeBoard load = new serializeBoard();
	                gameBoard loadedGB = load.load();
	                if(loadedGB != null){
	                    gb = loadedGB;
	                    System.out.println("Joc incarcat!");
	                }
	                break;
	            default:
	                break;
	        }
		 } while (!"end".equals(selection));
	 }
	
	 static void displayBoard(char[][] gameBoard, char[][] answerBoard)
	 {
	    System.out.println();
	    int rowFormat = 0;  
	    System.out.println ("|-----------------------------|");
	    System.out.print("|");   
	    for(int row = 0; row <9;row++) 
	    {
	    	if(row==3||row==6||row==9) 
	    	{
	    		System.out.println ("|-----------------------------|");     
	        }
	   
            for(int col = 0; col <9; col++)
            {
                if(rowFormat == 3)
                {
                	rowFormat = 1;
                	System.out.print("|");
                	System.out.print(String.format("%2s",gameBoard[row][col]) + " ");  
	            } 
	            else
	            { 
	            	System.out.print(String.format("%2s",gameBoard[row][col]) + " ");
	            	rowFormat++;
	            }
	        }
            System.out.println("|");
	    }
	    System.out.println (" -----------------------------");  
	}
}
