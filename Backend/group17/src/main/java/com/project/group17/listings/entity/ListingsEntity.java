package com.project.group17.listings.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "listings")
public class ListingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long listingId;
    private String type;
    private String address;
    private String utilities;
    private float rent;
    private String details;
    public ListingsEntity()
    {
    }
    public long getListingId()
    {
        return listingId;
    }
    public void setListingId(long listingId )
    {
        this. listingId=listingId;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type= type;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getUtilities()
    {
        return utilities;
    }
    public void setUtilities(String utilities)
    {
        this.utilities=utilities;
    }
    public float getRent()
    {
        return rent;
    }
    public void setRent(float rent)
    {
        this.rent=rent;
    }
    public String getDetails()
    {
        return details;
    }
    public void setDetails(String details)
    {
        this.details=details;
    }
}