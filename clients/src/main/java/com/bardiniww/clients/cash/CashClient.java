package com.bardiniww.clients.cash;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "cash",
        url = "${clients.cash.url}"
)
public interface CashClient {
}
