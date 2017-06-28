package com.baochengtech.model;

import com.baochengtech.commons.BaseModel;

public class UserActionsItemKey extends BaseModel {
    private Integer userId;

    private Integer actionsItemIt;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActionsItemIt() {
        return actionsItemIt;
    }

    public void setActionsItemIt(Integer actionsItemIt) {
        this.actionsItemIt = actionsItemIt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserActionsItemKey other = (UserActionsItemKey) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getActionsItemIt() == null ? other.getActionsItemIt() == null : this.getActionsItemIt().equals(other.getActionsItemIt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getActionsItemIt() == null) ? 0 : getActionsItemIt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", actionsItemIt=").append(actionsItemIt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}