package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    public static HashMap finalEdges;
    static int total;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Kruskals Graph");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        finalEdges = Kruskals.MST();
        System.out.println("MST has been found!!");
        StringBuilder sbfinal = new StringBuilder();
        Set set = finalEdges.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            StringBuilder sb = new StringBuilder();
            Map.Entry mapVal = (Map.Entry)iterator.next();
            total = total + (Integer) mapVal.getValue();
            List list = (List) mapVal.getKey();
            sb.append("Edge in MST: [" +list.get(0)+", ");
            sb.append(list.get(1)+"] with weight: ");
            sb.append(mapVal.getValue());
            sbfinal.append(sb.toString());
            sbfinal.append("\n");
        }
        sbfinal.append("Total weight of the MST is: "+total);
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
        System.out.println("Graph has been created!!");
        launch(args);
    }
}
