package sudoku;
import java.io.*;

public class serializeBoard {
    private String fileloc = "gameBoard.ser";
    
    public serializeBoard(){
    }
    
    public serializeBoard(String location){
        fileloc = location;
    }
    
    public boolean save(gameBoard g){
        if(g != null){
          try{
              FileOutputStream fos = new FileOutputStream(fileloc);
              try (ObjectOutputStream out = new ObjectOutputStream(fos)) {
                  out.writeObject(g);
              }
              System.out.println("Datele serializate sunt salvate in " + fileloc);
          }catch (IOException i) {
            i.printStackTrace();
            return false;
          }   
        }else{
            System.out.println("Nu am resit salvarea jocului! Nu exista tablou de joc prezent.");
            return false;
        }
        return true;
    }
    
    public gameBoard load(){
    	gameBoard gb = null;
    	try {
    		FileInputStream fileIn = new FileInputStream(fileloc);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			gb = (gameBoard) in.readObject();
			in.close();
			fileIn.close();
    	} catch (IOException i) {
    		i.printStackTrace();
    		return gb;
    	} catch (ClassNotFoundException c) {
    		System.out.println("Clasa GameBoard nu a fost gasita");
    		c.printStackTrace();
    		return gb;
    	}
    	return gb;
    }
}