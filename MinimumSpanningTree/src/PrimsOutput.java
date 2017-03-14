import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Shivani Shinde on 14-03-2017.
 */
public class PrimsOutput {
    static HashMap finalMap;

    public static void main(String[] args) throws java.lang.Exception {
        finalMap = Prims.MST();
        StringBuilder sbfinal = new StringBuilder();
        Set set = finalMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            StringBuilder sb = new StringBuilder();
            Map.Entry mapVal = (Map.Entry) iterator.next();
            sb.append("Edge in MST: " + mapVal.getKey() + " with weight: "+mapVal.getValue());
            sbfinal.append(sb.toString());
            sbfinal.append("\n");
        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("PrimsOutput.txt"));
            out.write(sbfinal.toString());
            out.close();
        } catch (IOException e) {
            System.out.println("Exception ");

        }

        System.out.println("Output file created!!");
    }
}