package sk.kosickaakademia.nebus.homework;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    Main.openSourceAndReadAndRepairIntoNewFile();
    }


    public static void openSourceAndReadAndRepairIntoNewFile(){
        try {
            FileReader fr = new FileReader("resource/git.txt");

            File file = new File("output/repair.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);

            int i;
            while((i=fr.read())!=-1){
                if(i == '?'){
                    continue;
                }
                if(i == 'y'){
                    i = 'i';
                }else if(i == 'i'){
                    i = 'y';
                }
                fw.write(i);
            }
            fw.close();
            fr.close();

        }catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}
