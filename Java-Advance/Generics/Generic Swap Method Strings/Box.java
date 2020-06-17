package SoftUni.JavaAdvance.Generics.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<E> {
    private E data;

    public Box(E data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + this.data;
    }
}
