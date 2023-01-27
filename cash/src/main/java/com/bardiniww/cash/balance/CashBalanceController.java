package com.bardiniww.cash.balance;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cash-balance")
@Slf4j
public class CashBalanceController {

    private final CashBalanceService cashBalanceService;

    @GetMapping(path = "{accountId}")
    public ResponseEntity<BigDecimal> getBalance(@NonNull @PathVariable("accountId") final Long accountId) {
        log.info("balance request for accountId={}", accountId);
        return ResponseEntity.ok(cashBalanceService.getBalance(accountId));
    }
}
