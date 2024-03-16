package net.hkapp.notes.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name="NOTES_TABLE")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NOTE_ID")
    private Integer noteId;

    @Column(name="TYPE")
    private String type;

    @Column(name="CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName="CLIENT_ID")
    private Client client;

    @CreationTimestamp
    @Column(name="CREATED_AT")
    private OffsetDateTime createdAt;

    @Column(name="UPDATED_AT")
    private OffsetDateTime updatedAt;

}
