package StateLogic;

/**
 * Просто тапл чтобы не хранить координаты и размеры рамок поотдельности (в будущем может еще где пригодится)
 * @param <First>
 * @param <Second>
 * @version 1.0
 */
public class Pair<First, Second> {
    private First t;
    private Second u;

    /**
     *
     * @param t - первый объект
     * @param u - второй объект
     */
    public Pair(First t, Second u) {
        this.t = t;
        this.u = u;
    }

    public Pair() {
    }

    public First first() {
        return t;
    }

    public Second second() {
        return u;
    }
}
