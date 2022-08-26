package com.photo.photoshare;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.json.jsonb.JsonbJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/26 09:15
 * @description
 */
@SpringBootApplication
public class PhotoshareEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoshareEsApplication.class, args);
    }

    @Bean
    public ElasticsearchClient init() throws IOException {


        List<String> hostList = Arrays.stream("xxx.xxx.xxx:xxx,xxx.xxx.xxx:xxx".split(",")).toList();
        HttpHost[] arrHost = hostList.stream().map(c -> new HttpHost(c.split(":")[0],
                Integer.parseInt(c.split(":")[1]), "http")).toList().toArray(new HttpHost[]{});
        // Create the low-level client
//        RestClient restClient = RestClient.builder(arrHost).build();
//        return new RestHighLevelClient(restClient);
        // Create the low-level client
        RestClient restClient = RestClient.builder(
                arrHost).build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client

        return new ElasticsearchClient(transport);
    }
}
