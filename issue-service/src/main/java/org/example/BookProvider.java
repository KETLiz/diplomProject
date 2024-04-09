package org.example;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class BookProvider {
    private WebClient client;
    private EurekaClient eurekaClient;

    public BookProvider(EurekaClient eurekaClient) {
        client = WebClient.builder().build();
        this.eurekaClient = eurekaClient;
    }

    public int getBookId(int idBook) {
        Book book = client.get()
                .uri(getBookServiceIp() + "/books/" + idBook)
                .retrieve()
                .bodyToMono(Book.class)
                .block();
        return book.getIdBook();
    }

    private String getBookServiceIp() {
        Application application = eurekaClient.getApplication("BOOK-SERVICE");
        List<InstanceInfo> instanceInfoList = application.getInstances();
        InstanceInfo instanceInfo = instanceInfoList.get(0);

        return "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort();
    }
}
