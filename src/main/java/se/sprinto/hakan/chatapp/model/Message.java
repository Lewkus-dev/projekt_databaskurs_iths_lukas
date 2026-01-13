package se.sprinto.hakan.chatapp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @Column(name="message", nullable = false)
    private String text;

    @Column(name="message_date", nullable = false)
    private LocalDateTime timestamp;



    public Message(User user, String text, LocalDateTime timestamp) {
        this.user = user;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Message(){

    }

    public Long getId() {
        return message_id;
    }

    public void setId(Long message_id) {
        this.message_id = message_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
