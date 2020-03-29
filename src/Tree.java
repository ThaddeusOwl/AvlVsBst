/**
*LSArray.java - Reads in Load Shedding Data from file to a binary search tree
*Provides method to search through it
*@ThaddeusOwl, 01-03-2020
*Use Tree(int,string) if you want to change the dataset length or input file
*else use Tree() for default settings
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tree{

	BinarySearchTree<Data> bst;
   String fileName="Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
   int n=2976;
   /**reads in default file with default dataset lenth into bst */
   public Tree() throws FileNotFoundException{
		bst = new BinarySearchTree<Data>();
		Scanner file=new Scanner(new File(fileName));
		for(int i=0; i<n; i++){
			String line = file.nextLine();
			String[] lineSplit = line.split(" ", 2);
         bst.insert(new Data(lineSplit[0],lineSplit[1]));
		}
   }
   /**reads in specified dataset length of specified file into bst */
   public Tree(int a, String b) throws FileNotFoundException{
		this.n=a;
      if(b.equals("default")){
      }else{this.fileName=b;}
      bst = new BinarySearchTree<Data>();
		Scanner file=new Scanner(new File(fileName));
		for(int i=0; i<n; i++){
			String line = file.nextLine();
			String[] lineSplit = line.split(" ", 2);
         bst.insert(new Data(lineSplit[0],lineSplit[1]));
		}
   }
   /**Searches for the given parameter's match in the tree and outputs the corresponding area*/   
   public String search(String details){
      Data a = new Data(details);
      BinaryTreeNode<Data> b = bst.find(a);
      if(b!=null){
         return b.data.getAreas();
      }else{return "Areas not found";}
   }
   /**prints all details/parameters with their corresponding areas */
   public void allAreas(){
      bst.inOrder();
   }
   /**Returns number of operations counted when inserting */
   public int getInsertOpCount(){
      return bst.insertOpCount;   
   }
   /** Returns operations counted when searching*/
   public int getSearchOpCount(){
      return bst.searchOpCount;
   }
  
}
