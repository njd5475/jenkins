package jenkins.slaves.systemInfo;

import org.jenkinsci.Symbol;

import com.dj.runner.locales.LocalizedString;

import hudson.Extension;

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
