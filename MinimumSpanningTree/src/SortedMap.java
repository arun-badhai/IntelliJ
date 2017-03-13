import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class SortedMap {

    // Sorts the edges by weights
    public static HashMap sort(HashMap edgesWithWeights) {
        List sortedList = new ArrayList(edgesWithWeights.entrySet());
        Collections.sort(sortedList, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        HashMap sortedMap = new LinkedHashMap();
        Iterator iterator = sortedList.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            sortedMap.put(mapEntry.getKey(), mapEntry.getValue());
        }
        return sortedMap;
    }
    public static void main (String[] args) throws java.lang.Exception {
    }
}
