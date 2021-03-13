package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    //Oefening 5.3
    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        //TO DO zie oefening 3
        return values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    //Oefening 5.4
    private void bubbleUp() {
        //TO DO : oefening 4
        int i = values.size() - 1;
        int ip = (i - 1) / 2;
        E objI = values.get(i);
        E objIp = values.get(ip);
        while (objI.compareTo(objIp) < 0) {
            Collections.swap(values, i, ip);
            i = ip;
            ip = (i - 1) / 2;
            objI = values.get(i);
            objIp = values.get(ip);
        }
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        // TODO zie oefening 5
        int i = 0;
        int ilc = 1; //index left child
        int irc = 2; //index right child
        E objectI = values.get(i);
        E objectIlc = values.get(ilc);
        E objectIrc = values.get(irc);
        int ic = (objectIlc.compareTo(objectIrc) < 0 ? ilc : irc);
        E objectIc = values.get(ic);
        while (objectIc.compareTo(objectI) < 0) {
            Collections.swap(values, i, ic);
            i = ic;
            ilc = 2 * i + 1;
            irc = 2 * i + 2;
            objectI = values.get(i);
            objectIlc = getObjectAtIndex(ilc);
            objectIrc = getObjectAtIndex(irc);
            if (objectIlc != null && objectIrc != null) {
                ic = (objectIlc.compareTo(objectIrc) < 0 ? ilc : irc);
            } else if (objectIlc == null && objectIrc == null) {
                return;
            } else {
                ic = ilc;
            }
            objectIc = values.get(ic);
        }
    }

    public E getObjectAtIndex(int i) {
        if (i <= values.size() - 1) {
            return values.get(i);
        }
        return null;
    }

    public ArrayList<E> getPath(E value) {
        // TODO zie oefening 6;
        ArrayList<E> result = new ArrayList<>();
        int index = values.indexOf(value);

        if (index == -1) {
            return null;
        } else {
            result.add(value);
            while (index > 0) {
                index = (index - 1) / 2;
                result.add(0,values.get(index));
            }
        }
        return result;
    }
}

