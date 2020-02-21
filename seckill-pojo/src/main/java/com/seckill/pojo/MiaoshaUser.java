package com.seckill.pojo;

import java.io.Serializable;
import java.util.Date;

public class MiaoshaUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.NICKNAME
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.PASSWORD
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.SALT
     *
     * @mbg.generated
     */
    private String salt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.HEAD
     *
     * @mbg.generated
     */
    private String head;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.REGISTER_DATE
     *
     * @mbg.generated
     */
    private Date registerDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.LAST_LOGIN_DATE
     *
     * @mbg.generated
     */
    private Date lastLoginDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.LOGIN_COUNT
     *
     * @mbg.generated
     */
    private Integer loginCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user._SLOT
     *
     * @mbg.generated
     */
    private String slot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table miaosha_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.ID
     *
     * @return the value of miaosha_user.ID
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.ID
     *
     * @param id the value for miaosha_user.ID
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.NICKNAME
     *
     * @return the value of miaosha_user.NICKNAME
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.NICKNAME
     *
     * @param nickname the value for miaosha_user.NICKNAME
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.PASSWORD
     *
     * @return the value of miaosha_user.PASSWORD
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.PASSWORD
     *
     * @param password the value for miaosha_user.PASSWORD
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.SALT
     *
     * @return the value of miaosha_user.SALT
     *
     * @mbg.generated
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.SALT
     *
     * @param salt the value for miaosha_user.SALT
     *
     * @mbg.generated
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.HEAD
     *
     * @return the value of miaosha_user.HEAD
     *
     * @mbg.generated
     */
    public String getHead() {
        return head;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.HEAD
     *
     * @param head the value for miaosha_user.HEAD
     *
     * @mbg.generated
     */
    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.REGISTER_DATE
     *
     * @return the value of miaosha_user.REGISTER_DATE
     *
     * @mbg.generated
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.REGISTER_DATE
     *
     * @param registerDate the value for miaosha_user.REGISTER_DATE
     *
     * @mbg.generated
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.LAST_LOGIN_DATE
     *
     * @return the value of miaosha_user.LAST_LOGIN_DATE
     *
     * @mbg.generated
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.LAST_LOGIN_DATE
     *
     * @param lastLoginDate the value for miaosha_user.LAST_LOGIN_DATE
     *
     * @mbg.generated
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.LOGIN_COUNT
     *
     * @return the value of miaosha_user.LOGIN_COUNT
     *
     * @mbg.generated
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.LOGIN_COUNT
     *
     * @param loginCount the value for miaosha_user.LOGIN_COUNT
     *
     * @mbg.generated
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user._SLOT
     *
     * @return the value of miaosha_user._SLOT
     *
     * @mbg.generated
     */
    public String getSlot() {
        return slot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user._SLOT
     *
     * @param slot the value for miaosha_user._SLOT
     *
     * @mbg.generated
     */
    public void setSlot(String slot) {
        this.slot = slot == null ? null : slot.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", head=").append(head);
        sb.append(", registerDate=").append(registerDate);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", loginCount=").append(loginCount);
        sb.append(", slot=").append(slot);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}