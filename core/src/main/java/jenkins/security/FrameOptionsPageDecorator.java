package jenkins.security;

import org.jenkinsci.Symbol;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import hudson.Extension;
import hudson.model.PageDecorator;
import jenkins.util.SystemProperties;

/**
 * Adds the 'X-Frame-Options' header to all web pages.
 *
 * @since 1.581
 */
@Extension(ordinal = 1000) @Symbol("frameOptions")
public class FrameOptionsPageDecorator extends PageDecorator {
    @Restricted(NoExternalUse.class)
    public static boolean enabled = Boolean.valueOf(SystemProperties.getString(FrameOptionsPageDecorator.class.getName() + ".enabled", "true"));
}
