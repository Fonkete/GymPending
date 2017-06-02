package fonket.gympending.models;

import com.orm.SugarRecord;

/**
 * Created by felip on 27-05-2017.
 */

public class Exercise extends SugarRecord {

    private String name;
    private int time;
    private boolean watched;

    public Exercise() {
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
