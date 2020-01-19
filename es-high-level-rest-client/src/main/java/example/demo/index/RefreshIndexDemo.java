package example.demo.index;

import example.Client;
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.action.admin.indices.refresh.RefreshResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;

import java.io.IOException;

public class RefreshIndexDemo {

    public static void main(String[] args) throws IOException {
        RefreshRequest refreshRequest = new RefreshRequest("tsc");
//        RefreshRequest requestMultiple = new RefreshRequest("index1", "index2");
//        RefreshRequest requestAll = new RefreshRequest();
        refreshRequest.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);

        RefreshResponse refresh = Client.getClient().indices()
                .refresh(refreshRequest, RequestOptions.DEFAULT);

        System.out.println(refresh.getSuccessfulShards());
    }

}
