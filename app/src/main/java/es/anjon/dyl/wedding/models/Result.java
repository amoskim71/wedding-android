package es.anjon.dyl.wedding.models;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Result {

    public static final String QUIZ_KEY = "quiz";
    public static final String TABLES_KEY = "tables";
    public static final String RESULTS_KEY = "results";
    private int score;
    private String table;

    public Result() {

    }

    public Result(int score, String table) {
        this.score = score;
        this.table = table;
    }

    public int getScore() {
        return score;
    }

    public String getTable() {
        return table;
    }

    @Exclude
    public void save() {
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mTablesRef = mDatabase.getReference(QUIZ_KEY).child(TABLES_KEY);
        DatabaseReference mResultRef = mTablesRef.child(getTable()).child(RESULTS_KEY).push();
        mResultRef.setValue(this);
        Log.i("Result", "Result has been saved as " + mResultRef.getKey());
    }

}
