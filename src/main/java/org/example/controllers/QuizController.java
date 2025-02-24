package org.example.controllers;
import org.example.views.QuizView;

import java.util.ArrayList;
import java.util.List;

public class QuizController extends Controller{
    private QuizView quizView;
    private MenuController menuController;
    private SummaryQuizController summaryQuizController;
    private int points = 0;
    private int question = 0;
    private int quizPoints;
    private List<String> summary = new ArrayList<>();

    public QuizController(MenuController menuController){
        quizView = new QuizView(this, Gui);
        this.menuController = menuController;
        this.summaryQuizController = new SummaryQuizController(menuController, this);
    }
    public void run(){
        quizView.ShowQuiz();
    }

    public void checkAnswer(String drawnKey, String value) {
        int dlugosc = drawnKey.length();
        int space = 0;
        while (dlugosc<18){
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
        while (dlugosc<27){
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
            summaryQuizController.run(quizPoints);

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

    public String getSummary() {
        String string = "";
        for (String element: summary){
            string = string + element;
        }
        return string;
    }

    public void resetSummary() {
        summary = new ArrayList<>();
    }
}
