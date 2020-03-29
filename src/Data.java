/**
*Data.java - Reason: to create single objects that contain the different parameters.
*@ThaddeusOwl, 01-03-2020
*/


public class Data implements Comparable<Data>{

private String details;
private String areas;
/**sets details and areas */
public Data(String a, String b){
	details=a;
	areas=b;
}
/**simply sets details */
public Data(String a){
   details=a;
}
/**returns details */
public String getDetails(){
	return details;
}
/**returns areas */
public String getAreas(){
	return areas;
}

public int compareTo(Data other){
   if(this.getDetails().compareTo(other.getDetails())>0){
      return 1;}
   if(this.getDetails().compareTo(other.getDetails())<0){
      return -1;}
   else{
      return 0;}
}

public String toString(){
   return (details+" "+areas);
}

}
