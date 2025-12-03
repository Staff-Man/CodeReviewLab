import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class search{
    private String pattern;
    private File file;

    public search(String pattern, File file){
        this.pattern = pattern;
        this.file = file;
    }

    public void searchAndPrint(){
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(pattern)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            System.err.println("Error: File not found.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String pattern = args[0];
        String fileName = args[1];
        File file = new File(fileName);
        search s = new search(pattern, file);
        s.searchAndPrint();
    }
}