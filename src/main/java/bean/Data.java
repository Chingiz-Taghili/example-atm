package bean;

import java.util.ArrayList;
import java.util.List;

public class Data {
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
