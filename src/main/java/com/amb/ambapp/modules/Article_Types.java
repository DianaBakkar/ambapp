package com.amb.ambapp.modules;

import javax.persistence.*;
@Entity
@Table
public class Article_Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    private String label;
    @ManyToOne
    @JoinColumn(name = "typeId")
    private Articles article;

    public Article_Types(int id, String label) {
        this.id = id;
        this.label = label;
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
}
