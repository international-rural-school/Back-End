package com.lambdaschool.ruralSchools.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Inventory", description = "The Inventory Entity")
@Entity
@Table(name = "inventory")
public class Inventory extends Auditable{
    @ApiModelProperty(name = "inventoryid", value = "Primary key for Inventory", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventoryid;
    @ApiModelProperty(name = "inventoryitem", value = "Inventory Item", required = true, example = "Chromebook")
    private String inventoryitem;

    private String isbn;

    private String copy;

    @ManyToMany(mappedBy = "inventory")
    @JsonIgnoreProperties("inventory")
    private List<Condition> condition = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "schoolid")
    @JsonIgnoreProperties("inventory")
    private School school;

    public Inventory() {
    }

    public Inventory(String inventoryitem, String isbn, String copy) {
        this.inventoryitem = inventoryitem;
        this.isbn = isbn;
        this.copy = copy;
    }

    public long getInventoryid() {
        return inventoryid;
    }

    public void setBookid(long inventoryid) {
        this.inventoryid = inventoryid;
    }

    public String getInventoryitem() {
        return inventoryitem;
    }

    public void setInventoryitem(String inventoryitem) {
        this.inventoryitem = inventoryitem;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Inventory{" + "inventoryid=" + inventoryid + ", inventoryitem='" + inventoryitem + '\'' + ", isbn='" + isbn + '\'' + ", copy='" + copy + '\'' + ", condition=" + condition + ", school=" + school + '}';
    }
}
