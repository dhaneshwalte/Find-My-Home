package com.project.group17.prefValues.entity;

import com.project.group17.prefNames.entity.PrefNamesEntity;
import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.user.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "pref_value")
public class PrefValuesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long prefValueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "pref_option_id", nullable = true)
    private PrefOptionsEntity prefOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pref_name_id", nullable = false)
    private PrefNamesEntity prefName;

    public Long getPrefValueId() {
        return prefValueId;
    }

    public void setPrefValueId(Long prefValueId) {
        this.prefValueId = prefValueId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PrefOptionsEntity getPrefOption() {
        return prefOption;
    }

    public void setPrefOption(PrefOptionsEntity prefOption) {
        this.prefOption = prefOption;
    }

    public PrefNamesEntity getPrefName() {
        return prefName;
    }

    public void setPrefName(PrefNamesEntity prefName) {
        this.prefName = prefName;
    }
}
