package example.demo.index;

import example.Client;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class OpenIndexDemo {

    public static void main(String[] args) throws IOException {
        OpenIndexRequest openIndexRequest = new OpenIndexRequest("tsc");

        RestHighLevelClient client = Client.getClient();
        OpenIndexResponse openIndexResponse = client.indices()
                .open(openIndexRequest, RequestOptions.DEFAULT);

        System.out.println(openIndexResponse.isAcknowledged());
        System.out.println(openIndexResponse.isShardsAcknowledged());

        client.close();
    }

}
