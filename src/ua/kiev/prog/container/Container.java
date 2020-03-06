package ua.kiev.prog.container;

public class Container {

    @Save(path = "c:\\develop\\container.txt", method = "save")
    private String stringData;

    public Container(String stringData) {
        this.stringData = stringData;
    }

}
