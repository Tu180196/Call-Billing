package com.example.mobilebilling.persistence.enity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "call_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallRecord extends AuditableEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "call_duration", nullable = false)
    private Integer callDuration;

    @Column(name = "block_count", nullable = false)
    private Integer blockCount;

}
