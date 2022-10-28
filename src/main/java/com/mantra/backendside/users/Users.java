package com.mantra.backendside.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mantra.backendside.todo.Todo;
import com.mantra.backendside.wallpapers.Wallpapers;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String wallpapersMapJSON;
    @Convert(converter = HashMapConverter.class)
    private Map<String, Wallpapers> wallpapersMap;
    private String todosMapJSON;
    @Convert(converter = HashMapConverter.class)
    private Map<String, Todo> todosMap;
    private boolean enabled;
    private boolean tokenExpired;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void serializeWallpapersMap() throws JsonProcessingException {
        this.wallpapersMapJSON = objectMapper.writeValueAsString(wallpapersMap);
    }

    public void deserializeWallpapersMap() throws IOException {
        this.wallpapersMap = objectMapper.readValue(wallpapersMapJSON, HashMap.class);
    }

    public void serializeTodoMap() throws JsonProcessingException {
        this.todosMapJSON = objectMapper.writeValueAsString(todosMap);
    }

    public void deserializeTodosMap() throws IOException {
        this.todosMap = objectMapper.readValue(todosMapJSON, HashMap.class);
    }

}
