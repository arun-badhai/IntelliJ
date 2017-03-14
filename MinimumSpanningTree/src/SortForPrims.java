import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class SortForPrims {
    static List<String> read = ReadInput.getLines();
    static HashMap HMAp = new HashMap();
    static List<List<Integer>> edgesTemp = new ArrayList<>();

    public static void trim(String line){
        List<Integer> list = new ArrayList();
        int i = 0;
        String start = "";
        while(Character.isDigit(line.charAt(i))){
            start = start + line.charAt(i);
            i++;
        }
        int begin = Integer.parseInt(start);
        while(i<line.length()) {
            String digits= "";
            while(Character.isDigit(line.charAt(i))) {
                digits = digits + line.charAt(i);
                i++;
            }
            if(digits != ""){
                list.add(Integer.parseInt(digits));
            }
            i++;
        }
        List innerList = new ArrayList();
        for(int j=0;j<list.size();j=j+2){
            int end = list.get(j);
            int weight = list.get(j+1);
            List<Integer> edge = new ArrayList<>(); // To check if edge exists
            List<Integer> innermostList = new ArrayList<>();
            edge.add(begin);
            edge.add(end);
            if(!edgesTemp.contains(edge)){
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
        /*sortForPrims();
        Set set = HMAp.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mapVal = (Map.Entry)iterator.next();
            System.out.println("Key "+mapVal.getKey()+"    Value  "+mapVal.getValue());
        }*/
    }
}
