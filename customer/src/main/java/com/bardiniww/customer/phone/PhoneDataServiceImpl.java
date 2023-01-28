package com.bardiniww.customer.phone;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneDataServiceImpl implements PhoneDataService {
    private final PhoneDataRepository phoneDataRepository;
}
