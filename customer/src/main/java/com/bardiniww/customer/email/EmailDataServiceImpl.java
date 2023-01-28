package com.bardiniww.customer.email;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailDataServiceImpl implements EmailDataService {
    private final EmailDataRepository emailDataRepository;

    @Override
    public boolean existsByEmail(@NonNull String email) {
        return emailDataRepository.existsByEmail(email);
    }

    @NonNull
    @Override
    public EmailData save(@NonNull final EmailData emailData) {
        return emailDataRepository.save(emailData);
    }
}
