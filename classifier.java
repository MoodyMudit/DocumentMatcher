import java.io.*;
import java.util.*;
import java.math.*;

class classifier
{
	public static void main(String args[]) throws IOException
	{
		ArrayList<String> matchings = new ArrayList<String>();
		Vector vector = new Vector();

		String FILENAME1 = "./test1.txt";
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		int vector1[] = vector.getVectorArr(FILENAME1,map1);
                //vector.printVector(vector1);
	
		String FILENAME2 = "./test2.txt";
		HashMap<String,Integer> map2 = new HashMap<String,Integer>();
		int vector2[] = vector.getVectorArr(FILENAME2,map2);
		//vector.printVector(vector2);

		double score = vector.matchVectors(map1,vector1,map2,vector2,matchings);
		System.out.println(score+"%");
		System.out.println(matchings);
	}
}
