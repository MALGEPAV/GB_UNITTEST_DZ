package seminars.fourth.http;

public class WebService {
    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String httpRequest(String url){
        return httpClient.get(url);
    }
}
