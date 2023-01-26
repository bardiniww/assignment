package com.bardiniww.phone;

import com.bardiniww.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "phone_data",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "phone_data_phone_unique",
                        columnNames = "phone"
                )
        },
        indexes = {
                @Index(name = "phone_data_user_id_idx", columnList = "user_id")
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneData {
    @Id
    @SequenceGenerator(
            name = "phone_data_sequence",
            sequenceName = "phone_data_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "phone_data_sequence"
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
                    name = "phone_data_user_id_fkey"
            )
    )
    private User user;

    @Column(
            name = "phone",
            nullable = false,
            length = 13
    )
    private String phone;
}
