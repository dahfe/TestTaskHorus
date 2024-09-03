package testing;

import implementation.Folder;
import implementation.MultiFolder;

import java.util.List;

public class MultiFolderImpl extends SimpleFolder implements MultiFolder {
    private List<Folder> folders;

    public MultiFolderImpl(String name, String size, List<Folder> folders) {
        super(name, size);
        this.folders = folders;
    }

    @Override
    public List<Folder> getFolders() {
        return folders;
    }

    @Override
    public String toString() {
        return "MultiFolder{name='" + getName() + "', size='" + getSize() + "}";
    }
}
