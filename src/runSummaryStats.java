/** 
*runSummaryStats.java: Executes the runMethod in SummaryStats
*java runSummaryStats: produces the min, max and avg of each column for 10 dataset files of different lengths, in csv format
*Author: @ThaddeusOwl, 02-04-2020
*/


import java.io.FileNotFoundException;

public class runSummaryStats{

public static void main(String[] args) throws FileNotFoundException{

  SummaryStats s = new SummaryStats();
  s.runMethod();

}

}