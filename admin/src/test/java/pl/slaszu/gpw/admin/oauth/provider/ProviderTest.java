package pl.slaszu.gpw.admin.oauth.provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProviderTest {

    @Test
    void getProviderImplementation() {

        Provider provider;
        ProviderInterface providerImplementation;

        provider = Provider.valueOf("GOOGLE");
        providerImplementation = provider.getProviderImplementation();
        assertEquals(GoogleProvider.class, providerImplementation.getClass());

        provider = Provider.valueOf("GITHUB");
        providerImplementation = provider.getProviderImplementation();
        assertEquals(GithubProvider.class, providerImplementation.getClass());

        assertThrows(IllegalArgumentException.class, () -> Provider.valueOf("NOTKNOW"));
    }
}