package org.example.controllersGraphics;
import org.example.viewsGraphics.GQuizView;

import java.util.ArrayList;
import java.util.List;

public class GQuizController extends GController{
    private GQuizView gQuizView;
    private GMenuController gMenuController;
    private GSummaryQuizController gSummaryQuizController;
    private int points = 0;
    private int question = 0;
    private int quizPoints;
    private List<String> summary = new ArrayList<>();

    public GQuizController(GMenuController gMenuController){
        gQuizView = new GQuizView(this, jframe);
        this.gMenuController = gMenuController;
        this.gSummaryQuizController = new GSummaryQuizController(gMenuController, this);
    }
    public void run(){
        gQuizView.ShowQuiz();
    }

    public void checkAnswer(String drawnKey, String value) {
        int dlugosc = drawnKey.length();
        int space = 0;
        while (dlugosc<27){
            dlugosc += 1;
            space +=1;
        }
        String spaces = "";
        for(int i = 0; i<space;i++){
            spaces = spaces + " ";
        }
        summary.add(drawnKey + spaces);

        dlugosc = dataSet.getValue(drawnKey).length();
        space = 0;
        while (dlugosc<30){
            dlugosc += 1;
            space +=1;
        }
        spaces = "";
        for(int i = 0; i<space;i++){
            spaces = spaces + " ";
        }
        summary.add(dataSet.getValue(drawnKey) + spaces);

        summary.add(value);
        summary.add("\n");

        Boolean result = dataSet.checkAnswer(drawnKey, value);
        question = question + 1;
        if (result == true){
            points = points + 1;
        }
        if (question == 5){
            quizPoints = points;
            dataSet.resetDataQuiz();
            points = 0;
            question = 0;
            gSummaryQuizController.run(quizPoints);

        }
        else{
            run();
        }
    }
    public void removeField(String drawnKey) {
        dataSet.removeFieldQuiz(drawnKey);
    }

    public String getDrawnKeyNotFamiliarizedQuiz() {
        return dataSet.getDrawnKeyNotFamiliarizedQuiz();
    }

    public List<String> getSummary() {
//        String string = "";
//        for (String element: summary){
//            string = string + element;
//        }
//        return string;
        return summary;
    }

    public void resetSummary() {
        summary = new ArrayList<>();
    }
}
