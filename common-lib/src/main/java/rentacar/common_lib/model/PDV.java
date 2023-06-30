/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Somika
 */
public class PDV implements Serializable {

    private Long id;
    private double percent;

    public PDV() {
    }

    public PDV(Long id, double percent) {
        this.id = id;
        this.percent = percent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Percentage cannot be negative.");
        }
        this.percent = percent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PDV other = (PDV) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return percent + "";
    }

}
