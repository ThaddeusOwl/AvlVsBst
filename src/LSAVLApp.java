import java.io.FileNotFoundException;

public class LSAVLApp{

	public static void main(String [] args) throws FileNotFoundException{
		Tree2 tree2;
		if(args.length == 1){
			tree2 = new Tree2();
         System.out.println(tree2.search(args[0]));
         System.out.println("Insert Operation Count: " + tree2.getInsertOpCount());
         System.out.println("Search Operation Count: " + tree2.getSearchOpCount());}
      else if(args.length == 3){ //java LSArrayApp "1_2_3" "200" "diffFile.txt"
         tree2 = new Tree2(Integer.parseInt(args[1]),args[2]);
         tree2.search(args[0]);
         System.out.println(tree2.getInsertOpCount()+","+tree2.getSearchOpCount());
      }else{
			tree2 = new Tree2();
         System.out.println(tree2);
      System.out.println("Insert Operation Count: " + tree2.getInsertOpCount());
      System.out.println("Search Operation Count: " + tree2.getSearchOpCount());}
	}
}
