package com.amb.ambapp.modules;
import javax.persistence.*;
@Entity
@Table
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    private String label;
    private int valid;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Users user;

    public Types(int id, String label, int valid) {
        this.id = id;
        this.label = label;
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}
