package com.lambdaschool.ruralSchools.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long schoolid;

    private String schoolname;

    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("inventory")
    private List<Inventory> inventory = new ArrayList<>();

    public School() {
    }

    public School(String schoolname) {
        this.schoolname = schoolname;
    }

    public long getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(long schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> books) {
        this.inventory = inventory;
    }
}
