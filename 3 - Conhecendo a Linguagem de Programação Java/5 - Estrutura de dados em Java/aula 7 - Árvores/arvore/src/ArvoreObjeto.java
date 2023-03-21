public abstract class ArvoreObjeto<T> implements Comparable<T> {

    public abstract boolean equals(Object obj);
    public abstract int hashCode();
    public abstract int compareTo(T outro);
    public abstract String toString();

}
