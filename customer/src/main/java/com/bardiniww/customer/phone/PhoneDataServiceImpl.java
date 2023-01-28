package com.bardiniww.customer.phone;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneDataServiceImpl implements PhoneDataService {
    private final PhoneDataRepository phoneDataRepository;

    @Override
    public boolean existsByPhone(@NonNull String email) {
        return phoneDataRepository.existsByPhone(email);
    }

    @NonNull
    @Override
    public PhoneData save(@NonNull final PhoneData phoneData) {
        return phoneDataRepository.save(phoneData);
    }
}
