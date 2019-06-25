package jenkins.slaves.systemInfo;

import org.jenkinsci.Symbol;

import hudson.Extension;
import hudson.LocalizedString;

/**
 * @author Kohsuke Kawaguchi
 */
@Extension(ordinal=2) @Symbol("envVars")
public class EnvVarsSlaveInfo extends SlaveSystemInfo {
    @Override
    public String getDisplayName() {
        return LocalizedString.EnvVarsSlaveInfo_DisplayName.toString();
    }
}
