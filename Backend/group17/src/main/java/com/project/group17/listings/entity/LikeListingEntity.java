package com.project.group17.listings.entity;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.user.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name="listings_liked")
public class LikeListingEntity {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToOne
    @JoinColumn(name = "user")
    private User user;


    @ManyToOne
    @JoinColumn(name = "listings")
    private ListingsEntity listingsEntity;

    public ListingsEntity getListingsEntity() {
        return listingsEntity;
    }

    public void setListingsEntity(ListingsEntity listingsEntity) {
        this.listingsEntity = listingsEntity;
    }
}
