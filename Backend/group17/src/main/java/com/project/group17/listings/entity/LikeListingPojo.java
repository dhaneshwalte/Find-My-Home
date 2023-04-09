package com.project.group17.listings.entity;

/**
 * LikeListingPojo is a simple POJO class representing a liked listing.
 */
public class LikeListingPojo {

    private long listingID;

    /**
     * Returns the ID of the liked listing.
     *
     * @return The ID of the liked listing.
     */
    public long getListingId() {
        return listingID;
    }

    /**
     * Sets the ID of the liked listing.
     *
     * @param listingId The ID of the liked listing.
     */
    public void setListingId(long listingId) {
        this.listingID = listingId;
    }

}
