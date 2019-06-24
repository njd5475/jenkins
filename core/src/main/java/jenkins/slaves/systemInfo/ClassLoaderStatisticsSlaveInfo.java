package jenkins.slaves.systemInfo;

import org.jenkinsci.Symbol;

import com.dj.runner.locales.LocalizedString;

import hudson.Extension;

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
