package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.*;

/**
 * Created by Shivani Shinde on 18-03-2017.
 */

public class Controller {
    @FXML
    LineChart linechart;
    static HashMap finalEdges = Main.finalEdges;

    @FXML
    public void btn(ActionEvent event){
        HashMap<Integer,Integer> ref = GraphRef.setNodeValues();
        linechart.getData().clear();
        Set set = finalEdges.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapVal = (Map.Entry) iterator.next();
            List<Integer> temp = (List) mapVal.getKey();
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(String.valueOf(temp.get(0)), ref.get(temp.get(0))));
            series.getData().add(new XYChart.Data(String.valueOf(temp.get(1)), ref.get(temp.get(1))));
            linechart.getData().add(series);
        }
    }
}
