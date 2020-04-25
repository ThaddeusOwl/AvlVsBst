/**
*Tree2.java - Reads in Load Shedding Data from file to an AVL tree
*Provides method to search through it
*@ThaddeusOwl, 29-03-2020
*Use Tree(int,string) if you want to change the dataset length or input file
*else use Tree() for default settings
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tree2{

   AVLTree<Data> avlTree;
   String fileName="Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
   int n=2976;
   /**reads in default file with default dataset lenth into avlTree */
   public Tree2() throws FileNotFoundException{
		avlTree = new AVLTree<Data>();
		Scanner file=new Scanner(new File(fileName));
		for(int i=0; i<n; i++){
			String line = file.nextLine();
			String[] lineSplit = line.split(" ", 2);
         avlTree.insert(new Data(lineSplit[0],lineSplit[1]));
		}
   }
   /**reads in specified dataset length of specified file into avl */
   public Tree2(int a, String b) throws FileNotFoundException{
		this.n=a;
      if(b.equals("default")){
      }else{this.fileName=b;}
      avlTree = new AVLTree<Data>();
		Scanner file=new Scanner(new File(fileName));
		for(int i=0; i<n; i++){
			String line = file.nextLine();
			String[] lineSplit = line.split(" ", 2);
         avlTree.insert(new Data(lineSplit[0],lineSplit[1]));
		}
   }
   /**Searches for the given parameter's match in the tree and outputs the corresponding area*/   
   public String search(String details){
      Data a = new Data(details);
      BinaryTreeNode<Data> b = avlTree.find(a);
      if(b!=null){
         return b.data.getAreas();
      }else{return "Areas not found";}
   }
   /**prints all details/parameters with their corresponding areas */
   public void allAreas(){
      avlTree.inOrder();
   }
   /**Returns number of operations counted when inserting */
   public int getInsertOpCount(){
      return avlTree.insertOpCount;   
   }
   /** Returns operations counted when searching*/
   public int getSearchOpCount(){
      return avlTree.searchOpCount;
   }


}