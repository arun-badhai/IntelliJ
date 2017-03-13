import java.io.*;
import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class PrintOutput {
    static HashMap sorted = CreateGraph.sortMap();
    static HashMap finalEdges;

    // Writes the output to a file
    public static void main (String[] args) throws java.lang.Exception {
        finalEdges = Prims.MST(sorted);
        StringBuilder sbfinal = new StringBuilder();
        Set set = finalEdges.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            StringBuilder sb = new StringBuilder();
            Map.Entry mapVal = (Map.Entry)iterator.next();
            List list = (List) mapVal.getKey();
            sb.append("Edge in MST: (" +list.get(0)+",");
            sb.append(list.get(1)+"), Weight: ");
            sb.append(mapVal.getValue());
            sbfinal.append(sb.toString());
            sbfinal.append("\n");
        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("Output.txt"));
            out.write(sbfinal.toString());
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception ");

        }

        System.out.println("Output file created!!");
    }
}
