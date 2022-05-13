import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagementDirectory {
    List<Directory> directoryList = new ArrayList<>();
    ReadAndWriteCSV readAndWriteCSV = new ReadAndWriteCSV();



    public ManagementDirectory() throws IOException {
        readAndWriteCSV.readFile(directoryList);

    }

    public List<Directory> getDirectoryList() {
        return directoryList;
    }

    public void add(Directory directory) throws IOException {
        directoryList.add(directory);
        directory.setId(directoryList.size());
        readAndWriteCSV.writeFile(directory);
    }

    public void edit(int id, Directory directory) throws IOException {
        directoryList.set(findByID(id), directory);
        readAndWriteCSV.writeFile(directory);
    }

    public void delete(int id) {
        directoryList.remove(findByID(id));

    }

    public void showAll() {
        for (Directory dir :
                directoryList) {
            System.out.println(dir);
        }
    }

    public int findByName(String name) {
        for (int i = 0; i < directoryList.size(); i++) {
            if (directoryList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findByID(int id) {
        for (int i = 0; i < directoryList.size(); i++) {
            if (directoryList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
