import java.io.*;
import java.util.*;

/**
 * Created by Shivani Shinde on 13-03-2017.
 */
public class KruskalsOutput {
    static HashMap finalEdges;

    // Writes the output to a file
    public static void main (String[] args) throws java.lang.Exception {
        finalEdges = Kruskals.MST();
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
            BufferedWriter out = new BufferedWriter(new FileWriter("KruskalsOutput.txt"));
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
