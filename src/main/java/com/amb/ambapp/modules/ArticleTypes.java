package com.amb.ambapp.modules;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ArticleTypes")
public class ArticleTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="label")
    private String label;

    @OneToMany(mappedBy = "typeId")
    private List<Articles> article;

    public ArticleTypes(int id, String label) {
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
