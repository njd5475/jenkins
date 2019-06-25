package jenkins.slaves.systemInfo;

import org.jenkinsci.Symbol;

import hudson.Extension;
import hudson.LocalizedString;

/**
 * @author Kohsuke Kawaguchi
 */
@Extension(ordinal=1) @Symbol("threadDump")
public class ThreadDumpSlaveInfo extends SlaveSystemInfo {
    @Override
    public String getDisplayName() {
        return LocalizedString.ThreadDumpSlaveInfo_DisplayName.toString();
    }
}
