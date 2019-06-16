package hudson.util;

import java.security.SecureRandom;

import org.junit.rules.ExternalResource;

import hudson.Util;

/**
 * JUnit rule that cleans that sets a temporary {@link Secret#SECRET} value.
 *
 * @author Kohsuke Kawaguchi
 */
public class MockSecretRule extends ExternalResource {

    private String value;

    @Override
    protected void before() throws Throwable {
        byte[] random = new byte[32];
        sr.nextBytes(random);
        value = Util.toHexString(random);
        Secret.SECRET = value;
    }

    @Override
    protected void after() {
        if (!Secret.SECRET.equals(value))
            throw new IllegalStateException("Someone tinkered with Secret.SECRET");
        Secret.SECRET = null;
    }

    private static final SecureRandom sr = new SecureRandom();
}
