package com.bardiniww.customer.email;

import com.bardiniww.customer.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "email_data",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "email_data_email_unique",
                        columnNames = "email"
                )
        },
        indexes = {
                @Index(name = "email_data_user_id_idx", columnList = "user_id")
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailData {
    @Id
    @SequenceGenerator(
            name = "email_data_sequence",
            sequenceName = "email_data_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "email_data_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne(
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST}
    )
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "email_data_user_id_fkey"
            )
    )
    private User user;

    @Column(
            name = "email",
            nullable = false,
            length = 200
    )
    private String email;
}
