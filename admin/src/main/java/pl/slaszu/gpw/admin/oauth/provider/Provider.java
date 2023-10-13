package pl.slaszu.gpw.admin.oauth.provider;

public enum Provider {
    GITHUB, GOOGLE;

    public ProviderInterface getProviderImplementation() {
        if (this == Provider.GITHUB) {
            return new GithubProvider();
        }
        if (this == Provider.GOOGLE) {
            return new GoogleProvider();
        }
        throw new RuntimeException("No provider implementation for %s !".formatted(this.toString()));
    }
}
