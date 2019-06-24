package jenkins.mvn;

import java.util.List;

import com.infradna.tool.bridge_method_injector.WithBridgeMethods;

import hudson.DescriptorExtensionList;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 * @since 1.491
 */
public abstract class SettingsProviderDescriptor extends Descriptor<SettingsProvider> {


    @WithBridgeMethods(List.class)
    public static DescriptorExtensionList<SettingsProvider,SettingsProviderDescriptor> all() {
        return Jenkins.getInstance().<SettingsProvider,SettingsProviderDescriptor>getDescriptorList(SettingsProvider.class);
    }
}
