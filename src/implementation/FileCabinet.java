package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileCabinet implements Cabinet{

    private List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
    }
    @Override
    public Optional<Folder> findFolderByName(String name) {
        for (Folder folder : folders) {
            Optional<Folder> found = findFolderByName(folder, name);
            if (found.isPresent()) {
                return found;
            }
        }
        return Optional.empty();
    }

    private Optional<Folder> findFolderByName(Folder folder, String name) {
        if (folder.getName().equals(name)) {
            return Optional.of(folder);
        }
        if (folder instanceof MultiFolder) {
            for (Folder subFolder : ((MultiFolder) folder).getFolders()) {
                Optional<Folder> found = findFolderByName(subFolder, name);
                if (found.isPresent()) {
                    return found;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        List<Folder> result = new ArrayList<>();
        for (Folder folder : folders) {
            findFoldersBySize(folder, size, result);
        }
        return result;
    }

    private void findFoldersBySize(Folder folder, String size, List<Folder> result) {
        if (folder.getSize().equals(size)) {
            result.add(folder);
        }
        if (folder instanceof MultiFolder) {
            for (Folder subFolder : ((MultiFolder) folder).getFolders()) {
                findFoldersBySize(subFolder, size, result);
            }
        }
    }

    @Override
    public int count() {
        return countFolders(folders);
    }

    private int countFolders(List<Folder> folders) {
        int count = folders.size();
        for (Folder folder : folders) {
            if (folder instanceof MultiFolder) {
                count += countFolders(((MultiFolder) folder).getFolders());
            }
        }
        return count;
    }
}
