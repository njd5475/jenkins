package jenkins.slaves.systemInfo;

import org.jenkinsci.Symbol;

import hudson.Extension;
import hudson.LocalizedString;

/**
 * @author Kohsuke Kawaguchi
 */
@Extension(ordinal=3) @Symbol("systemProperties")
public class SystemPropertySlaveInfo extends SlaveSystemInfo {
    @Override
    public String getDisplayName() {
        return LocalizedString.SystemPropertySlaveInfo_DisplayName.toString();
    }
}
