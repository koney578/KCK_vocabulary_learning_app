package org.example.models;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class DownloadData {
    Map<String, String> data = new HashMap<>();
    Map<String, String> dataNotFamiliarized = new HashMap<>();
    Map<String, String> dataQuiz = new HashMap<>();
    String nameFile = "src/main/java/org/example/data/words.txt";
    String nameFile2 = "src/main/java/org/example/data/dataNotFamiliarized.txt";

//    String nameFile = "words.txt";
//    String nameFile2 = "dataNotFamiliarized.txt";
    public DownloadData(){
        try {
            File file = new File(nameFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                if (values.length == 2) {
                    String klucz = values[0];
                    String wartosc = values[1];
                    data.put(klucz,wartosc);
                    dataQuiz.put(klucz, wartosc);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku: " + nameFile);
        }

        try {
            File file = new File(nameFile2);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                if (values.length == 2) {
                    String klucz = values[0];
                    String wartosc = values[1];
                    dataNotFamiliarized.put(klucz,wartosc);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku: " + nameFile2);
        }
    }
    public void addWord(String key, String value) {
        data.put(key,value);
        dataNotFamiliarized.put(key, value);
        dataQuiz.put(key, value);
    }
    public String drawLotsKeyNotFamiliarized() {
        Random random = new Random();
        int size = dataNotFamiliarized.size();
        int drawn = random.nextInt(size);
        String[] keys = dataNotFamiliarized.keySet().toArray(new String[0]);
        String wylosowanyKlucz = keys[drawn];
        return wylosowanyKlucz;
    }
    public void removeField(String key){
        dataNotFamiliarized.remove(key);
    }

    public String howManyFamiliarized(){
        String counter = String.valueOf(data.size() - dataNotFamiliarized.size());
        return counter;
    }
    public String getValue(String key){
        return data.get(key);
    }

    public String getSizeData() {
        String number = String.valueOf(data.size());
        return number;
    }
    public int getSizeDataNotFamiliarized(){
        return dataNotFamiliarized.size();
    }

    public void resetData(){
        if (dataNotFamiliarized.size() != 0){
            dataNotFamiliarized.clear();
            dataNotFamiliarized.putAll(data);
        }
        else {
            dataNotFamiliarized.putAll(data);
        }
    }

    public Boolean checkAnswer(String drawnKey, String value) {
        if(data.get(drawnKey).equalsIgnoreCase(value)) {
            return true;
        }
        else{
            return false;
        }
    }

    public String getDrawnKeyNotFamiliarizedQuiz() {
        Random random = new Random();
        int size = dataQuiz.size();
        int drawn = random.nextInt(size);
        String[] keys = dataQuiz.keySet().toArray(new String[0]);
        String wylosowanyKlucz = keys[drawn];
        return wylosowanyKlucz;
    }

    public void removeFieldQuiz(String key){
        dataQuiz.remove(key);
    }

    public void resetDataQuiz(){
        if (dataQuiz.size() != 0){
            dataQuiz.clear();
            dataQuiz.putAll(data);
        }
        else {
            dataQuiz.putAll(data);
        }
    }

    public void removeWord(String key) {
        data.remove(key);
        dataQuiz.remove(key);
        dataNotFamiliarized.remove(key);
    }

    public void saveData() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (String key : data.keySet()) {
                stringBuilder.append(key).append(";").append(data.get(key)).append("\n");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/org/example/data/words.txt"));
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (String key : dataNotFamiliarized.keySet()) {
                stringBuilder.append(key).append(";").append(dataNotFamiliarized.get(key)).append("\n");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/org/example/data/dataNotFamiliarized.txt"));
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
