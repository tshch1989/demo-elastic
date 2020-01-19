package example;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Client {

    private static RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(HttpHost.create("http://localhost:9200"))
    );

    private Client(){}

    public static RestHighLevelClient getClient(){
        return client;
    }

}
