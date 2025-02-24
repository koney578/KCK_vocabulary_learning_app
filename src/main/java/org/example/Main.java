package org.example;
import org.example.models.MyThreadGrafic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyThreadGrafic myThreadGrafic = MyThreadGrafic.getInstance();
        myThreadGrafic.start();
    }
}