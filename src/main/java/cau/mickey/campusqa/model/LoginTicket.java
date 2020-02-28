package cau.mickey.campusqa.model;

import java.util.Date;

/**
 * @author mickey
 * 数据库中login_ticket表
 * 邮箱验证
 */
public class LoginTicket {
    private int id;
    private int userId;
    private Date expired;
    private String ticket;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
