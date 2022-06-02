package com.springboot.officesystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Embeddable
public class HistoryPK implements Serializable {

    private Long historyUserId;

    @Temporal(TemporalType.DATE)
    private Date loginDate;

    public HistoryPK() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHistoryUserId(), getLoginDate());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HistoryPK other = (HistoryPK) obj;

        return Objects.equals(getHistoryUserId(), other.getHistoryUserId())
                    && Objects.equals(getLoginDate(), other.getLoginDate());
    }

    public Long getHistoryUserId() {
        return historyUserId;
    }

    public void setHistoryUserId(Long historyUserId) {
        this.historyUserId = historyUserId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
