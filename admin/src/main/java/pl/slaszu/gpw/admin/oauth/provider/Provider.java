package pl.slaszu.gpw.admin.oauth.provider;

public enum Provider {
    GITHUB;

    public ProviderInterface getProviderImplementation() {
        if (this == Provider.GITHUB) {
            return new GithubProvider();
        }
        throw new RuntimeException("No provider implementation for %s !".formatted(this.toString()));
    }
}
