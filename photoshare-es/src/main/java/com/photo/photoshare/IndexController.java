package com.photo.photoshare;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/25 19:40
 * @description
 */
@RestController
public class IndexController {
    @Autowired
    ElasticsearchClient client;

    @GetMapping("/es")
    public String es() throws IOException {

        SearchResponse<String> search = client.search(s -> s
                        .index("newoms-pro-package-info")
                        .query(q -> q
                                .term(t -> t
                                        .field("yksOrderId")
                                        .value(v -> v.stringValue("WH2009020915007105"))
                                )),
                String.class);

        for (Hit<String> hit : search.hits().hits()) {
            return hit.source();
        }
        return null;
    }
}
