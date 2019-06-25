package jenkins.mvn;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;

import hudson.EnvVars;
import hudson.Extension;
import hudson.FilePath;
import hudson.LocalizedString;
import hudson.Util;
import hudson.model.AbstractBuild;
import hudson.model.TaskListener;
import hudson.util.IOUtils;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 * @author Dominik Bartholdi (imod)
 * @since 1.491
 */
public class FilePathGlobalSettingsProvider extends GlobalSettingsProvider {

    private final String path;

    @DataBoundConstructor
    public FilePathGlobalSettingsProvider(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public FilePath supplySettings(AbstractBuild<?, ?> build, TaskListener listener) {
        if (StringUtils.isEmpty(path)) {
            return null;
        }

        try {
            EnvVars env = build.getEnvironment(listener);
            String targetPath = Util.replaceMacro(this.path, build.getBuildVariableResolver());
            targetPath = env.expand(targetPath);

            if (IOUtils.isAbsolute(targetPath)) {
                return new FilePath(new File(targetPath));
            } else {
                FilePath mrSettings = build.getModuleRoot().child(targetPath);
                FilePath wsSettings = build.getWorkspace().child(targetPath);
                try {
                    if (!wsSettings.exists() && mrSettings.exists()) {
                        wsSettings = mrSettings;
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("failed to find settings.xml at: " + wsSettings.getRemote());
                }
                return wsSettings;
            }
        } catch (Exception e) {
            throw new IllegalStateException("failed to prepare global settings.xml");
        }

    }

    @Extension(ordinal = 10)
    public static class DescriptorImpl extends GlobalSettingsProviderDescriptor {

        @Override
        public String getDisplayName() {
            return LocalizedString.FilePathGlobalSettingsProvider_DisplayName.toString();
        }

    }
}
