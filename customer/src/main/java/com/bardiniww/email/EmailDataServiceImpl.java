package com.bardiniww.email;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailDataServiceImpl implements EmailDataService {
    private final EmailDataRepository emailDataRepository;
}
