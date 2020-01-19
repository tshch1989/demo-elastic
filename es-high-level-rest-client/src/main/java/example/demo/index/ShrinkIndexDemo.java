package example.demo.index;

import example.Client;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.shrink.ResizeRequest;
import org.elasticsearch.action.admin.indices.shrink.ResizeResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;

public class ShrinkIndexDemo {

    public static void main(String[] args) throws IOException {
        ResizeRequest request = new ResizeRequest("target_index","tsc");
        request.getTargetIndexRequest().settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .putNull("index.routing.allocation.require._name"));
        request.getTargetIndexRequest().alias(new Alias("target_alias"));
        RestHighLevelClient client = Client.getClient();
        ResizeResponse resizeResponse = client.indices()
                .shrink(request, RequestOptions.DEFAULT);

        System.out.println(resizeResponse.isAcknowledged());
        System.out.println(resizeResponse.isShardsAcknowledged());

        client.close();
    }

}
