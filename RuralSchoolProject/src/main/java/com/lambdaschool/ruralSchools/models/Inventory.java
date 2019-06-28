package com.lambdaschool.ruralSchools.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "inventories")
public class Inventory extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventoriesid;

    @Column(nullable = false)
    private String inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties({"inventories", "hibernateLazyInitializer"})
    private User user;

    public Inventory()
    {
    }

    public Inventory(String inventory, User user)
    {
        this.inventory = inventory;
        this.user = user;
    }

    public long getInventoriesid()
    {
        return inventoriesid;
    }

    public void setInventoriesid(long inventoriesid)
    {
        this.inventoriesid = inventoriesid;
    }

    public String getInventory()
    {
        return inventory;
    }

    public void setInventory(String inventory)
    {
        this.inventory = inventory;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}