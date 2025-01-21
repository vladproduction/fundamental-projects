package edu.epam.fop.json.warehouse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.epam.fop.json.warehouse.item.Item;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface WarehouseReader {

    Collection<Item> readItems(InputStream data);

    static WarehouseReader getInstance() {
        return new WarehouseReader() {
            private final ObjectMapper objectMapper = new ObjectMapper();

            @Override
            public Collection<Item> readItems(InputStream data) {
                try {
                    objectMapper.registerModule(new JavaTimeModule());
                    List<Item> itemList = objectMapper.readValue(data, new TypeReference<>() {
                    });
//                    System.out.println("Items read: " + itemList); // Debugging line
                    return itemList != null ? itemList : Collections.emptyList();
                } catch (Exception e) {
                    e.printStackTrace();
                    return Collections.emptyList();
                }
            }
        };
    }
}


