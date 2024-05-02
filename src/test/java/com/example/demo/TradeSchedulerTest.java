package com.example.demo;


import com.example.demo.schedular.TradeScheduler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.awaitility.Awaitility.await;
import org.awaitility.Durations;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig(TradeStorageApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TradeSchedulerTest {

    @SpyBean
    private TradeScheduler tradeScheduler;

    @Test
    public void whenWaitOneSecond_thenScheduledIsCalledAtLeastTenTimes() {
        await()
                .atMost(Durations.ONE_MINUTE)
                .untilAsserted(() -> verify(tradeScheduler,atLeast(2)).reportCurrentTime());
    }
}
