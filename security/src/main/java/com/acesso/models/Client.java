package com.acesso.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "clients", schema = "security")
public class Client extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "external_id")
    private String externalId;

    private String password;

    private String type;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    private Boolean enabled;

    private Long tokens;

    @Column(name = "deprecated_password")
    private Boolean deprecatedPassword;

    @Column(name = "last_password_update")
    private java.sql.Timestamp lastPasswordUpdate;

    @Column(name = "can_activate")
    private Boolean canActivate;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public java.sql.Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getTokens() {
        return tokens;
    }

    public void setTokens(Long tokens) {
        this.tokens = tokens;
    }

    public Boolean getDeprecatedPassword() {
        return deprecatedPassword;
    }

    public void setDeprecatedPassword(Boolean deprecatedPassword) {
        this.deprecatedPassword = deprecatedPassword;
    }

    public java.sql.Timestamp getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setLastPasswordUpdate(java.sql.Timestamp lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public Boolean getCanActivate() {
        return canActivate;
    }

    public void setCanActivate(Boolean canActivate) {
        this.canActivate = canActivate;
    }
}