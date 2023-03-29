package com.project.group17.prefValues.model;

public class PrefValueSaveReq {
    private Long prefNameId;

    private Long prefOptionId;

    public Long getPrefNameId() {
        return prefNameId;
    }

    public void setPrefNameId(Long prefNameId) {
        this.prefNameId = prefNameId;
    }

    public Long getPrefOptionId() {
        return prefOptionId;
    }

    public void setPrefOptionId(Long prefOptionId) {
        this.prefOptionId = prefOptionId;
    }

    @Override
    public String toString() {
        return "PrefValueSaveReq{" +
                "prefNameId=" + prefNameId +
                ", prefOptionId=" + prefOptionId +
                '}';
    }
}
