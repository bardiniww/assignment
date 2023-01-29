package com.bardiniww.clients.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CustomerCreationResponseDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    @NonNull
    private Long userId;
    @NonNull
    private Long accountId;
    @NonNull
    private String name;
    @NonNull
    @JsonFormat(pattern="dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;
    @NonNull
    private String email;
    @NonNull
    private String phone;
}
