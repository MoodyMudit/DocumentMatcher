import java.io.*;
import java.util.*;
class Vector
{
	public int[] getVectorArr(String FILENAME,HashMap<String,Integer> map) throws IOException
        {
                BufferedReader br=new BufferedReader(new FileReader(FILENAME));
                BufferedReader br2=new BufferedReader(new FileReader(FILENAME));
                WordPlay WP = new WordPlay();
                int counter=WP.wordCount(br,map);

                System.out.println(counter);
                int arr[]=new int[counter];
                createVector(br2,map,arr);

                return arr;
        }

        public void printVector(int arr[])
        {
                for(int i=0;i<arr.length;i++)
                {
                        System.out.print(arr[i]+" ");
                }
                System.out.println();
        }
	
	public void createVector(BufferedReader br, HashMap<String,Integer> map,int arr[]) throws IOException
        {
                String line;
                WordPlay WP = new WordPlay();
                while((line=br.readLine())!=null)
                {
                        String words[]=line.split(" ");
                        for(int i=0;i<words.length;i++)
                        {
                                String curWord = WP.formatWord(words[i]);
                                int pos = map.get(curWord);
                                arr[pos]++;
                        }
                }
        }

	public double matchVectors(HashMap<String,Integer> map1,int vector1[],HashMap<String,Integer> map2,int vector2[], ArrayList<String> matchings)
        {
                int total=0;int match=0;
                Iterator it = map1.entrySet().iterator();
                while (it.hasNext()) { 
                        Map.Entry pair = (Map.Entry)it.next();
                        //System.out.println(pair.getKey() + " = " + pair.getValue());
                        //it.remove(); // avoids a ConcurrentModificationException
                        String key = (String)pair.getKey();
                        UselessKeywords UK = new UselessKeywords();
                        if(UK.uselessWord(key)==true)
                                continue;

                        if(map2.get(key)!=null){
                                int count1 = vector1[(int)pair.getValue()];
                                int count2 = vector2[map2.get(key)];
                                matchings.add((String)pair.getKey());
                                //System.out.println("count1 = "+count1+" count2 = "+count2);
                                total+=count1+count2;
                                match+=2*(Math.min(count1,count2));
                                //System.out.println("total = "+total+" match = "+match);
                        }
                        else
                        {
                                total+=vector1[(int)pair.getValue()];
                                //System.out.println("total = "+total+" match = "+match);
                        }
                }

                //System.out.println("second file begins");
                Iterator it2 = map2.entrySet().iterator();
                while (it2.hasNext()) {
                        Map.Entry pair = (Map.Entry)it2.next();
                        //System.out.println(pair.getKey() + " = " + pair.getValue());
                        String key = (String)pair.getKey();     
                        UselessKeywords UK = new UselessKeywords();
                        if(UK.uselessWord(key)==true)
                                continue;
                        if(map1.get(key)==null)
                        {
                                total+=vector2[(int)pair.getValue()];
                                //System.out.println("total = "+total+" match = "+match);
                        }
                }
                System.out.println("grand total = "+total);
                System.out.println("grand match = "+match);
                double score = ((double)match/total)*100;
                return score;
        }
}
