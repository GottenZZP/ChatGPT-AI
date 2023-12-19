package top.gottenzzp.chatbot.ai;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    // 测试方法，用于向特定的API发送GET请求并打印响应
    @Test
    public void query_unanswered_question() throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建HttpGet对象，并设置请求的URL
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        // 添加请求头
        get.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218be7e8353ad11-0358fc471374606-7e433c49-3686400-18be7e8353b2233%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiZTdlODM1M2FkMTEtMDM1OGZjNDcxMzc0NjA2LTdlNDMzYzQ5LTM2ODY0MDAtMThiZTdlODM1M2IyMjMzIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218be7e8353ad11-0358fc471374606-7e433c49-3686400-18be7e8353b2233%22%7D; abtest_env=product; zsxqsessionid=a413b4bae40130da721b61589ebcc7bf; zsxq_access_token=BCF34E4A-6922-1B0F-5D90-CBC85BD43E0A_857BC3148B938F69");
        get.addHeader("Content-Type", "application/json;charset=UTF-8");
        get.addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0");

        // 执行请求并获取响应
        CloseableHttpResponse response = httpClient.execute(get);
        // 判断响应状态并打印结果
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    // 测试方法，用于向特定的API发送POST请求并打印响应
    @Test
    public void answer() throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建HttpPost对象，并设置请求的URL
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/188152525218512/comments");
        // 添加请求头
        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218be7e8353ad11-0358fc471374606-7e433c49-3686400-18be7e8353b2233%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiZTdlODM1M2FkMTEtMDM1OGZjNDcxMzc0NjA2LTdlNDMzYzQ5LTM2ODY0MDAtMThiZTdlODM1M2IyMjMzIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218be7e8353ad11-0358fc471374606-7e433c49-3686400-18be7e8353b2233%22%7D; abtest_env=product; zsxqsessionid=a413b4bae40130da721b61589ebcc7bf; zsxq_access_token=BCF34E4A-6922-1B0F-5D90-CBC85BD43E0A_857BC3148B938F69");
        post.addHeader("Content-Type", "application/json;charset=UTF-8");
        post.addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0");


        // 设置请求体
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"ccc\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "UTF-8"));
        post.setEntity(stringEntity);

        // 执行请求并获取响应
        CloseableHttpResponse response = httpClient.execute(post);
        // 判断响应状态并打印结果
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}