package example.demo.index;

import example.Client;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;

import java.io.IOException;

public class ExistsIndexDemo {

    public static void main(String[] args) throws IOException {
        GetIndexRequest request = new GetIndexRequest("tsc");
        RestHighLevelClient client = Client.getClient();
        boolean exists = client.indices()
                .exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
        client.close();
    }

}
