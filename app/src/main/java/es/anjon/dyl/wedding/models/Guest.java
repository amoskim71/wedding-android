package es.anjon.dyl.wedding.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Guest {
    private String name;
    private boolean table;
    private String key;

    public Guest() {

    }

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isTable() {
        return table;
    }

    @Exclude
    public String getKey() {
        return key;
    }

    @Exclude
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Guest{ name='" + name + "'}";
    }
}
