package example.demo.index;

import example.Client;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.IOException;

public class CreateIndexDemo {

    public static void main(String[] args) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("tsc");

        Settings settings = Settings.builder()
                .put("index.number_of_shards", 4)
                .put("index.number_of_replicas", 2)
                .put("index.blocks.write", true)
                .build();

        request.settings(settings);

        request.mapping(
                "{\n" +
                        "  \"properties\": {\n" +
                        "    \"message\": {\n" +
                        "      \"type\": \"text\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON);

        request.alias(new Alias("twitter_alias")
                .filter(QueryBuilders.termQuery("user", "kimchy")));

        RestHighLevelClient client = Client.getClient();
        CreateIndexResponse createIndexResponse = client.indices()
                .create(request, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse.isAcknowledged());
        System.out.println(createIndexResponse.isShardsAcknowledged());

        client.close();
    }


}
