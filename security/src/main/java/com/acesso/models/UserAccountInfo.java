package com.acesso.models;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserAccountInfo {
    private boolean deprecatedDetails;
    private boolean deprecatedPassword;
    private Optional<Boolean> hasPassword;
    private Optional<LocalDateTime> lastPasswordUpdate;
    private Optional<LocalDateTime> passwordExpirationDate;
    private boolean has2FA;
    private boolean twoFactorRequired;
    private Optional<LocalDateTime> twoFactorActivationDate;

    public UserAccountInfo() {}

    public UserAccountInfo(boolean deprecatedDetails, boolean deprecatedPassword, Boolean hasPassword, LocalDateTime lastPasswordUpdate, LocalDateTime passwordExpirationDate, boolean has2FA, boolean twoFactorRequired, LocalDateTime twoFactorActivationDate) {
        this.deprecatedDetails = deprecatedDetails;
        this.deprecatedPassword = deprecatedPassword;
        this.hasPassword = Optional.ofNullable(hasPassword);
        this.lastPasswordUpdate = Optional.ofNullable(lastPasswordUpdate);
        this.passwordExpirationDate = Optional.ofNullable(passwordExpirationDate);
        this.has2FA = has2FA;
        this.twoFactorRequired = twoFactorRequired;
        this.twoFactorActivationDate = Optional.ofNullable(twoFactorActivationDate);
    }

    public boolean isDeprecatedDetails() {
        return deprecatedDetails;
    }

    public void setDeprecatedDetails(boolean deprecatedDetails) {
        this.deprecatedDetails = deprecatedDetails;
    }

    public boolean isDeprecatedPassword() {
        return deprecatedPassword;
    }

    public void setDeprecatedPassword(boolean deprecatedPassword) {
        this.deprecatedPassword = deprecatedPassword;
    }

    public Optional<Boolean> getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(Optional<Boolean> hasPassword) {
        this.hasPassword = hasPassword;
    }

    public Optional<LocalDateTime> getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setLastPasswordUpdate(Optional<LocalDateTime> lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public Optional<LocalDateTime> getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    public void setPasswordExpirationDate(Optional<LocalDateTime> passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
    }

    public boolean isHas2FA() {
        return has2FA;
    }

    public void setHas2FA(boolean has2FA) {
        this.has2FA = has2FA;
    }

    public boolean isTwoFactorRequired() {
        return twoFactorRequired;
    }

    public void setTwoFactorRequired(boolean twoFactorRequired) {
        this.twoFactorRequired = twoFactorRequired;
    }

    public Optional<LocalDateTime> getTwoFactorActivationDate() {
        return twoFactorActivationDate;
    }

    public void setTwoFactorActivationDate(Optional<LocalDateTime> twoFactorActivationDate) {
        this.twoFactorActivationDate = twoFactorActivationDate;
    }
}
