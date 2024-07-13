package bean;

import util.File;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {
    private List<Client> clients = new ArrayList<>();
    private static Data data = null;

    private Data() {
    }

    public static void initialize() {
        Object object = File.readObject("Database.obj");
        if (object == null) {
            return;
        }
        if (object instanceof Data) {
            data = (Data) object;
        }
    }

    public static Data instance() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }

    public List<Client> getClients() {
        return clients;
    }
}
