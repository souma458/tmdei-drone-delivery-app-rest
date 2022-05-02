package pt.isep.tmdei.schedulerservice.client.implementation;

import lombok.Getter;

@Getter
public abstract class ServiceClient {

    private String url;
    private String prefix;

    public ServiceClient(final String url, final String prefix) {
        this.url = url;
        this.prefix = prefix;
    }

    public String basePath() {
        return url + prefix;
    }

}
