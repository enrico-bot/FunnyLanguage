package parser;

public class Env {

    private final Frame frame;
    private final Env enclosing;

    Env(Frame frame, Env enclosing) {
        if (frame == null) {
            throw new IllegalArgumentException("Frame can't null");
        }
        this.frame = frame;
        this.enclosing = enclosing;
    }

    Val getVal(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id can't be null");
        }
        return frame.contains(id) ? frame.get(id) : enclosing.getVal(id);
    }

    public Val add(String id, Val val) {
        frame.add(id, val);
        return val;
    }
}