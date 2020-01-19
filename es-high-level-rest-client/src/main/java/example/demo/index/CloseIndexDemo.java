package example.demo.index;

import example.Client;
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class CloseIndexDemo {


    public static void main(String[] args) throws IOException {
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest("tsc");

        RestHighLevelClient client = Client.getClient();
        AcknowledgedResponse close = client.indices()
                .close(closeIndexRequest, RequestOptions.DEFAULT);

        System.out.println(close.isAcknowledged());

        client.close();
    }

}
