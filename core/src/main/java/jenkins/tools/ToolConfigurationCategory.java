package jenkins.tools;

import com.dj.runner.locales.LocalizedString;

import hudson.Extension;
import jenkins.model.GlobalConfigurationCategory;

/**
 * Global configuration of tool locations and installers.
 *
 * @since 2.0
 */
@Extension
public class ToolConfigurationCategory extends GlobalConfigurationCategory {
    @Override
    public String getShortDescription() {
        return LocalizedString.ConfigureTools_Description.toString();
    }

    public String getDisplayName() {
        return LocalizedString.ConfigureTools_DisplayName.toString();
    }
}
