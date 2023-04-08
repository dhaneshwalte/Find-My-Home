package com.project.group17.listings.entity;
import com.project.group17.user.entity.User;
import jakarta.persistence.*;


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

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "file64", columnDefinition = "LONGBLOB")
    private String profilePicBase64;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "sfile64", columnDefinition = "LONGBLOB")
    private String secondProfilePicBase64;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ListingsEntity() {

    }
    public ListingsEntity(String type, String address, String utilities, float rent, String details, String profilePicBase64, String secondProfilePicBase64) {
        this.type = type;
        this.address = address;
        this.utilities = utilities;
        this.rent = rent;
        this.details = details;
        this.profilePicBase64 = profilePicBase64;
        this.secondProfilePicBase64 = secondProfilePicBase64;
    }

    public long getListingId() {
        return listingId;
    }

    public void setListingId(long listingId) {
        this.listingId = listingId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public float getRent() {
        return rent;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getProfilePicBase64() {
        return profilePicBase64;
    }

    public void setProfilePicBase64(String profilePicBase64) {
        this.profilePicBase64 = profilePicBase64;
    }

    public String getSecondProfilePicBase64() {
        return secondProfilePicBase64;
    }

    public void setSecondProfilePicBase64(String secondProfilePicBase64) {
        this.secondProfilePicBase64 = secondProfilePicBase64;
    }
}