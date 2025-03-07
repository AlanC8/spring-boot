package kz.kbtu.sis1.dependency;

import kz.kbtu.sis1.model.Item;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public class Store {
    @Autowired
    @Qualifier("item1")
    private Item item;
}