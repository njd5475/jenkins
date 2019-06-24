package jenkins.slaves.systemInfo;

import org.jenkinsci.Symbol;

import com.dj.runner.locales.LocalizedString;

import hudson.Extension;

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
