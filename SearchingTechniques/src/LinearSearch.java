import java.util.ArrayList;
import java.util.IntSummaryStatistics;

/**
 * Created by Shivani Shinde on 10-03-2017.
 */
public class LinearSearch {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static boolean search(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                return true;
            }
        }
        return false;
    }
    public static boolean delete(int key) {
        for(int i=0;i<list.size();i++){
            if(list.get(i) == key){
                list.remove(i);
                return true;
            }
        }
        return false;
    }
    public static void insert(int key){
        list.add(key);
    }
    public static void main (String[] args) throws java.lang.Exception {
        LinearSearch ls = new LinearSearch();
        ls.insert(4); ls.insert(7); ls.insert(16);
        ls.insert(43); ls.insert(14); ls.insert(17);
        ls.insert(6); ls.insert(12); ls.insert(3);
        ls.insert(7); ls.insert(1); ls.insert(4);

        if(ls.search(7) == true){
            System.out.println("Found");
        }
        else{
            System.out.println("Not found");
        }

        if(ls.delete(12) == true){
            System.out.println("Removed");
        }
        else{
            System.out.println("Not found");
        }

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+ " ");
        }
    }
}
