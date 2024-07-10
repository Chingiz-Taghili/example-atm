package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {
    private List<Client> clients = new ArrayList<>();
    private static Data database = null;

    private Data() {
    }

    public static Data instance() {
        if (database == null) {
            database = new Data();
        }
        return database;
    }

    public List<Client> getClients() {
        return clients;
    }
}
