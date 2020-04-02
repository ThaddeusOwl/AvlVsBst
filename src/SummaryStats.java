import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SummaryStats{

   String fileName = "DataSet10";
   String rowsString = "10";
   int rows = Integer.parseInt(rowsString); //temp variable
      
   
   public String[][] toRawArray(String fileName, int rows){
      String[][] toReturn = new String[5][rows];
      Scanner file = new Scanner(new File(fileName));
      file.nextLine();
      file.nextLine();
      for(int j=0; j<rows; j++){ //each row
         String line = file.nextLine();
         String[] lineSplit = line.split(",")
         for (int i=0; i<5; i++){
            rawData[i][j] = lineSplit[i]; //fill columns, hold row constant
         }   
      } 
      return toReturn;   
   }
   
   public String[][] toSummaryArray(String[][] rawData){
      String[][] toReturn = new String[5][3];
      for(int i=0; i<5; i++){
         int min=10000;
         int max=0;
         int avg=0;
         for(int j=0; j<rawData[i][].length; j++){
            min = Math.min(min, Integer.parseInt(rawData[i][j]));
            max = Math.max(max, Integer.parseInt(rawData[i][j]));
            avg = avg + Integer.parseInt(rawData[i][j]);
         }
         avg = avg/rawData[i][].size;
         toReturn[i][]={String.valueOf(min), String.valueOf(max), String.valueOf(avg)};
      }
      return toReturn; 
   }
   
   public static void main(String[] args){
      int[] dataset=new int[]{10, 297, 593, 947, 1243, 1647, 1943, 2227, 2543, 2976};
      for(int n=0; n<dataset.length; n++){
         String fileName = ("DataSet"+dataset[n])
         String[][] summaryData = SummaryData.toSummaryArray(toRawArray(fileName, dataset[n]));
         for(int j=0; j<n; j++){
            for(int i=0; i<5; i++){
               System.out.print(summaryData[i][j]+",");
            }
            System.out.print("\n")
         }
      }
   }

}