package com.lambdaschool.ruralSchools.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Condition", description = "The Condition Entity")
@Entity
@Table(name = "condition")
public class Condition extends Auditable {
    @ApiModelProperty(name = "conditionid", value = "Primary key for Author", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long conditionid;

    @ApiModelProperty(name = "conditionstate", value = "State Of Inventory item", required = true, example = "Jane")
    private String conditionstate;
//    @ApiModelProperty(name = "authorlname", value = "Authors Last Name", required = true, example = "Doe")
//    private String authorlname;

    @ManyToMany
    @JoinTable(name = "inventorycondition",
            joinColumns = {@JoinColumn(name = "conditionid")},
            inverseJoinColumns = {@JoinColumn(name = "inventoryid")})
    @JsonIgnoreProperties("books")
    private List<Inventory> inventory = new ArrayList<>();

    public Condition() {
    }

    public Condition(String conditionstate) {
        this.conditionstate = conditionstate;
    }

    public long getConditionid() {
        return conditionid;
    }

    public void setConditionid(long authorid) {
        this.conditionid = authorid;
    }

    public String getConditionstate() {
        return conditionstate;
    }

    public void setConditionstate(String conditionstate) {
        this.conditionstate = conditionstate;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
}