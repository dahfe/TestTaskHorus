package testing;

import implementation.FileCabinet;
import implementation.Folder;
import implementation.MultiFolder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Folder folderA = new SimpleFolder("FolderA", "SMALL");
        Folder folderB = new SimpleFolder("FolderB", "MEDIUM");
        Folder folderC = new SimpleFolder("FolderC", "LARGE");

        Folder subFolder1 = new SimpleFolder("SubFolder1", "SMALL");
        Folder subFolder2 = new SimpleFolder("SubFolder2", "MEDIUM");

        Folder subSubFolder1 = new SimpleFolder("SubSubFolder1", "LARGE");
        MultiFolder subFolder3 = new MultiFolderImpl("SubFolder3", "SMALL", Arrays.asList(subSubFolder1));

        MultiFolder multiFolder1 = new MultiFolderImpl("MultiFolder1", "LARGE", Arrays.asList(subFolder1, subFolder2));
        MultiFolder multiFolder2 = new MultiFolderImpl("MultiFolder2", "MEDIUM", Arrays.asList(subFolder3));

        List<Folder> folders = Arrays.asList(folderA, folderB, folderC, multiFolder1, multiFolder2);
        FileCabinet fileCabinet = new FileCabinet(folders);

        System.out.println("Find by name 'MultiFolder1': " + fileCabinet.findFolderByName("MultiFolder1").orElse(null));
        System.out.println("Find by size 'LARGE': " + fileCabinet.findFoldersBySize("LARGE"));
        System.out.println("Total count: " + fileCabinet.count());  // Ожидается 6
    }
}
