import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class SortForPrims {
    static List<String> read = ReadInput.getLines();
    static HashMap HMAp = new HashMap();
    static List<List<Integer>> edgesTemp = new ArrayList<>();

    public static void trim(String line){
        String value = line.replaceAll("[^0-9]","");
        int start = Character.getNumericValue(line.charAt(0));
        List innerList = new ArrayList();
        for(int i=1;i<value.length();i=i+2){
            int end = Character.getNumericValue(value.charAt(i));
            int weight = Character.getNumericValue(value.charAt(i+1));
            List<Integer> edge = new ArrayList<>(); // To check if edge exists
            List<Integer> edgereverse = new ArrayList<>(); // To check if edge exists (reverse order)
            List<Integer> innermostList = new ArrayList<>();
            edge.add(start);
            edge.add(end);
            edgereverse.add(end); edgereverse.add(start);
            if(!edgesTemp.contains(edge) && !edgesTemp.contains(edgereverse)){
                edgesTemp.add(edge);
                innermostList.add(end);
                innermostList.add(weight);
                innerList.add(innermostList);
            }
        }
        Collections.sort(innerList, new Comparator<List<Integer>>()
        {
            public int compare(List<Integer> o1, List<Integer> o2)
            {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        HMAp.put(start, innerList);
    }

    public static HashMap sortForPrims(){
        for (int i=0;i<read.size();i++){
            trim(read.get(i));
        }
        return HMAp;
    }

    public static void main (String[] args) throws java.lang.Exception {
        sortForPrims();
        Set set = HMAp.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mapVal = (Map.Entry)iterator.next();
            System.out.println("Key "+mapVal.getKey()+"    Value  "+mapVal.getValue());
        }
    }
}
