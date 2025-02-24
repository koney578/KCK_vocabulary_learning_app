package org.example.controllers;

import org.example.views.SummaryQuizView;

import java.io.IOException;

public class SummaryQuizController extends Controller {
    private SummaryQuizView summaryQuizView;
    private QuizController quizController;
    private MenuController menuController;

    public SummaryQuizController(MenuController menuController, QuizController quizController){
        summaryQuizView = new SummaryQuizView(this, Gui);
        this.menuController = menuController;
        this.quizController = quizController;
    }

    public void run(int points){
        summaryQuizView.ShowQuizView(points);
    }

    public void resetDataQuiz() {
        dataSet.resetDataQuiz();
    }

    public void getNewMenuView() throws IOException {
        menuController.run();
    }

    public String getSummarry() {
        return quizController.getSummary();
    }

    public void resetSummary() {
        quizController.resetSummary();
    }
}
