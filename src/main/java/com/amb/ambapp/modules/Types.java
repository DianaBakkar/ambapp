package com.amb.ambapp.modules;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Types")
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    private int type;
    private int valid;

    @OneToMany(mappedBy = "typeId")
    private List<AppUser> users;

    public Types(int id, int type, int valid) {
        this.id = id;
        this.type = type;
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}
