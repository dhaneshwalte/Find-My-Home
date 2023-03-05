package com.project.group17.prefValues.entity;

import com.project.group17.prefNames.entity.prefNamesEntity;
import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.user.entity.User;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "prefValue")
public class PrefValuesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long prefValueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pref_option_id", nullable = false)
    private PrefOptionsEntity prefOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pref_name_id", nullable = false)
    private prefNamesEntity prefName;

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

    public prefNamesEntity getPrefName() {
        return prefName;
    }

    public void setPrefName(prefNamesEntity prefName) {
        this.prefName = prefName;
    }
}
