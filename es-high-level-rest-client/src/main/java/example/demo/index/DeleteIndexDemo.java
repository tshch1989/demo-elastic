package example.demo.index;

import example.Client;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class DeleteIndexDemo {

    public static void main(String[] args) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("tsc");

        RestHighLevelClient client = Client.getClient();
        AcknowledgedResponse response = client.indices()
                .delete(request, RequestOptions.DEFAULT);

        System.out.println(response.isAcknowledged());

        client.close();
    }

}
