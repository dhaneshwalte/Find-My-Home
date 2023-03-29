package com.project.group17.group.entity;

import java.util.List;

public class GroupPojo {

    long groupID;
    double avgSimilarity;
    List<UserPojo> users;

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public double getAvgSimilarity() {
        return avgSimilarity;
    }

    public void setAvgSimilarity(double avgSimilarity) {
        this.avgSimilarity = avgSimilarity;
    }

    public List<UserPojo> getUsers() {
        return users;
    }

    public void setUsers(List<UserPojo> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "GroupPojo{" +
                "groupID=" + groupID +
                ", avgSimilarity=" + avgSimilarity +
                ", users=" + users +
                '}';
    }
}
