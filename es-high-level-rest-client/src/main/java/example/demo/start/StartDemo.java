package example.demo.start;

import example.Client;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class StartDemo {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = Client.getClient();
        client.close();
    }

}
