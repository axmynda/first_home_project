import java.util.HashSet;


public class Shared {
    public HashSet<String> set;
    public volatile boolean end;

    public Shared() {
        this.end = false;
        this.set = new HashSet<String>();
    }
}
