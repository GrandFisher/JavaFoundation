package grammer;


import java.io.*;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2019-03-25 22:10.
 */

public class ReadFiles {


    public static void main(String[] args) {
        ReadFiles readFiles=new ReadFiles();
        readFiles.read();
    }

    public void read() {
        Scanner sysin = new Scanner(System.in);

//            FileReader reader=new FileReader("src/main/java/grammer/readfile.txt");
        BufferedReader rd = openFileReader(sysin, "Input fileName: ");
        PrintWriter wr = openFileWriter();
//        showFileCharByChar(rd);
//        showFileLineByLine(rd);
        copyFilelineByline(rd,wr);



        try {
            rd.close();
            wr.close();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }


    private void copyFileCharByChar(BufferedReader rd,PrintWriter wr){
        try {
            while (true){
                int ch=rd.read();
                if (-1==ch) break;
                System.out.print(ch);
                wr.write(ch);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private void copyFilelineByline(BufferedReader rd,PrintWriter wr){
        try {
            while (true){
                String line = rd.readLine();
                if (line == null) break;
                System.out.println(line);
                wr.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private void showFileCharByChar(BufferedReader rd) {
        try {
            while (true) {
                int ch = rd.read();
                if (ch == -1) break;
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private void showFileLineByLine(BufferedReader rd) {
        try {
            while (true) {
                String line = rd.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private PrintWriter openFileWriter(){

        PrintWriter printWriter=null;
        try {
            printWriter=new PrintWriter(new BufferedWriter(new FileWriter("ttgg")));
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        return printWriter;
    }

    private BufferedReader openFileReader(Scanner sysin, String prompt) {

        BufferedReader rd = null;
        try {
            System.out.print(prompt);
            String name = sysin.nextLine();
            rd = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.toString());
        }
        return rd;
    }

}
