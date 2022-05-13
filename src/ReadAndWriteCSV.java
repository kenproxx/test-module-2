import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteCSV {

    File file = new File("directory.csv");
    Scanner scanner = new Scanner(file);


    public ReadAndWriteCSV() throws IOException {
    }

    public void readFile(List<Directory> directoryList) throws IOException {
        directoryList.clear();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(",");
            directoryList.add(new Directory(Integer.parseInt(arr[0]),arr[1], Integer.parseInt(arr[2]),arr[3],
                    Integer.parseInt(arr[4]),arr[5],arr[6] ));

        }
    }

    public void writeFile(Directory directory) throws IOException {
        FileWriter fileWriter = new FileWriter(file,true);
        String data = "\n" + directory.getId() + "," + directory.getNumberPhone() + "," +
                directory.getGroup() + "," + directory.getName() + "," + directory.getGender() + "," +
                directory.getAddress() + "," + directory.getEmail() ;
        fileWriter.write(data);
        fileWriter.close();
    }

}
