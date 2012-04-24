/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gerardo
 */
public class Alumno {

    private int _id = 0;
    private String _nombre = "";
    private double _nota = 0;
    private HashSet<Integer>  _enemigos;

    public Alumno(int id, int nota) {
        _id = id;
        _nota = nota;
        _enemigos = new HashSet<Integer>();
    }

    public int getId() {
        return _id;
    }

    public double getNota() {
        return _nota;
    }

    public Set<Integer> getEnemigos() {
        return _enemigos;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        _nombre = nombre;
    }
}
