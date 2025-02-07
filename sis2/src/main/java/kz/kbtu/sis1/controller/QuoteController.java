package kz.kbtu.sis1.controller;

import kz.kbtu.sis1.model.Quote;
import kz.kbtu.sis1.model.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    @GetMapping("/random")
    public Quote quoteRandom(@RequestParam(name = "quote", defaultValue = "Hello world") String quote) {
        return new Quote("string", new Value(1L, "Quote that bro"));
    }
}
