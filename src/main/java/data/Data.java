package data;

import bean.OrdinaryClient;
import bean.PremiumClient;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<OrdinaryClient> orClnts = new ArrayList<>();
    private List<PremiumClient> prClnts = new ArrayList<>();
    private static Data database = null;

    private Data() {
    }
    public static Data instance(){
        if (database == null) {
            database = new Data();
        }
        return database;
    }

    public List<OrdinaryClient> getOrClnts() {
        return orClnts;
    }

    public List<PremiumClient> getPrClnts() {
        return prClnts;
    }
}
