package org.example.controllersGraphics;
import org.example.viewsGraphics.GSummaryQuizView;

import java.util.ArrayList;
import java.util.List;

public class GSummaryQuizController extends GController {
    private GSummaryQuizView gSummaryQuizView;
    private GQuizController gQuizController;
    private GMenuController gMenuController;

    public GSummaryQuizController(GMenuController gMenuController, GQuizController gQuizController){
        gSummaryQuizView = new GSummaryQuizView(this, jframe);
        this.gMenuController = gMenuController;
        this.gQuizController = gQuizController;
    }

    public void run(int points){
        gSummaryQuizView.ShowQuizView(points);
    }

    public void resetDataQuiz() {
        dataSet.resetDataQuiz();
    }

    public void getNewMenuView() {
        gMenuController.run();
    }

    public List<String> getSummarry() {
        List<String> lines = new ArrayList<>();
        List<String> summary = gQuizController.getSummary();
        String row = "";
        for (String element : summary) {
            if (element != "\n"){
                row = row + element;
            }
            else{
                lines.add(row);
                row = "";
            }
        }
        return lines;
    }

    public void resetSummary() {
        gQuizController.resetSummary();
    }
}
