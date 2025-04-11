package com.fiipractic;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_history")
public class RequestHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endpointCalled;
    private LocalDateTime requestTime;

    // Assuming you have a User entity in your project. Update the import/package as needed.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity.User user;

    public RequestHistoryEntity() {
    }

    public RequestHistoryEntity(String endpointCalled, LocalDateTime requestTime, UserEntity.User user) {
        this.endpointCalled = endpointCalled;
        this.requestTime = requestTime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getEndpointCalled() {
        return endpointCalled;
    }

    public void setEndpointCalled(String endpointCalled) {
        this.endpointCalled = endpointCalled;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public UserEntity.User getUser() {
        return user;
    }

    public void setUser(UserEntity.User user) {
        this.user = user;
    }
}
