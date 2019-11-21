package com.jitihn.model;

import java.util.List;

public class Account {
    private String id;
    private String username;
    private String email;
    private List<String> realmRoles = null;
    private List<String> groups = null;
    private List<Object> credentials;
    private Boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRealmRoles() {
        return realmRoles;
    }

    public void setRealmRoles(List<String> realmRoles) {
        this.realmRoles = realmRoles;
    }

    public List<Object> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Object> credentials) {
        this.credentials = credentials;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Account [credentials=" + credentials + ", email=" + email + ", enabled=" + enabled + ", groups="
                + groups + ", id=" + id + ", realmRoles=" + realmRoles + ", username=" + username + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    // @Override
    // public String toString() {
    // return "Account [credentials=" + credentials + ", email=" + email + ",
    // enabled=" + enabled + ", realmRoles="
    // + realmRoles + ", username=" + username + "]";
    // }

}

class Credential {

    private String type;
    private Boolean temporary;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getTemporary() {
        return temporary;
    }

    public void setTemporary(Boolean temporary) {
        this.temporary = temporary;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Credential() {
    }
}