/**
*LSTest.java - Executes bst and array data structure apps multiple times with with multiple dat lengths
*Outputs info in csv format 
*' java LSTest ': prints "Dataset length,BSTInsertOpCount,BSTSearchOpCount,ArrayInsertOpCount,ArraySearchOpCount"
*Author: @ThaddeusOwl, 03-2020
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LSTest{

public static void main(String [] args) throws FileNotFoundException{

	String[] parameters;
	String[] lines = new String[2976];
   int[] dataset=new int[]{10, 297, 593, 947, 1243, 1647, 1943, 2227, 2543, 2976};
	
   Scanner file=new Scanner(new File("randomizedLSD.txt"));	
      for(int i=0; i<2976; i++){
			String line = file.nextLine();
			String[] lineSplit = line.split(" ", 2);
			lines[i]=lineSplit[0];
      }
   
   System.out.println("Dataset length,BSTInsertOpCount,BSTSearchOpCount,AVLInsertOpCount,AVLSearchOpCount"+"\n");
	
   if(args.length==1){
      for (int j=0; j<Integer.parseInt(args[0]); j++){
         String[] inputParam = new String[]{lines[j], args[0], "randomizedLSD.txt"};
         LSBSTApp.main(inputParam);
         LSAVLApp.main(inputParam);
         //String runFile;
         //runFile = (runFile + LSBSTApp.main(inputParam) + LSAVLApp.main(inputParam));
         //System.out.println(runFile); 
      }
   }else{
   for(int i=0; i<dataset.length; i++){
      for(int j=0; j<dataset[i]; j++){
         String[] inputParam= new String[]{lines[j],String.valueOf(dataset[i]),"randomizedLSD.txt"};
         
         LSBSTApp.main(inputParam);
         LSAVLApp.main(inputParam);
		}
	}
   }


}


}
