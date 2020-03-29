/**
*LSBSTApp.java - Provides load shedding data
*' java LSBSTApp ': prints all load shedding details to standard output
*' java LSBSTApp "2_13_04" ': prints details for Stage 2, 13th of the month, starting time of 04:00
*' java LSBSTApp searchDetails datasetLength fileName ': same as above but changes default dataset length and input file 
*Author: @ThaddeusOwl, 01-03-2020
*/

import java.io.FileNotFoundException;

public class LSBSTApp{

	public static void main(String [] args) throws FileNotFoundException{
		Tree tree;
      if(args.length == 1){
			tree=new Tree();
         System.out.println(tree.search(args[0]));
         System.out.println("Insert Operation Count: " + tree.getInsertOpCount());
         System.out.println("Search Operation Count: " + tree.getSearchOpCount());
      }else if(args.length == 3){ //java LSBSTApp "1_2_3 200 diffFile.txt"
         tree=new Tree(Integer.parseInt(args[1]), args[2]);
         tree.search(args[0]);
         System.out.print(args[1]+","+tree.getInsertOpCount()+","+tree.getSearchOpCount()+",");
		}else{
			tree = new Tree();
         tree.allAreas();
         System.out.println("Insert Operation Count: " + tree.getInsertOpCount());
         System.out.println("Search Operation Count: " + tree.getSearchOpCount());
		}
      
	}


}
