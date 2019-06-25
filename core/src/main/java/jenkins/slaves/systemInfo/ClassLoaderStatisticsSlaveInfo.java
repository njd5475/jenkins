package jenkins.slaves.systemInfo;

import org.jenkinsci.Symbol;

import hudson.Extension;
import hudson.LocalizedString;

/**
 * @author Kohsuke Kawaguchi
 */
@Extension(ordinal=0) @Symbol("classLoaderStatistics")
public class ClassLoaderStatisticsSlaveInfo extends SlaveSystemInfo {
    @Override
    public String getDisplayName() {
        return LocalizedString.ClassLoaderStatisticsSlaveInfo_DisplayName.toString();
    }
}
