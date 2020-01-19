package example.demo.index;

import example.Client;
import org.elasticsearch.action.admin.indices.shrink.ResizeRequest;
import org.elasticsearch.action.admin.indices.shrink.ResizeResponse;
import org.elasticsearch.action.admin.indices.shrink.ResizeType;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;

public class SplitIndexDemo {

    public static void main(String[] args) throws IOException {
        ResizeRequest resizeRequest = new ResizeRequest("target_index", "tsc");
        resizeRequest.setResizeType(ResizeType.SPLIT);
        resizeRequest.getTargetIndexRequest()
                .settings(Settings.builder()
                        .put("index.number_of_shards", 8)
                        .build());

        RestHighLevelClient client = Client.getClient();
        ResizeResponse resizeResponse = client.indices().split(resizeRequest, RequestOptions.DEFAULT);

        System.out.println(resizeResponse.isAcknowledged());
        System.out.println(resizeResponse.isShardsAcknowledged());

        client.close();
    }

}
