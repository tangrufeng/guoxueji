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

	
	public static String baseUrl="http://localhost:8080/GXJ_APP_INTF";
	
	public static void testAddPlayTask(){
		String url=baseUrl+"/user/addPlayTask";
        String content = "{\"userToken\": \"6D07D2ED48CA11E69FC2F81654C0D75C\", \"deviceId\": \"11111\", \"tag\": \"fll\", " +
    	        "\"weekDay\": \"1,2,3\",\"begin\":\"10:00:00\",\"musics\":[{\"audio_id\":\"1\"},{\"audio_id\":\"2\"}," +
    	        "{\"audio_id\":\"3\"},{\"audio_id\":\"4\"},{\"audio_id\":\"5\"}]}";
        sendPost(url, content);
	}

	public static void testAddDevice(){
		String url=baseUrl+"/user/addDevice";
        String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"sn\":\"111111\",\"name\":\"xxxxx\",\"cityId\":\"12\",\"birthDay\":\"1985-10-17\"}";
        sendPost(url, content);
	}
	
    public static void main(String[] args) {
//        testAddPlayTask();
    	testAddDevice();
    }
    
	private static void sendPost(String URL1, String content) {
		HttpClient client = HttpClients.createDefault();

        HttpPost post=new HttpPost(URL1);
        StringEntity entity=new StringEntity(content,"utf-8");
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
