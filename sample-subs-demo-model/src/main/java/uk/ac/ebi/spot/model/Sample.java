package uk.ac.ebi.spot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tburdett on 08/03/2016.
 */
@Entity
public class Sample {
    @Id
    @GeneratedValue
    private int accession;
    private String name;

    protected Sample() {
    }

    public Sample(String name) {
        this.name = name;
    }

    public int getAccession() {
        return accession;
    }

    public void setAccession(int accession) {
        this.accession = accession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "accession=" + accession +
                ", name='" + name + '\'' +
                '}';
    }
}
