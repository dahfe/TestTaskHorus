package testing;

import implementation.Folder;

public class SimpleFolder implements Folder {

    private String name;
    private String size;

    public SimpleFolder(String name, String size) {
        this.name = name;
        this.size = size;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Folder{name='" + name + "', size='" + size + "'}";
    }
}
