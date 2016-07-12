import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

/**
 * Created by Tom on 16/7/11.
 */
public class Test {

    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault();
        String URL1="http://localhost:8080/user/addPlayTask";

        HttpPost post=new HttpPost(URL1);
        StringEntity entity=new StringEntity("{\"userId\": \"1\", \"deviceId\": \"11111\", \"tag\": \"fll\", " +
                "\"weekDay\": \"123\",\"begin\":\"10:00:00\",\"musics\":[{\"audio_id\":\"1\"},{\"audio_id\":\"2\"}," +
                "{\"audio_id\":\"3\"},{\"audio_id\":\"4\"},{\"audio_id\":\"5\"}]}","utf-8");
        entity.setContentType("application/json");
        post.setEntity(entity);
        try {
            HttpResponse resp = client.execute(post);
            if (resp.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                {
                    HttpEntity resEntity = resp.getEntity();
                    if (resEntity != null) {
                        String result = EntityUtils.toString(resEntity, "utf-8");
                        System.out.println("result = " + result);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
