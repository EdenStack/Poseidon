package com.tneciv.poseidon.common;

/**
 * Created by Tneciv on 2017/3/25.
 */
public enum EnumType {
    Music("music", "期刊"),
    Musician("musician", "单曲"),
    Essays("essays", "专栏"),
    Event("event", "活动");

    EnumType(String typeName, String comment) {
        this.typeName = typeName;
        this.comment = comment;
    }

    private String typeName;
    private String comment;

    public String getTypeName() {
        return typeName;
    }

    public EnumType setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public EnumType setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
