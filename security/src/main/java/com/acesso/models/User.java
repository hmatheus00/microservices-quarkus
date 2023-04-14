package com.acesso.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", schema = "security")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String name;
    private String email;
    private String image;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "user_validation_level")
    private String levelValidation;

    public User() {}

    public User(String userId, String name, String email, String image, LocalDateTime createDate, LocalDateTime lastUpdate, Long clientId, String levelValidation) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.image = image;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.clientId = clientId;
        this.levelValidation = levelValidation;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getLevelValidation() {
        return levelValidation;
    }

    public void setLevelValidation(String levelValidation) {
        this.levelValidation = levelValidation;
    }
}
