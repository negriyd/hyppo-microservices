package org.petproject

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicInteger

@Slf4j
@RestController
@SpringBootApplication
public class RentApplication {
    public static final int DEFAULT_PADDING = 50
    public static final hippoCount = new AtomicInteger(Integer.MAX_VALUE)

    public static void main(String[] args) {
        println 'Starting'.center(DEFAULT_PADDING, '=')
        SpringApplication.run RentApplication, args
        println 'Started'.center(DEFAULT_PADDING, '=')
    }

    @RequestMapping
    def rent(@RequestParam(value = "count", defaultValue = "1") Integer count) {
        def fee = 0
        def hippoRemain = hippoCount.addAndGet(-1 * count)
        return [
                hippoRemain: hippoRemain,
                fee: fee
        ]
    }
}