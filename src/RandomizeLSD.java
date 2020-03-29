/**
*Reads in LS file, shuffles Data and outputs in a new order
*Author: @ThaddeusOwl, 03-2020
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RandomizeLSD{

	public static void main(String [] args) throws FileNotFoundException{
		List<String> lines= new ArrayList<String>(2976);
		Scanner file = new Scanner(new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
		while(file.hasNextLine()){
			String line = file.nextLine();
			lines.add(line);}

		Collections.shuffle(lines);
		for(String s:lines){
         System.out.println(s);
      }
		
	}


}
