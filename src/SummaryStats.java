/** SummaryStats.java: Summarises data in DataSet CSV files produced by LSTest
*Ouput: CSV format
*@author ThaddeusOwl, 02-04-2020
*/



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SummaryStats{

   /**Reads into a 2D array a specified number of rows(parameter 2) of specified file(parameter 1)*/
   public String[][] toRawArray(String fileName, int rows) throws FileNotFoundException{
      String[][] toReturn = new String[5][rows];
      Scanner file = new Scanner(new File(fileName+".csv"));
      file.nextLine();
      file.nextLine();
      for(int j=0; j<rows; j++){ //each row
         String line = file.nextLine();
         String[] lineSplit = line.split(",");
         for (int i=0; i<5; i++){
            toReturn[i][j] = lineSplit[i]; //fill columns, hold row constant
         }   
      } 
      return toReturn;   
   }
   /**Summarizes a 5 column Array by finding the min, max and avg of each column. Output: 3x5 Array*/
   public String[][] toSummaryArray(String[][] rawData){
      String[][] toReturn = new String[5][3];
      for(int i=0; i<5; i++){
         int min=100000;
         int max=0;
         int avg=0;
         for(int j=0; j<rawData[i].length; j++){
            min = Math.min(min, Integer.parseInt(rawData[i][j]));
            max = Math.max(max, Integer.parseInt(rawData[i][j]));
            avg = avg + Integer.parseInt(rawData[i][j]);
         }
         avg = avg/rawData[i].length;
         toReturn[i][0] = String.valueOf(min);
         toReturn[i][1] = String.valueOf(max);
         toReturn[i][2] = String.valueOf(avg);
      }
      return toReturn; 
   }
   
   /**The rumMethod: Uses the toRawArray and toSummaryArray method repeatedly for each DataSet csv file */
   public void runMethod() throws FileNotFoundException{
      int[] dataset=new int[]{10, 297, 593, 947, 1243, 1647, 1943, 2227, 2543, 2976};
      for(int n=0; n<dataset.length; n++){
         String fileName = ("DataSet"+dataset[n]);
         String[][] summaryData = toSummaryArray(toRawArray(fileName, dataset[n]));
         for(int j=0; j<3; j++){
            for(int i=0; i<5; i++){
               System.out.print(summaryData[i][j]+",");
            }
            System.out.print("\n");
         }
      }
   }

}