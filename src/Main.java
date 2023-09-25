import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Aidan McBride CSCI-2740 9/24/23

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean validfolder = false;
        boolean validsuffix = false;
        String suffix;

        System.out.println("File Search");
        System.out.println("Search for a particular type of file (.java, .docx, .jpg, etc.) in a folder");

        while (!validfolder) {
            System.out.print("Enter folder name that you wish to search: ");
            String folderinput = input.nextLine();
            File foldercheck = new File(folderinput);
            if (foldercheck.exists() && foldercheck.isDirectory()) {
                while (!validsuffix) {
                    try {
                        System.out.println("Enter suffix that you wish to search for: ");
                        suffix = input.nextLine();
                        search(foldercheck, suffix);
                        validsuffix = true;
                    } catch (IOException e) {
                        validsuffix = false;
                    }
                }
                validfolder = true;
            } else {
                System.out.println(foldercheck + " does not exist");
            }
        }

    }
    public static void search(File folder, String suffix) throws IOException {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            assert files != null;
            for (File f:files) {
                String file = f.toString();
                if (f.isDirectory()) search(f, suffix);
                else if (file.endsWith(suffix)) System.out.println(folder + file);
            }
        }
    }
}
