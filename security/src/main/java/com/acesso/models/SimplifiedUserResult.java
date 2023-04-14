package com.acesso.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "")
public class SimplifiedUserResult {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String name;
    @Column(name = "client_id")
    private Long clientId;
    private String email;
    private String image;

    private String password;
    @Column(name = "deprecated_password")
    private Boolean deprecatedPassword;

    @Column(name = "last_password_update")
    private java.sql.Timestamp lastPasswordUpdate;

    @Column(name = "user_validation_level")
    private String userValidationLevel;
    @Column(name = "two_factor_enabled")
    private Boolean twoFactorEnabled;
    @Column(name = "two_factor_activation_date")
    private java.sql.Timestamp twoFactorActivationDate;
    @Column(name = "two_factor_required")
    private Boolean twoFactorRequired;

    @Column(name = "social_name")
    private String socialName;

    public SimplifiedUserResult() {
    }

    public SimplifiedUserResult(String userId, String name, Long clientId, String email, String image, String password, Boolean deprecatedPassword, Timestamp lastPasswordUpdate, String userValidationLevel, Boolean twoFactorEnabled, Timestamp twoFactorActivationDate, Boolean twoFactorRequired, String socialName) {
        this.userId = userId;
        this.name = name;
        this.clientId = clientId;
        this.email = email;
        this.image = image;
        this.password = password;
        this.deprecatedPassword = deprecatedPassword;
        this.lastPasswordUpdate = lastPasswordUpdate;
        this.userValidationLevel = userValidationLevel;
        this.twoFactorEnabled = twoFactorEnabled;
        this.twoFactorActivationDate = twoFactorActivationDate;
        this.twoFactorRequired = twoFactorRequired;
        this.socialName = socialName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeprecatedPassword() {
        return deprecatedPassword;
    }

    public void setDeprecatedPassword(Boolean deprecatedPassword) {
        this.deprecatedPassword = deprecatedPassword;
    }

    public Timestamp getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setLastPasswordUpdate(Timestamp lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public String getUserValidationLevel() {
        return userValidationLevel;
    }

    public void setUserValidationLevel(String userValidationLevel) {
        this.userValidationLevel = userValidationLevel;
    }

    public Boolean getTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public Timestamp getTwoFactorActivationDate() {
        return twoFactorActivationDate;
    }

    public void setTwoFactorActivationDate(Timestamp twoFactorActivationDate) {
        this.twoFactorActivationDate = twoFactorActivationDate;
    }

    public Boolean getTwoFactorRequired() {
        return twoFactorRequired;
    }

    public void setTwoFactorRequired(Boolean twoFactorRequired) {
        this.twoFactorRequired = twoFactorRequired;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }
}
