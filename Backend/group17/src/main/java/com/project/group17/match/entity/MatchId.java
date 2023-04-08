package com.project.group17.match.entity;

import com.project.group17.user.entity.User;

import java.io.Serializable;
import java.util.Objects;

public class MatchId implements Serializable {
    private User user1;
    private User user2;


    public MatchId() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchId matchId = (MatchId) o;
        return Objects.equals(user1, matchId.user1) && Objects.equals(user2, matchId.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }
}
